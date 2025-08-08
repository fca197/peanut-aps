package com.olivia.peanut.aps.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionImportReq;
import com.olivia.sdk.listener.AbstractImportListener;
import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)文件导入监听
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Slf4j
public class ApsOrderGoodsBomKittingVersionImportListener extends AbstractImportListener<ApsOrderGoodsBomKittingVersionImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingVersionImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingVersionImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
