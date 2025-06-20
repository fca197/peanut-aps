package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.ApsGoodsForecastMainSaleDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.ApsGoodsForecastMainSaleDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.ApsGoodsForecastMainSaleDataExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.ApsGoodsForecastMainSaleDataQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.ApsGoodsForecastMainSaleDataQueryListRes;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainSaleData;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsGoodsForecastMainSaleData)表服务接口
 *
 * @author peanut
 * @since 2024-04-02 09:42:28
 */
public interface ApsGoodsForecastMainSaleDataService extends
    MPJBaseService<ApsGoodsForecastMainSaleData> {

  ApsGoodsForecastMainSaleDataQueryListRes queryList(ApsGoodsForecastMainSaleDataQueryListReq req);

  DynamicsPage<ApsGoodsForecastMainSaleDataExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastMainSaleDataExportQueryPageListReq req);


  void setName(List<? extends ApsGoodsForecastMainSaleDataDto> apsGoodsForecastMainSaleDataDtoList);
}

