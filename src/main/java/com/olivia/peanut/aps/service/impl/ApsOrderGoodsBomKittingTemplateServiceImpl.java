package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingTemplateConverter;
import com.olivia.peanut.aps.mapper.ApsOrderGoodsBomKittingTemplateMapper;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingTemplateService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.*;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)表服务实现类
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Service("apsOrderGoodsBomKittingTemplateService")
@Transactional
public class ApsOrderGoodsBomKittingTemplateServiceImpl extends MPJBaseServiceImpl<ApsOrderGoodsBomKittingTemplateMapper, ApsOrderGoodsBomKittingTemplate> implements
    ApsOrderGoodsBomKittingTemplateService {


  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderGoodsBomKittingTemplateQueryListRes queryList(
      ApsOrderGoodsBomKittingTemplateQueryListReq req) {

    MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingTemplate> list = this.list(q);

    List<ApsOrderGoodsBomKittingTemplateDto> dataList = ApsOrderGoodsBomKittingTemplateConverter.INSTANCE.queryListRes(list);
    ((ApsOrderGoodsBomKittingTemplateService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderGoodsBomKittingTemplateQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req) {

    DynamicsPage<ApsOrderGoodsBomKittingTemplate> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderGoodsBomKittingTemplate> list = this.page(page, q);
      IPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderGoodsBomKittingTemplateConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderGoodsBomKittingTemplateService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderGoodsBomKittingTemplateDto> list) {

//    setNameService.setName(list, SetNamePojoUtils.FACTORY
////           , SetNamePojoUtils.OP_USER_NAME
//    );

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate> getWrapper(
      ApsOrderGoodsBomKittingTemplateDto obj) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderGoodsBomKittingTemplate.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsOrderGoodsBomKittingTemplate::getKittingTemplateNo // 模板编号
        , ApsOrderGoodsBomKittingTemplate::getKittingTemplateName // 模板名称
        , ApsOrderGoodsBomKittingTemplate::getFactoryId // 工厂ID
    );

    q.orderByDesc(ApsOrderGoodsBomKittingTemplate::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderGoodsBomKittingTemplate> page) {

    tableHeaderService.listByBizKey(page, "ApsOrderGoodsBomKittingTemplateService#queryPageList");

  }


}

