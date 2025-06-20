package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeQueryDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeQueryDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeQueryListRes;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainMake;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsGoodsForecastMainMake)表服务接口
 *
 * @author peanut
 * @since 2024-04-08 09:52:50
 */
public interface ApsGoodsForecastMainMakeService extends MPJBaseService<ApsGoodsForecastMainMake> {

  ApsGoodsForecastMainMakeQueryListRes queryList(ApsGoodsForecastMainMakeQueryListReq req);

  DynamicsPage<ApsGoodsForecastMainMakeExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastMainMakeExportQueryPageListReq req);


  void setName(List<? extends ApsGoodsForecastMainMakeDto> apsGoodsForecastMainMakeDtoList);

  DynamicsPage<ApsGoodsForecastMainMakeQueryDataByIdRes> queryDataById(
      ApsGoodsForecastMainMakeQueryDataByIdReq req);
}

