package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsOrderFieldShowTemplate;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
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
 * 订单显示模板(ApsOrderFieldShowTemplate)文件导入监听
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Slf4j
public class ApsOrderFieldShowTemplateImportListener extends
    AbstractImportListener<ApsOrderFieldShowTemplateImportReq> {

  @Override
  public void invoke(ApsOrderFieldShowTemplateImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsOrderFieldShowTemplateImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
