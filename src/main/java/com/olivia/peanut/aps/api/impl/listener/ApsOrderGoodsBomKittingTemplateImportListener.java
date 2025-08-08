package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.ApsOrderGoodsBomKittingTemplateImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)文件导入监听
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Slf4j
public class ApsOrderGoodsBomKittingTemplateImportListener extends AbstractImportListener<ApsOrderGoodsBomKittingTemplateImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingTemplateImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingTemplateImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
