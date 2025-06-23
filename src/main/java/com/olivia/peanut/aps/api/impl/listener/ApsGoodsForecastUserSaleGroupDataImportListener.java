package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleGroupData;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData.*;
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
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)文件导入监听
 *
 * @author admin
 * @since 2025-06-23 13:13:59
 */
@Slf4j
public class ApsGoodsForecastUserSaleGroupDataImportListener extends
    AbstractImportListener<ApsGoodsForecastUserSaleGroupDataImportReq> {

  @Override
  public void invoke(ApsGoodsForecastUserSaleGroupDataImportReq data,
      AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsGoodsForecastUserSaleGroupDataImportListener invoke data:{}",
        JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
