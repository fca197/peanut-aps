package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)文件导入监听
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
@Slf4j
public class ApsMachineWorkstationImportListener extends
    AbstractImportListener<ApsMachineWorkstationImportReq> {

  @Override
  public void invoke(ApsMachineWorkstationImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsMachineWorkstationImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
