package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;
import com.alibaba.excel.context.AnalysisContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
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
public class ApsOrderGoodsBomKittingVersionImportListener extends
    AbstractImportListener<ApsOrderGoodsBomKittingVersionImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingVersionImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingVersionImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
