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
import com.olivia.peanut.aps.mapper.ApsGoodsForecastUserSaleGroupDataMapper;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleGroupData;
import com.olivia.peanut.aps.converter.ApsGoodsForecastUserSaleGroupDataConverter;
import com.olivia.peanut.aps.service.ApsGoodsForecastUserSaleGroupDataService;
import cn.hutool.core.collection.CollUtil;
import com.olivia.peanut.base.service.BaseTableHeaderService;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData.*;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)表服务实现类
 *
 * @author admin
 * @since 2025-06-23 13:13:59
 */
@Service("apsGoodsForecastUserSaleGroupDataService")
@Transactional
public class ApsGoodsForecastUserSaleGroupDataServiceImpl extends
    MPJBaseServiceImpl<ApsGoodsForecastUserSaleGroupDataMapper, ApsGoodsForecastUserSaleGroupData> implements
    ApsGoodsForecastUserSaleGroupDataService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsGoodsForecastUserSaleGroupDataQueryListRes queryList(
      ApsGoodsForecastUserSaleGroupDataQueryListReq req) {

    MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData> q = getWrapper(req.getData());
    List<ApsGoodsForecastUserSaleGroupData> list = this.list(q);

    List<ApsGoodsForecastUserSaleGroupDataDto> dataList = ApsGoodsForecastUserSaleGroupDataConverter.INSTANCE.queryListRes(
        list);
    ((ApsGoodsForecastUserSaleGroupDataService) AopContext.currentProxy()).setName(dataList);
    return new ApsGoodsForecastUserSaleGroupDataQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req) {

    DynamicsPage<ApsGoodsForecastUserSaleGroupData> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData> q = getWrapper(req.getData());
    List<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsGoodsForecastUserSaleGroupData> list = this.page(page, q);
      IPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsGoodsForecastUserSaleGroupDataConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsGoodsForecastUserSaleGroupDataService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsGoodsForecastUserSaleGroupDataDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData> getWrapper(
      ApsGoodsForecastUserSaleGroupDataDto obj) {
    MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsGoodsForecastUserSaleGroupData.class
        // 查询条件
        , ApsGoodsForecastUserSaleGroupData::getForecastId //
        , ApsGoodsForecastUserSaleGroupData::getSaleConfigParentList //
        , ApsGoodsForecastUserSaleGroupData::getSaleConfigList //
        , ApsGoodsForecastUserSaleGroupData::getYear //
        , ApsGoodsForecastUserSaleGroupData::getMonth01 //
        , ApsGoodsForecastUserSaleGroupData::getMonth02 //
        , ApsGoodsForecastUserSaleGroupData::getMonth03 //
        , ApsGoodsForecastUserSaleGroupData::getMonth04 //
        , ApsGoodsForecastUserSaleGroupData::getMonth05 //
        , ApsGoodsForecastUserSaleGroupData::getMonth06 //
        , ApsGoodsForecastUserSaleGroupData::getMonth07 //
        , ApsGoodsForecastUserSaleGroupData::getMonth08 //
        , ApsGoodsForecastUserSaleGroupData::getMonth09 //
        , ApsGoodsForecastUserSaleGroupData::getMonth10 //
        , ApsGoodsForecastUserSaleGroupData::getMonth11 //
        , ApsGoodsForecastUserSaleGroupData::getMonth12 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult01 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult02 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult03 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult04 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult05 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult06 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult07 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult08 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult09 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult10 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult11 //
        , ApsGoodsForecastUserSaleGroupData::getMonthResult12 //
    );

    q.orderByDesc(ApsGoodsForecastUserSaleGroupData::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsGoodsForecastUserSaleGroupData> page) {

    tableHeaderService.listByBizKey(page, "ApsGoodsForecastUserSaleGroupDataService#queryPageList");

  }


}

