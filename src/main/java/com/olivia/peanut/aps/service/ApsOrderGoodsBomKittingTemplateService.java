package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)表服务接口
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
public interface ApsOrderGoodsBomKittingTemplateService extends
    MPJBaseService<ApsOrderGoodsBomKittingTemplate> {

  ApsOrderGoodsBomKittingTemplateQueryListRes queryList(
      ApsOrderGoodsBomKittingTemplateQueryListReq req);

  DynamicsPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req);


  void setName(
      List<? extends ApsOrderGoodsBomKittingTemplateDto> apsOrderGoodsBomKittingTemplateDtoList);
}

