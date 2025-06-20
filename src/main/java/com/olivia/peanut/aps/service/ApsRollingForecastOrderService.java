package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderDto;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderInsertRes;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderQueryListReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderQueryListRes;
import com.olivia.peanut.aps.model.ApsRollingForecastOrder;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 滚动预测(ApsRollingForecastOrder)表服务接口
 *
 * @author peanut
 * @since 2024-07-14 20:22:28
 */
public interface ApsRollingForecastOrderService extends MPJBaseService<ApsRollingForecastOrder> {

  ApsRollingForecastOrderQueryListRes queryList(ApsRollingForecastOrderQueryListReq req);

  DynamicsPage<ApsRollingForecastOrderExportQueryPageListInfoRes> queryPageList(
      ApsRollingForecastOrderExportQueryPageListReq req);


  void setName(List<? extends ApsRollingForecastOrderDto> apsRollingForecastOrderDtoList);

  ApsRollingForecastOrderInsertRes save(ApsRollingForecastOrderInsertReq req);
}

