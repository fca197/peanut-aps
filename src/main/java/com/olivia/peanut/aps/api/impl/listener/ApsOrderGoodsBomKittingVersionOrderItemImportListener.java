package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;
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
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)文件导入监听
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
@Slf4j
public class ApsOrderGoodsBomKittingVersionOrderItemImportListener extends
    AbstractImportListener<ApsOrderGoodsBomKittingVersionOrderItemImportReq> {

  @Override
  public void invoke(ApsOrderGoodsBomKittingVersionOrderItemImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderGoodsBomKittingVersionOrderItemImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
