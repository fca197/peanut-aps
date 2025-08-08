package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.ApsMachineWorkstationItemDto;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.ApsMachineWorkstationItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.ApsMachineWorkstationItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.ApsMachineWorkstationItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.ApsMachineWorkstationItemQueryListRes;
import com.olivia.peanut.aps.converter.ApsMachineWorkstationItemConverter;
import com.olivia.peanut.aps.mapper.ApsMachineWorkstationItemMapper;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import com.olivia.peanut.aps.service.ApsMachineWorkstationItemService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.LambdaQueryUtil;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)表服务实现类
 *
 * @author admin
 * @since 2025-07-23 13:20:08
 */
@Service("apsMachineWorkstationItemService")
@Transactional
public class ApsMachineWorkstationItemServiceImpl extends
    MPJBaseServiceImpl<ApsMachineWorkstationItemMapper, ApsMachineWorkstationItem> implements
    ApsMachineWorkstationItemService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsMachineWorkstationItemQueryListRes queryList(
      ApsMachineWorkstationItemQueryListReq req) {

    MPJLambdaWrapper<ApsMachineWorkstationItem> q = getWrapper(req.getData());
    List<ApsMachineWorkstationItem> list = this.list(q);

    List<ApsMachineWorkstationItemDto> dataList = ApsMachineWorkstationItemConverter.INSTANCE.queryListRes(
        list);
    ((ApsMachineWorkstationItemService) AopContext.currentProxy()).setName(dataList);
    return new ApsMachineWorkstationItemQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationItemExportQueryPageListReq req) {

    DynamicsPage<ApsMachineWorkstationItem> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsMachineWorkstationItem> q = getWrapper(req.getData());
    List<ApsMachineWorkstationItemExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsMachineWorkstationItem> list = this.page(page, q);
      IPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsMachineWorkstationItemExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsMachineWorkstationItemConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsMachineWorkstationItemService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsMachineWorkstationItemDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsMachineWorkstationItem> getWrapper(ApsMachineWorkstationItemDto obj) {
    MPJLambdaWrapper<ApsMachineWorkstationItem> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsMachineWorkstationItem.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsMachineWorkstationItem::getMachineWorkstationId // 工作站id
        , ApsMachineWorkstationItem::getMachineId // 机器ID
        , ApsMachineWorkstationItem::getMaxPower // 最大功率
        , ApsMachineWorkstationItem::getFactoryId // 工厂ID
        , ApsMachineWorkstationItem::getSortIndex // 排序索引
    );

    q.orderByDesc(ApsMachineWorkstationItem::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsMachineWorkstationItem> page) {

    tableHeaderService.listByBizKey(page, "ApsMachineWorkstationItemService#queryPageList");

  }


}

