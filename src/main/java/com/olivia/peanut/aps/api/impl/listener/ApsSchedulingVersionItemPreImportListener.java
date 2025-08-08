package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.ApsSchedulingVersionItemPreImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)文件导入监听
 *
 * @author makejava
 * @since 2025-04-06 14:16:41
 */
@Slf4j
public class ApsSchedulingVersionItemPreImportListener extends AbstractImportListener<ApsSchedulingVersionItemPreImportReq> {

  @Override
  public void invoke(ApsSchedulingVersionItemPreImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsSchedulingVersionItemPreImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
