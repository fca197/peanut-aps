package com.olivia.peanut.aps.service.impl;

import static java.lang.Boolean.TRUE;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathDto;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathQueryListReq;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
import com.olivia.peanut.aps.service.ApsFactoryService;
import com.olivia.peanut.aps.service.ApsProcessPathService;
import com.olivia.peanut.aps.service.ApsProduceProcessItemService;
import com.olivia.peanut.aps.service.pojo.FactoryConfigReq;
import com.olivia.peanut.aps.service.pojo.FactoryConfigRes;
import com.olivia.peanut.aps.utils.model.ShiftItemVo;
import com.olivia.peanut.aps.utils.process.ProcessUtils;
import com.olivia.peanut.base.model.Shift;
import com.olivia.peanut.base.model.ShiftItem;
import com.olivia.peanut.base.service.CalendarService;
import com.olivia.peanut.base.service.ShiftItemService;
import com.olivia.peanut.base.service.ShiftService;
import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.exception.RunException;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.JSON;
import com.olivia.sdk.utils.RunUtils;
import com.olivia.sdk.utils.model.WeekInfo;
import jakarta.annotation.Resource;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/***
 *
 */

@Slf4j
@Service
public class ApsFactoryServiceImpl implements ApsFactoryService {

  static final Cache<String, List<WeekInfo>> factoryWeekInfoCache = CacheBuilder.newBuilder()
      .maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES).build();
  static final Cache<String, List<ShiftItem>> factoryShiftCache = CacheBuilder.newBuilder()
      .maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES).build();
  static final Cache<String, Map<Long, ApsProcessPathDto>> factoryDefaultProcessPathCache = CacheBuilder.newBuilder()
      .maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES).build();
  static final Cache<Long, ApsProcessPathDto> factoryAllProcessPathCache = CacheBuilder.newBuilder()
      .maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES).build();
  @Resource
  CalendarService calendarService;
  @Resource
  ShiftService shiftService;
  @Resource
  ShiftItemService shiftItemService;
  @Resource
  ApsProcessPathService apsProcessPathService;
  @Resource
  private ApsProduceProcessItemService apsProduceProcessItemService;

  @Override
  public FactoryConfigRes getFactoryConfig(FactoryConfigReq req) {
    if (log.isDebugEnabled()) {
      log.debug("getFactoryConfig req :{}", JSON.toJSONString(req));
    }
//    LoginUser loginUser = LoginUserContext.getLoginUser();
    List<Runnable> runnableList = new ArrayList<>();
    Long factoryId = req.getFactoryId();
    FactoryConfigRes res = new FactoryConfigRes().setFactoryId(factoryId)
        .setFactoryName(req.getFactoryName());
    if (TRUE.equals(req.getGetWeek())) {

      runnableList.add(() -> {
//        LoginUserContext.setContextThreadLocal(loginUser);
        try {
          List<WeekInfo> retList = factoryWeekInfoCache.get(
              factoryId.toString() + req.getWeekBeginDate() + req.getWeekEndDate(), () -> {
                List<WeekInfo> weekList = calendarService.getWeekList(factoryId,
                    req.getWeekBeginDate(), req.getWeekEndDate());
                weekList.removeIf(w -> Boolean.FALSE.equals(w.getIsWorkDay()));
                weekList.sort(Comparator.comparing(WeekInfo::getCurrentDate));
                return weekList;
              });
          res.setWeekList(retList);
        } catch (Exception e) {
          log.error("factoryWeekInfoCache {} error:{}", factoryId, e.getMessage(), e);
        }
      });
    }
    if (TRUE.equals(req.getGetShift())) {
      runnableList.add(() -> {
        try {
//          LoginUserContext.setContextThreadLocal(loginUser);
          List<ShiftItem> shiftItemList = factoryShiftCache.get("dayWorkSecond-" + factoryId,
              () -> {
                Shift shift = shiftService.getOne(
                    new LambdaQueryWrapper<Shift>().eq(Shift::getFactoryId, factoryId), false);
                $.requireNonNullCanIgnoreException(shift,
                    req.getFactoryName() + "排产版本工厂没有班次");
                return shiftItemService.list(
                    new LambdaQueryWrapper<ShiftItem>().eq(ShiftItem::getShiftId, shift.getId())
                        .orderByAsc(ShiftItem::getBeginTime));
              });
          List<ShiftItemVo> shiftItemVoList = $.copyList(shiftItemList, ShiftItemVo.class);
          Long dayWorkSecond = ProcessUtils.getDayWorkSecond(shiftItemVoList);
          Long dayWorkLastSecond = ProcessUtils.getDayWorkLastSecond(shiftItemVoList,
              LocalTime.now());
          res.setShiftItemList(shiftItemList).setDayWorkSecond(dayWorkSecond)
              .setDayWorkLastSecond(dayWorkLastSecond);
        } catch (Exception e) {
          log.error("shiftItemList error {} error:{}", factoryId, e.getMessage(), e);
        }
      });
    }
    if (TRUE.equals(req.getQueryDefaultProcessPath())) {
      runnableList.add(() -> {
        try {
//          LoginUserContext.setContextThreadLocal(loginUser);
          Map<Long, ApsProcessPathDto> pathDtoMap = factoryDefaultProcessPathCache.get(
              req.getFactoryId().toString(), () -> {
                ApsProcessPathDto data = new ApsProcessPathDto().setFactoryId(factoryId)
                    .setIsDefault(req.getGetPathDefault());
                data.setId(req.getGetPathId());
                return apsProcessPathService.queryList(
                        new ApsProcessPathQueryListReq().setData(data)).getDataList().stream()
                    .collect(Collectors.toMap(BaseEntityDto::getId, Function.identity()));
              });

          res.setPathDtoMap(pathDtoMap);
          res.setDefaultApsProcessPathDto(
              pathDtoMap.values().stream().filter(t -> TRUE.equals(t.getIsDefault())).findAny()
                  .orElseThrow(() -> new RunException("没有默认工单路径")));
        } catch (Exception e) {
          log.error("factoryPathCache {} error: {}", factoryId, e.getMessage(), e);
        }

      });
    }
    List<Long> processPathIdList = req.getProcessPathIdList();
    if (CollUtil.isNotEmpty(processPathIdList)) {
      processPathIdList.removeIf(Objects::isNull);
      res.setAllProcessPathDtoMap(new HashMap<>());
      processPathIdList.forEach(processPathId -> {
        try {
          ApsProcessPathDto apsProcessPathDto = factoryAllProcessPathCache.get(processPathId,
              () -> {
                ApsProcessPathDto data = new ApsProcessPathDto().setFactoryId(factoryId)
                    .setIsDefault(req.getGetPathDefault());
                data.setId(processPathId);
                List<ApsProcessPathDto> dataList = apsProcessPathService.queryList(
                    new ApsProcessPathQueryListReq().setData(data)).getDataList();
                if (CollUtil.isNotEmpty(dataList)) {
                  return dataList.getFirst();
                }
                return null;
              });
          res.getAllProcessPathDtoMap().put(processPathId, apsProcessPathDto);
        } catch (ExecutionException e) {
          log.error("factoryAllProcessPathCache {} error: {}", processPathId, e.getMessage(), e);
        }
      });


    }

    if (CollUtil.isNotEmpty(req.getApsProduceProcessIdList())) {
      req.getApsProduceProcessIdList().removeIf(Objects::isNull);
      if (CollUtil.isNotEmpty(req.getApsProduceProcessIdList())) {
        runnableList.add(() -> {
          Map<Long, List<ApsProduceProcessItem>> apsProduceProcessItemMap = apsProduceProcessItemService.list(
                  new LambdaQueryWrapper<ApsProduceProcessItem>().in(
                      ApsProduceProcessItem::getProduceProcessId, req.getApsProduceProcessIdList()))
              .stream().collect(Collectors.groupingBy(ApsProduceProcessItem::getProduceProcessId));
          res.setApsProduceProcessItemMap(apsProduceProcessItemMap);
        });
      }
    }

    RunUtils.run("getFactoryConfig " + factoryId, runnableList);
    return res;
  }
}
