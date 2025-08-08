package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.ApsOrderGoodsBomKittingVersionOrderImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)文件导入监听
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Slf4j
public class ApsOrderGoodsBomKittingVersionOrderImportListener extends AbstractImportListener<ApsOrderGoodsBomKittingVersionOrderImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingVersionOrderImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingVersionOrderImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
