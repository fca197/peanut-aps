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
import com.olivia.peanut.aps.mapper.ApsOrderFieldShowTemplateMapper;
import com.olivia.peanut.aps.model.ApsOrderFieldShowTemplate;
import com.olivia.peanut.aps.converter.ApsOrderFieldShowTemplateConverter;
import com.olivia.peanut.aps.service.ApsOrderFieldShowTemplateService;
import cn.hutool.core.collection.CollUtil;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)表服务实现类
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Service("apsOrderFieldShowTemplateService")
@Transactional
public class ApsOrderFieldShowTemplateServiceImpl extends
    MPJBaseServiceImpl<ApsOrderFieldShowTemplateMapper, ApsOrderFieldShowTemplate> implements
    ApsOrderFieldShowTemplateService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderFieldShowTemplateQueryListRes queryList(
      ApsOrderFieldShowTemplateQueryListReq req) {

    MPJLambdaWrapper<ApsOrderFieldShowTemplate> q = getWrapper(req.getData());
    List<ApsOrderFieldShowTemplate> list = this.list(q);

    List<ApsOrderFieldShowTemplateDto> dataList = ApsOrderFieldShowTemplateConverter.INSTANCE.queryListRes(
        list);
    ((ApsOrderFieldShowTemplateService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderFieldShowTemplateQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderFieldShowTemplateExportQueryPageListReq req) {

    DynamicsPage<ApsOrderFieldShowTemplate> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderFieldShowTemplate> q = getWrapper(req.getData());
    List<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderFieldShowTemplate> list = this.page(page, q);
      IPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderFieldShowTemplateExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderFieldShowTemplateConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderFieldShowTemplateService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderFieldShowTemplateDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderFieldShowTemplate> getWrapper(ApsOrderFieldShowTemplateDto obj) {
    MPJLambdaWrapper<ApsOrderFieldShowTemplate> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderFieldShowTemplate.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsOrderFieldShowTemplate::getApsOrderUserNo // 模板编号
        , ApsOrderFieldShowTemplate::getApsOrderUserName // 模板名称
        , ApsOrderFieldShowTemplate::getIsDefault // 是否默认
        , ApsOrderFieldShowTemplate::getApsOrderUserSaleConfigList // 销售配置
        , ApsOrderFieldShowTemplate::getApsOrderUserOrderConfigList // 订单配置
        , ApsOrderFieldShowTemplate::getApsOrderUserOrderUserConfigList // 订单配置
    );

    q.orderByDesc(ApsOrderFieldShowTemplate::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderFieldShowTemplate> page) {

    tableHeaderService.listByBizKey(page, "ApsOrderFieldShowTemplateService#queryPageList");

  }


}

