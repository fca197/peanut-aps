package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemDto;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemQueryListRes;
import com.olivia.peanut.aps.model.ApsRollingForecastOrderItem;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 滚动预测订单节点表(ApsRollingForecastOrderItem)表服务接口
 *
 * @author peanut
 * @since 2024-07-16 10:31:19
 */
public interface ApsRollingForecastOrderItemService extends
    MPJBaseService<ApsRollingForecastOrderItem> {

  ApsRollingForecastOrderItemQueryListRes queryList(ApsRollingForecastOrderItemQueryListReq req);

  DynamicsPage<ApsRollingForecastOrderItemExportQueryPageListInfoRes> queryPageList(
      ApsRollingForecastOrderItemExportQueryPageListReq req);


  void setName(List<? extends ApsRollingForecastOrderItemDto> apsRollingForecastOrderItemDtoList);
}

