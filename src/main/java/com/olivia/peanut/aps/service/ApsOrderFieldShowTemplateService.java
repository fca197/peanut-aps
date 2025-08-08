package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
import com.olivia.peanut.aps.model.ApsOrderFieldShowTemplate;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)表服务接口
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
public interface ApsOrderFieldShowTemplateService extends MPJBaseService<ApsOrderFieldShowTemplate> {

  ApsOrderFieldShowTemplateQueryListRes queryList(ApsOrderFieldShowTemplateQueryListReq req);

  DynamicsPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderFieldShowTemplateExportQueryPageListReq req);


  void setName(List<? extends ApsOrderFieldShowTemplateDto> apsOrderFieldShowTemplateDtoList);
}

