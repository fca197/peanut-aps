package com.olivia.peanut.aps.api.impl.listener;


import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;
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
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)文件导入监听
 *
 * @author admin
 * @since 2025-07-23 13:20:08
 */
@Slf4j
public class ApsMachineWorkstationItemImportListener extends
    AbstractImportListener<ApsMachineWorkstationItemImportReq> {

  @Override
  public void invoke(ApsMachineWorkstationItemImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("ApsMachineWorkstationItemImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
