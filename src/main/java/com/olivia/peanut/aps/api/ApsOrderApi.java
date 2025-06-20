package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderImportRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateByIdRes;
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
import com.olivia.peanut.aps.api.entity.apsOrder.OrderStatusListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderStatusListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountReq;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountRes;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsOrder)对外API
 *
 * @author peanut
 * @since 2024-04-09 13:19:35
 */
// @FeignClient(value = "",contextId = "apsOrder-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderApi {

  @PostMapping("/apsOrder/batchInsert")
  ApsOrderBatchInsertRes batchInsert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderBatchInsertReq req);

  /**
   * 保存
   */
  @PostMapping("/apsOrder/insert")
  ApsOrderInsertRes insert(@RequestBody @Validated(InsertCheck.class) ApsOrderInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsOrder/deleteByIdList")
  ApsOrderDeleteByIdListRes deleteByIdList(@RequestBody @Valid ApsOrderDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsOrder/queryList")
  ApsOrderQueryListRes queryList(@RequestBody @Valid ApsOrderQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsOrder/updateById")
  ApsOrderUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsOrder/queryPageList")
  DynamicsPage<ApsOrderExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsOrder/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsOrderExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrder/importData")
  ApsOrderImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrder/queryByIdList")
  ApsOrderQueryByIdListRes queryByIdListRes(@RequestBody @Valid ApsOrderQueryByIdListReq req);

  @PostMapping("/apsOrder/timeLine")
  DynamicsPage<ApsOrderTimeLineRes> timeLine(@RequestBody @Valid ApsOrderTimeLineReq req);

  @PostMapping("/apsOrder/updateOrderStatus")
  ApsOrderUpdateOrderStatusRes updateOrderStatus(
      @RequestBody @Valid ApsOrderUpdateOrderStatusReq req);

  //schedulingDate
  @PostMapping("/apsOrder/updateSchedulingDate")
  ApsOrderUpdateSchedulingDateRes updateSchedulingDate(
      @RequestBody @Valid ApsOrderUpdateSchedulingDateReq req);

  @PostMapping("/apsOrder/orderCreateByMonth")
  OrderCreateByMonthCountRes orderCreateByMonth(@RequestBody @Valid OrderCreateByMonthCountReq req);

  @PostMapping("/apsOrder/statusList")
  OrderStatusListRes orderStatusList(@RequestBody @Valid OrderStatusListReq req);

  @PostMapping("/apsOrder/status/count")
  StatusCountRes statusCount(@RequestBody @Valid StatusCountReq req);

  @PostMapping("/apsOrder/finishOrderTotalDay")
  FinishOrderTotalDayRes finishOrderTotalDay(@RequestBody FinishOrderTotalDayReq req);


  @PostMapping("/apsOrder/orderFieldList")
  OrderFieldListRes orderFieldList(@RequestBody OrderFieldListReq req);

}
