package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)文件导入监听
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
@Slf4j
public class ApsOrderGoodsBomKittingVersionOrderItemImportListener extends AbstractImportListener<ApsOrderGoodsBomKittingVersionOrderBomImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingVersionOrderBomImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingVersionOrderItemImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
