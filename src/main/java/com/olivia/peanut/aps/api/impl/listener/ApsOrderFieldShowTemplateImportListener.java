package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.ApsOrderFieldShowTemplateImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)文件导入监听
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Slf4j
public class ApsOrderFieldShowTemplateImportListener extends AbstractImportListener<ApsOrderFieldShowTemplateImportReq> {

  @Override
  public void invoke(ApsOrderFieldShowTemplateImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderFieldShowTemplateImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
