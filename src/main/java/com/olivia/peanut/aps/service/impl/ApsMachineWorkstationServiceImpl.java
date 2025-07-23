package com.olivia.peanut.aps.service.impl;

import org.springframework.aop.framework.AopContext;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import jakarta.annotation.Resource;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.LambdaQueryUtil;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.olivia.peanut.aps.mapper.ApsMachineWorkstationMapper;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import com.olivia.peanut.aps.converter.ApsMachineWorkstationConverter;
import com.olivia.peanut.aps.service.ApsMachineWorkstationService;
import cn.hutool.core.collection.CollUtil;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表服务实现类
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
@Service("apsMachineWorkstationService")
@Transactional
public class ApsMachineWorkstationServiceImpl extends
    MPJBaseServiceImpl<ApsMachineWorkstationMapper, ApsMachineWorkstation> implements
    ApsMachineWorkstationService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsMachineWorkstationQueryListRes queryList(
      ApsMachineWorkstationQueryListReq req) {

    MPJLambdaWrapper<ApsMachineWorkstation> q = getWrapper(req.getData());
    List<ApsMachineWorkstation> list = this.list(q);

    List<ApsMachineWorkstationDto> dataList = ApsMachineWorkstationConverter.INSTANCE.queryListRes(
        list);
    ((ApsMachineWorkstationService) AopContext.currentProxy()).setName(dataList);
    return new ApsMachineWorkstationQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationExportQueryPageListReq req) {

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

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsMachineWorkstationDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsMachineWorkstation> getWrapper(ApsMachineWorkstationDto obj) {
    MPJLambdaWrapper<ApsMachineWorkstation> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsMachineWorkstation.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsMachineWorkstation::getMachineWorkstationNo // 工作站编号
        , ApsMachineWorkstation::getMachineWorkstationName // 工作站名称
        , ApsMachineWorkstation::getMinPower // 最小功率
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

