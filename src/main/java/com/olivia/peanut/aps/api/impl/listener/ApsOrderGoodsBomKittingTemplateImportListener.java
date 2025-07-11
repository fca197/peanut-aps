package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
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
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)文件导入监听
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Slf4j
public class ApsOrderGoodsBomKittingTemplateImportListener extends
    AbstractImportListener<ApsOrderGoodsBomKittingTemplateImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingTemplateImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingTemplateImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
