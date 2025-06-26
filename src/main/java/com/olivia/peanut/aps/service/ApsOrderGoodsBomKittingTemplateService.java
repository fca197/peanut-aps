package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;

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

