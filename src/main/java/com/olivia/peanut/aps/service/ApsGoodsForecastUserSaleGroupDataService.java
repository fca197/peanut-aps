package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleGroupData;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData.*;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)表服务接口
 *
 * @author admin
 * @since 2025-06-23 13:13:59
 */
public interface ApsGoodsForecastUserSaleGroupDataService extends
    MPJBaseService<ApsGoodsForecastUserSaleGroupData> {

  ApsGoodsForecastUserSaleGroupDataQueryListRes queryList(
      ApsGoodsForecastUserSaleGroupDataQueryListReq req);

  DynamicsPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req);


  void setName(
      List<? extends ApsGoodsForecastUserSaleGroupDataDto> apsGoodsForecastUserSaleGroupDataDtoList);
}

