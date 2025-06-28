package com.olivia.peanut.aps.service.impl.kitting.impl;

import static com.olivia.peanut.aps.con.ApsStr.CURRENT_DAY;
import static com.olivia.peanut.aps.con.ApsStr.ORDER_NO;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.CreateSchedulingKittingVersion;
import com.olivia.peanut.aps.con.ApsStr;
import com.olivia.peanut.aps.converter.ApsSchedulingVersionCapacityConverter;
import com.olivia.peanut.aps.model.ApsBom;
import com.olivia.peanut.aps.model.ApsGoods;
import com.olivia.peanut.aps.model.ApsGoodsBom;
import com.olivia.peanut.aps.model.ApsOrder;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrder;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
import com.olivia.peanut.aps.model.ApsOrderGoodsSaleConfig;
import com.olivia.peanut.aps.model.ApsOrderUser;
import com.olivia.peanut.aps.model.ApsSchedulingVersionCapacity;
import com.olivia.peanut.aps.service.ApsBomService;
import com.olivia.peanut.aps.service.ApsFactoryService;
import com.olivia.peanut.aps.service.ApsGoodsBomService;
import com.olivia.peanut.aps.service.ApsGoodsService;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingTemplateService;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderItemService;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderService;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionService;
import com.olivia.peanut.aps.service.ApsOrderGoodsSaleConfigService;
import com.olivia.peanut.aps.service.ApsOrderService;
import com.olivia.peanut.aps.service.ApsOrderUserService;
import com.olivia.peanut.aps.service.ApsSchedulingVersionCapacityService;
import com.olivia.peanut.aps.service.impl.kitting.ApsOrderGoodsBomKittingVersionCreateService;
import com.olivia.peanut.aps.service.pojo.FactoryConfigReq;
import com.olivia.peanut.aps.service.pojo.FactoryConfigRes;
import com.olivia.peanut.aps.utils.model.ApsGoodsBomVo;
import com.olivia.peanut.aps.utils.model.ApsProcessPathInfo;
import com.olivia.peanut.aps.utils.model.ApsProcessPathVo;
import com.olivia.peanut.aps.utils.process.ProcessUtils;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.IdUtils;
import com.olivia.sdk.utils.JSON;
import com.olivia.sdk.utils.Str;
import jakarta.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApsOrderGoodsBomKittingVersionCreateServiceImpl implements
    ApsOrderGoodsBomKittingVersionCreateService {


  @Resource
  ApsOrderGoodsBomKittingVersionOrderService apsOrderGoodsBomKittingVersionOrderService;

  @Resource
  ApsOrderGoodsBomKittingVersionOrderItemService apsOrderGoodsBomKittingVersionOrderItemService;

  @Resource
  ApsSchedulingVersionCapacityService apsSchedulingVersionCapacityService;

  @Resource
  ApsOrderGoodsBomKittingTemplateService apsOrderGoodsBomKittingTemplateService;

  @Resource
  ApsGoodsService apsGoodsService;

  @Resource
  ApsOrderService apsOrderService;

  @Resource
  ApsOrderGoodsSaleConfigService apsOrderGoodsSaleConfigService;
  @Resource
  ApsOrderUserService apsOrderUserService;

  @Resource
  ApsFactoryService apsFactoryService;

  @Resource
  ApsBomService apsBomService;
  @Resource
  ApsGoodsBomService apsGoodsBomService;

  // 最大缺失条数
  private static final int maxSize = 10;

  @Override
  public ApsOrderGoodsBomKittingVersionInsertRes createSchedulingKittingVersion(
      CreateSchedulingKittingVersion req) {

    ApsOrderGoodsBomKittingTemplate bomKittingTemplate = apsOrderGoodsBomKittingTemplateService.getById(
        req.getSchedulingVersionTemplateId());
    $.requireNonNullCanIgnoreException(bomKittingTemplate, "排产版本模板为空");

    List<LocalDate> kittingDateList = req.getKittingDate();
    Collections.sort(kittingDateList);
    List<ApsSchedulingVersionCapacity> schedulingVersionCapacityList = this.apsSchedulingVersionCapacityService.list(
        new LambdaQueryWrapper<ApsSchedulingVersionCapacity>().select(
                ApsSchedulingVersionCapacity::getGoodsId, ApsSchedulingVersionCapacity::getOrderId,
                ApsSchedulingVersionCapacity::getFactoryId, ApsSchedulingVersionCapacity::getCurrentDay,
                ApsSchedulingVersionCapacity::getNumberIndex)
            .eq(ApsSchedulingVersionCapacity::getSchedulingVersionId, req.getSchedulingVersionId())
            .in(ApsSchedulingVersionCapacity::getCurrentDay, kittingDateList)
            .orderByAsc(ApsSchedulingVersionCapacity::getCurrentDay,
                ApsSchedulingVersionCapacity::getNumberIndex));

    $.requireNonNullCanIgnoreException(schedulingVersionCapacityList, "排产版本获取订单为空");
    List<Long> goodIsList = schedulingVersionCapacityList.stream()
        .map(ApsSchedulingVersionCapacity::getGoodsId).distinct().toList();

    List<Long> orderIdList = schedulingVersionCapacityList.stream()
        .map(ApsSchedulingVersionCapacity::getOrderId).toList();
    Map<Long, ApsOrder> apsOrderMap = new HashMap<>();
    if (CollUtil.isNotEmpty(bomKittingTemplate.getKittingTemplateOrderConfigList())) {
      apsOrderMap.putAll(apsOrderService.listByIds(orderIdList).stream()
          .collect(Collectors.toMap(BaseEntity::getId, Function.identity())));
    }
    Map<Long, List<ApsOrderGoodsSaleConfig>> orderSaleListMap = new HashMap<>();
    if (CollUtil.isNotEmpty(bomKittingTemplate.getKittingTemplateSaleConfigList())) {
      Map<Long, List<ApsOrderGoodsSaleConfig>> orderSaleListMapTmp = apsOrderGoodsSaleConfigService.list(
              new LambdaQueryWrapper<ApsOrderGoodsSaleConfig>().in(ApsOrderGoodsSaleConfig::getOrderId,
                  orderIdList).in(ApsOrderGoodsSaleConfig::getConfigParentId,
                  bomKittingTemplate.getKittingTemplateSaleConfigList().stream().map(KVEntity::getValue)
                      .collect(Collectors.toSet()))).stream()
          .collect(Collectors.groupingBy(ApsOrderGoodsSaleConfig::getOrderId));
      orderSaleListMap.putAll(orderSaleListMapTmp);
    }
    Map<Long, ApsOrderUser> orderUserMap = new HashMap<>();
    if (CollUtil.isNotEmpty(bomKittingTemplate.getKittingTemplateOrderUserConfigList())) {
      Map<Long, ApsOrderUser> orderUserMapTmp = this.apsOrderUserService.list(
              new LambdaQueryWrapper<ApsOrderUser>().in(ApsOrderUser::getOrderId, orderIdList)).stream()
          .collect(Collectors.toMap(ApsOrderUser::getOrderId, Function.identity()));
      orderUserMap.putAll(orderUserMapTmp);

    }

    List<Map<String, Object>> allOrderMapList = schedulingVersionCapacityList.stream().map(t -> {
      Map<String, Object> map = ApsSchedulingVersionCapacityConverter.INSTANCE.entity2Map(t);
      Long orderId = t.getOrderId();
      ApsOrder apsOrder = apsOrderMap.get(orderId);
      if (Objects.nonNull(apsOrder)) {
        map.putAll(BeanUtil.beanToMap(apsOrder, false, true));
      }
      List<ApsOrderGoodsSaleConfig> apsOrderGoodsSaleConfigList = orderSaleListMap.get(orderId);
      if (CollUtil.isNotEmpty(apsOrderGoodsSaleConfigList)) {
        apsOrderGoodsSaleConfigList.forEach(os -> {
          map.put("sale_" + os.getConfigParentId(), os.getConfigId());
        });
      }
      ApsOrderUser apsOrderUser = orderUserMap.get(orderId);
      if (Objects.nonNull(apsOrderUser)) {
        map.putAll(BeanUtil.beanToMap(apsOrderUser, false, true));
      }

      return map;
    }).toList();

    apsOrderMap.clear();
    orderSaleListMap.clear();

    Map<Long, ApsGoods> apsGoodsMap = apsGoodsService.listByIds(goodIsList).stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));
    List<ApsOrderGoodsBomKittingVersionOrderItem> apsOrderGoodsBomKittingVersionOrderItemList = Collections.synchronizedList(
        new ArrayList<>());
    List<ApsOrderGoodsBomKittingVersionOrder> apsOrderGoodsBomKittingVersionOrderList = Collections.synchronizedList(
        new ArrayList<>());

    Map<Long, BigDecimal> lackApsBomMap = new HashMap<>();

    ApsOrderGoodsBomKittingVersion apsOrderGoodsBomKittingVersion = new ApsOrderGoodsBomKittingVersion();
    apsOrderGoodsBomKittingVersion.setId(IdUtils.getId());
    String nextVersionNo = getNextVersionNo();
    apsOrderGoodsBomKittingVersion.setKittingVersionNo("scheduling-" + nextVersionNo)
        .setKittingVersionName("排产[" + req.getSchedulingVersionId() + "]齐套")
        .setCreateDate(LocalDate.now());
    apsOrderGoodsBomKittingVersion.setBizId(req.getSchedulingVersionId())
        .setVersionCreateParam(JSON.toJSONString(req)).setKittingVersionSource("排产");

    List<Long> factoryIdList = schedulingVersionCapacityList.stream()
        .map(ApsSchedulingVersionCapacity::getFactoryId).toList();

    Map<Long, FactoryConfigRes> apsFactoryConfigResMap = new HashMap<>();

    factoryIdList.forEach(f -> {
      List<Long> produceProcessIdList = apsGoodsMap.values().stream()
          .filter(t -> Objects.equals(t.getFactoryId(), f)).map(ApsGoods::getProduceProcessId)
          .collect(Collectors.toList());
      List<Long> processPathIdList = apsGoodsMap.values().stream()
          .filter(t -> Objects.equals(t.getFactoryId(), f)).map(ApsGoods::getProcessPathId)
          .collect(Collectors.toList());
      FactoryConfigRes apsFactoryServiceFactoryConfig = apsFactoryService.getFactoryConfig(
          new FactoryConfigReq().setFactoryId(f).setGetShift(true).setGetWeek(true)
              .setWeekBeginDate(kittingDateList.getFirst())
              .setWeekEndDate(kittingDateList.getLast())
              .setApsProduceProcessIdList(produceProcessIdList)
              .setProcessPathIdList(processPathIdList));
      apsFactoryConfigResMap.put(f, apsFactoryServiceFactoryConfig);
    });

    // 工艺路径排产
    List<ApsGoods> processGoodsList = apsGoodsMap.values().stream()
        .filter(t -> Objects.nonNull(t.getProcessPathId())).toList();

    List<ApsGoodsBom> apsGoodsBomList = apsGoodsBomService.list(
        new LambdaQueryWrapper<ApsGoodsBom>().in(ApsGoodsBom::getGoodsId,
            processGoodsList.stream().map(BaseEntity::getId).toList()));
    Map<Long, Map<Long, Map<Long, ApsGoodsBom>>> apsGoodsBomMap = apsGoodsBomList.stream().collect(
        // 一级分组：按 field1 分组
        Collectors.groupingBy(ApsGoodsBom::getGoodsId,
            // 二级分组：按 field2 分组
            Collectors.groupingBy(ApsGoodsBom::getBomId,
                Collectors.toMap(ApsGoodsBom::getBomUseWorkStation, Function.identity()))));

    Map<Long, ApsBom> apsBomMap = Collections.synchronizedMap(
        this.apsBomService.listByIds(apsGoodsBomList.parallelStream() // 启用并行处理（大数据量场景）
                .map(ApsGoodsBom::getBomId).collect(Collectors.toSet())).stream()
            .collect(Collectors.toMap(BaseEntity::getId, Function.identity())));
    Map<Long, Map<Long, List<ApsGoodsBomVo>>> apsGoodsBomStationMap = apsGoodsBomList.stream()
        .collect(Collectors.groupingBy(ApsGoodsBom::getGoodsId,
            Collectors.groupingBy(ApsGoodsBom::getBomUseWorkStation,
                Collectors.mapping(item -> $.copy(item, ApsGoodsBomVo.class),  // 单个元素转换
                    Collectors.toList()                         // 收集为List
                ))));

    if (CollUtil.isNotEmpty(processGoodsList)) {
      Set<Long> goodsIdList = processGoodsList.stream().map(BaseEntity::getId)
          .collect(Collectors.toSet());
      log.info("processGoodsList idList : {}", goodsIdList);

      allOrderMapList.stream().filter(t -> goodsIdList.contains((Long) t.get(ApsStr.GOODS_ID)))
          .forEach(t -> {
            //  获取当天

            List<ApsOrderGoodsBomKittingVersionOrderItem> apsOrderGoodsBomKittingVersionOrderItemListTmp = Collections.synchronizedList(
                new ArrayList<>());

            AtomicInteger bomCount = new AtomicInteger(0);

//            apsFactoryService
            FactoryConfigRes factoryConfigRes = apsFactoryConfigResMap.get(
                (Long) t.get(ApsStr.FACTORY_ID));
            if (Objects.isNull(factoryConfigRes)) {
              return;
            }
            ApsGoods apsGoods = apsGoodsMap.get((Long) t.get(ApsStr.GOODS_ID));
            ApsProcessPathInfo apsProcessPathInfo = ProcessUtils.schedulePathDate(
                $.copy(factoryConfigRes.getAllProcessPathDtoMap().get(apsGoods.getProcessPathId()),
                    ApsProcessPathVo.class), factoryConfigRes.getWeekList(), 0L,
                factoryConfigRes.getDayWorkSecond(), null,
                apsGoodsBomStationMap.get((Long) t.get(ApsStr.GOODS_ID)),
                (LocalDate) t.get(CURRENT_DAY));

            Long kittingVersionId = apsOrderGoodsBomKittingVersion.getId();
            apsProcessPathInfo.getDataList().forEach(apsBom -> {

//              log.info("apsProcessPathInfo : {}", apsBom);
              if (CollUtil.isEmpty(apsBom.getApsGoodsBomList())) {
                return;
              }
              bomCount.incrementAndGet();
              apsBom.getApsGoodsBomList().forEach(bt -> {
                ApsBom apsBomTmp = apsBomMap.get(bt.getBomId());

                ApsGoodsBom apsGoodsBom = apsGoodsBomMap.getOrDefault(bt.getGoodsId(), Map.of())
                    .getOrDefault(bt.getBomId(), Map.of()).get(bt.getBomUseWorkStation());

                ApsOrderGoodsBomKittingVersionOrderItem versionOrderItem = new ApsOrderGoodsBomKittingVersionOrderItem();
                BigDecimal lastCount = apsBomTmp.getBomInventory()
                    .subtract(apsGoodsBom.getBomUsage());
                versionOrderItem.setBomId(apsGoodsBom.getBomId()).setApsRoomId(apsBom.getRoomId())
                    .setApsRoomName(apsBomTmp.getBomName()).setCreateDate(bt.getTotalDate())
                    .setBomName(apsBomTmp.getBomName()).setFactoryId(apsBom.getFactoryId())
                    .setOrderId((Long) t.get(ApsStr.ORDER_ID)).setOrderNo((String) t.get(ORDER_NO))
                    .setGoodsName(apsGoods.getGoodsName()).setBomUsage(apsGoodsBom.getBomUsage())
                    .setInventoryBeforeCount(apsBomTmp.getBomInventory())
                    .setInventoryAfterCount(lastCount)
//                    .setOrderMakeBeginDateTime(apsBom.getBeginLocalDate().atTime(LocalTime.MIN))
                ;
                // 如果库存 <= 0   缺少数量 = 使用量
                if (BigDecimal.ZERO.compareTo(apsBomTmp.getBomInventory()) <= 0) {
                  versionOrderItem.setLackQuantity(apsGoodsBom.getBomUsage());
                } else {
                  // 如果 库存 - 使用量 > 0 , 缺失数 =0
                  if (lastCount.compareTo(BigDecimal.ZERO) >= 0) {
                    versionOrderItem.setLackQuantity(BigDecimal.ZERO);
                  } else {
                    versionOrderItem.setLackQuantity(lastCount.abs());
                  }
                }

                versionOrderItem.setIsEnough(
                    versionOrderItem.getInventoryAfterCount().compareTo(BigDecimal.ZERO) >= 0);

                versionOrderItem.setKittingVersionId(kittingVersionId).setId(IdUtils.getId());
                apsOrderGoodsBomKittingVersionOrderItemListTmp.add(versionOrderItem);
                apsBomTmp.setBomInventory(versionOrderItem.getInventoryAfterCount());
              });

            });

            apsOrderGoodsBomKittingVersionOrderItemList.addAll(
                apsOrderGoodsBomKittingVersionOrderItemListTmp);
            Map<Long, BigDecimal> lackApsBomMapTmp = apsOrderGoodsBomKittingVersionOrderItemListTmp.stream()
                .filter(tt -> !Boolean.TRUE.equals(tt.getIsEnough())).collect(
                    Collectors.groupingBy(ApsOrderGoodsBomKittingVersionOrderItem::getBomId,
                        Collectors.collectingAndThen(Collectors.toList(), r -> r.stream()
                            .map(ApsOrderGoodsBomKittingVersionOrderItem::getLackQuantity)
                            .reduce(BigDecimal.ZERO, BigDecimal::add))));

            ApsOrderGoodsBomKittingVersionOrder versionOrder = new ApsOrderGoodsBomKittingVersionOrder();
            if (CollUtil.isNotEmpty(lackApsBomMapTmp)) {

              lackApsBomMapTmp.forEach((k, v) -> {
                BigDecimal lack = lackApsBomMap.getOrDefault(k, BigDecimal.ZERO);
                lackApsBomMapTmp.put(k, lack.add(v));
              });

              List<KVEntity> lackList = lackApsBomMapTmp.entrySet().stream().sorted(
                  Entry.<Long, BigDecimal>comparingByValue(Comparator.reverseOrder())
                      .thenComparing(Entry::getKey)).limit(maxSize).map(
                  (e) -> new KVEntity().setLabel(apsBomMap.get(e.getKey()).getBomName())
                      .setValue(e.getValue().toString())).toList();
              versionOrder.setKittingMissingBom(lackList).setKittingStatus("未齐套");
            } else {
              versionOrder.setKittingStatus("齐套").setKittingRate(BigDecimal.ONE);
            }

            versionOrder.setKittingRate(new BigDecimal(bomCount.get()).divide(
                new BigDecimal(apsOrderGoodsBomKittingVersionOrderItemListTmp.size()), 5,
                RoundingMode.HALF_UP));
            versionOrder.setOrderId((Long) t.get(ApsStr.ORDER_ID))
                .setKittingVersionId(kittingVersionId).setKittingRate(BigDecimal.ZERO)
                .setFactoryId((Long) t.get(ApsStr.FACTORY_ID)).setOrderNo((String) t.get(ORDER_NO));
            versionOrder.setNumberIndex((Long) t.get("numberIndex"));
            apsOrderGoodsBomKittingVersionOrderList.add(versionOrder);
          });
    }

    if (CollUtil.isNotEmpty(lackApsBomMap)) {
      List<KVEntity> lockList = lackApsBomMap.entrySet().stream().sorted(
          Entry.<Long, BigDecimal>comparingByValue(Comparator.reverseOrder())
              .thenComparing(Entry::getKey)).limit(maxSize).map(
          (e) -> new KVEntity().setLabel(apsBomMap.get(e.getKey()).getBomName())
              .setValue(e.getValue().toString())).toList();
      apsOrderGoodsBomKittingVersion.setKittingMissingBom(lockList).setKittingStatus("未齐套")
          .setKittingRate(
              new BigDecimal(lackApsBomMap.size()).divide(new BigDecimal(apsGoodsBomList.stream()
                  .map(ApsGoodsBom::getBomId).distinct().count()), 5, RoundingMode.HALF_UP));
    } else {
      apsOrderGoodsBomKittingVersion.setKittingStatus("齐套").setKittingRate(BigDecimal.ONE);
    }

    //  机器排产
    List<ApsGoods> produceGoodsList = apsGoodsMap.values().stream()
        .filter(t -> Objects.nonNull(t.getProduceProcessId())).toList();
    if (CollUtil.isNotEmpty(produceGoodsList)) {
      log.info("produceGoodsList idList : {}",
          produceGoodsList.stream().map(BaseEntity::getId).toList());
    }

    this.apsOrderGoodsBomKittingVersionOrderItemService.saveBatch(
        apsOrderGoodsBomKittingVersionOrderItemList);
    this.apsOrderGoodsBomKittingVersionOrderService.saveBatch(
        apsOrderGoodsBomKittingVersionOrderList);
    apsOrderGoodsBomKittingVersionService().save(apsOrderGoodsBomKittingVersion);

    return null;
  }

  private String getNextVersionNo() {
    ApsOrderGoodsBomKittingVersion apsOrderGoodsBomKittingVersion = this.apsOrderGoodsBomKittingVersionService()
        .getOne(new LambdaQueryWrapper<ApsOrderGoodsBomKittingVersion>().eq(
                ApsOrderGoodsBomKittingVersion::getCreateDate, LocalDate.now())
            .orderByDesc(ApsOrderGoodsBomKittingVersion::getKittingVersionNo).last(Str.LIMIT_1));
    if (Objects.isNull(apsOrderGoodsBomKittingVersion)) {
      return LocalDate.now() + "-00001";
    }
    return LocalDate.now() + "-" + StringUtils.right("000" + (
        Integer.parseInt(StringUtils.right(apsOrderGoodsBomKittingVersion.getKittingVersionNo(), 4))
            + 1), 4);
  }

  private ApsOrderGoodsBomKittingVersionService apsOrderGoodsBomKittingVersionService() {
    return SpringUtil.getBean(ApsOrderGoodsBomKittingVersionService.class);
  }

}
