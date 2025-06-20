package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDto;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateOrderStatusReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateOrderStatusRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateSchedulingDateReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateSchedulingDateRes;
import com.olivia.peanut.aps.api.entity.apsOrder.FinishOrderTotalDayReq;
import com.olivia.peanut.aps.api.entity.apsOrder.FinishOrderTotalDayRes;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderCreateByMonthCountReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderCreateByMonthCountRes;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderFieldListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderFieldListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountReq;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountRes;
import com.olivia.peanut.aps.model.ApsOrder;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsOrder)表服务接口
 *
 * @author peanut
 * @since 2024-04-09 13:19:35
 */
public interface ApsOrderService extends MPJBaseService<ApsOrder> {

  ApsOrderQueryListRes queryList(ApsOrderQueryListReq req);

  DynamicsPage<ApsOrderExportQueryPageListInfoRes> queryPageList(
      ApsOrderExportQueryPageListReq req);


  void setName(List<? extends ApsOrderDto> apsOrderDtoList);

  ApsOrderInsertRes save(ApsOrderInsertReq req);

  ApsOrder getApsOrderByNo(String orderNo);

  ApsOrderBatchInsertRes saveBatch(ApsOrderBatchInsertReq req);

  DynamicsPage<ApsOrderTimeLineRes> timeLine(ApsOrderTimeLineReq req);

  ApsOrderUpdateOrderStatusRes updateOrderStatus(ApsOrderUpdateOrderStatusReq req);

  ApsOrderUpdateSchedulingDateRes updateSchedulingDate(ApsOrderUpdateSchedulingDateReq req);

  OrderCreateByMonthCountRes orderCreateByMonth(OrderCreateByMonthCountReq req);

  StatusCountRes statusCount(StatusCountReq req);

  FinishOrderTotalDayRes finishOrderTotalDay(FinishOrderTotalDayReq req);

  OrderFieldListRes orderFieldList(OrderFieldListReq req);
}

