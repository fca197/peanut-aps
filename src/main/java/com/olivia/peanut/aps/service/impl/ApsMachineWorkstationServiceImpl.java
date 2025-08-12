package com.olivia.peanut.aps.service.impl;

import static com.olivia.peanut.aps.converter.ApsMachineWorkstationConverter.INSTANCE;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import com.olivia.peanut.aps.converter.ApsMachineWorkstationConverter;
import com.olivia.peanut.aps.converter.ApsMachineWorkstationItemConverter;
import com.olivia.peanut.aps.mapper.ApsMachineWorkstationMapper;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import com.olivia.peanut.aps.service.ApsMachineWorkstationItemService;
import com.olivia.peanut.aps.service.ApsMachineWorkstationService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.*;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表服务实现类
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
@Service("apsMachineWorkstationService")
@Transactional
public class ApsMachineWorkstationServiceImpl extends MPJBaseServiceImpl<ApsMachineWorkstationMapper, ApsMachineWorkstation> implements
    ApsMachineWorkstationService {


  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;
  @Resource
  ApsMachineWorkstationItemService apsMachineWorkstationItemService;


  public @Override ApsMachineWorkstationQueryListRes queryList(ApsMachineWorkstationQueryListReq req) {

    MPJLambdaWrapper<ApsMachineWorkstation> q = getWrapper(req.getData());
    List<ApsMachineWorkstation> list = this.list(q);

    List<ApsMachineWorkstationDto> dataList = ApsMachineWorkstationConverter.INSTANCE.queryListRes(list);
    ((ApsMachineWorkstationService) AopContext.currentProxy()).setName(dataList);
    return new ApsMachineWorkstationQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(ApsMachineWorkstationExportQueryPageListReq req) {

    DynamicsPage<ApsMachineWorkstation> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsMachineWorkstation> q = getWrapper(req.getData());
    List<ApsMachineWorkstationExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsMachineWorkstation> list = this.page(page, q);
      IPage<ApsMachineWorkstationExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsMachineWorkstationExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsMachineWorkstationConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsMachineWorkstationService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  @Override
  public Long save(ApsMachineWorkstationInsertReq req) {
    long id = IdWorker.getId();
    ApsMachineWorkstation apsMachineWorkstation = INSTANCE.insertReq(req);
    apsMachineWorkstation.setId(id);
    $.requireNonNullCanIgnoreException(req.getMachineWorkstationItemDtoList(), "机器不能为空");
    List<ApsMachineWorkstationItem> workstationItemList = req.getMachineWorkstationItemDtoList()
        .stream().map(ApsMachineWorkstationItemConverter.INSTANCE::dto2Entity)
        .peek(t -> t.setMachineWorkstationId(id).setId(IdWorker.getId()))
        .toList();
    this.save(apsMachineWorkstation);
    this.apsMachineWorkstationItemService.saveBatch(workstationItemList);
    return id;
  }

  @Override
  @Transactional
  public void updateById(ApsMachineWorkstationUpdateByIdReq req) {
    ApsMachineWorkstation apsMachineWorkstation = INSTANCE.updateReq(req);
    Long id = apsMachineWorkstation.getId();
    List<ApsMachineWorkstationItem> workstationItemList = req.getMachineWorkstationItemDtoList()
        .stream().map(ApsMachineWorkstationItemConverter.INSTANCE::dto2Entity)
        .peek(t -> t.setMachineWorkstationId(id).setId(IdWorker.getId()))
        .toList();

    this.apsMachineWorkstationItemService.remove(
        new LambdaQueryWrapper<ApsMachineWorkstationItem>().eq(ApsMachineWorkstationItem::getMachineWorkstationId, id));
    this.apsMachineWorkstationItemService.saveBatch(workstationItemList);
    this.updateById(apsMachineWorkstation);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsMachineWorkstationDto> list) {

    if (CollUtil.isNotEmpty(list)) {
      Map<Long, List<ApsMachineWorkstationItem>> apsMachineMap = this.apsMachineWorkstationItemService.lambdaQuery()
          .in(ApsMachineWorkstationItem::getMachineWorkstationId,
              list.stream().map(BaseEntityDto::getId).toList())
          .list().stream()
          .collect(Collectors.groupingBy(ApsMachineWorkstationItem::getMachineWorkstationId));

      list.forEach(item -> {
        List<ApsMachineWorkstationItem> workstationItemList = apsMachineMap.getOrDefault(
            item.getId(),
            List.of());
        item.setMachineWorkstationItemDtoList(ApsMachineWorkstationItemConverter.INSTANCE.queryListRes(workstationItemList));
      });
    }
    setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);
  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsMachineWorkstation> getWrapper(ApsMachineWorkstationDto obj) {
    MPJLambdaWrapper<ApsMachineWorkstation> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsMachineWorkstation.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsMachineWorkstation::getMachineWorkstationNo // 工作站编号
        , ApsMachineWorkstation::getMachineWorkstationName // 工作站名称
        , ApsMachineWorkstation::getMaxPower // 最大功率
        , ApsMachineWorkstation::getFactoryId // 工厂ID
        , ApsMachineWorkstation::getSortIndex // 排序索引
    );

    q.orderByDesc(ApsMachineWorkstation::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsMachineWorkstation> page) {

    tableHeaderService.listByBizKey(page, "ApsMachineWorkstationService#queryPageList");

  }


}

