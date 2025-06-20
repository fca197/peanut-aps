package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeployReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeployRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryUseBomByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryUseBomByIdRes;
import com.olivia.peanut.aps.model.ApsGoodsForecastMake;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsGoodsForecastMake)表服务接口
 *
 * @author peanut
 * @since 2024-04-07 15:07:48
 */
public interface ApsGoodsForecastMakeService extends MPJBaseService<ApsGoodsForecastMake> {

  ApsGoodsForecastMakeQueryListRes queryList(ApsGoodsForecastMakeQueryListReq req);

  DynamicsPage<ApsGoodsForecastMakeExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastMakeExportQueryPageListReq req);


  void setName(List<? extends ApsGoodsForecastMakeDto> apsGoodsForecastMakeDtoList);

  ApsGoodsForecastMakeInsertRes save(ApsGoodsForecastMakeInsertReq req);

  DynamicsPage<ApsGoodsForecastMakeQueryDataByIdRes> queryDataById(
      ApsGoodsForecastMakeQueryDataByIdReq req);

  ApsGoodsForecastMakeDeployRes deploy(ApsGoodsForecastMakeDeployReq req);

  DynamicsPage<ApsGoodsForecastMakeQueryDataByIdRes> queryProjectDataById(
      ApsGoodsForecastMakeQueryDataByIdReq req);

  DynamicsPage<ApsGoodsForecastMakeQueryUseBomByIdRes> queryBomUseDataById(
      ApsGoodsForecastMakeQueryUseBomByIdReq req);
}

