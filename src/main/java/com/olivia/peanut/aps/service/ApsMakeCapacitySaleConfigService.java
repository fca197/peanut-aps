package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigDto;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.ApsMakeCapacitySaleConfigQueryListRes;
import com.olivia.peanut.aps.model.ApsMakeCapacitySaleConfig;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsMakeCapacitySaleConfig)表服务接口
 *
 * @author peanut
 * @since 2024-04-13 12:05:06
 */
public interface ApsMakeCapacitySaleConfigService extends
    MPJBaseService<ApsMakeCapacitySaleConfig> {

  ApsMakeCapacitySaleConfigQueryListRes queryList(ApsMakeCapacitySaleConfigQueryListReq req);

  DynamicsPage<ApsMakeCapacitySaleConfigExportQueryPageListInfoRes> queryPageList(
      ApsMakeCapacitySaleConfigExportQueryPageListReq req);


  void setName(List<? extends ApsMakeCapacitySaleConfigDto> apsMakeCapacitySaleConfigDtoList);

  ApsMakeCapacitySaleConfigInsertRes save(ApsMakeCapacitySaleConfigInsertReq req);
}

