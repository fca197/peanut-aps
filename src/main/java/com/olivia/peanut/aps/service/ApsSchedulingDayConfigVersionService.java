package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionOrderExportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListRes;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersion;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 排程版本(ApsSchedulingDayConfigVersion)表服务接口
 *
 * @author peanut
 * @since 2024-07-19 19:19:55
 */
public interface ApsSchedulingDayConfigVersionService extends
    MPJBaseService<ApsSchedulingDayConfigVersion> {

  ApsSchedulingDayConfigVersionInsertRes save(ApsSchedulingDayConfigVersionInsertReq req);

  ApsSchedulingDayConfigVersionQueryListRes queryList(
      ApsSchedulingDayConfigVersionQueryListReq req);

  DynamicsPage<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingDayConfigVersionExportQueryPageListReq req);


  void setName(
      List<? extends ApsSchedulingDayConfigVersionDto> apsSchedulingDayConfigVersionDtoList);

  ApsSchedulingDayConfigVersionDetailListRes detailList(
      ApsSchedulingDayConfigVersionDetailListReq req);

  ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes updateOrderSortIndex(
      ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq req);

  CanSchedulingOrderListRes canSchedulingOrderList(CanSchedulingOrderListReq req);

  ApsSchedulingDayConfigVersionAddOrderRes addOrder(ApsSchedulingDayConfigVersionAddOrderReq req);

  void apsSchedulingDayConfigVersionOrderExport(ApsSchedulingDayConfigVersionOrderExportReq req);

  void schedulingOrderList(ApsSchedulingDayConfigVersionDto req);
}

