package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionOrderExportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListRes;
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
 * 排程版本(ApsSchedulingDayConfigVersion)对外API
 *
 * @author peanut
 * @since 2024-07-19 19:19:54
 */
// @FeignClient(value = "",contextId = "apsSchedulingDayConfigVersion-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingDayConfigVersionApi {

  /**
   * 保存 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/insert")
  ApsSchedulingDayConfigVersionInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingDayConfigVersionInsertReq req);

  /**
   * 保存 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/canSchedulingOrderList")
  CanSchedulingOrderListRes canSchedulingOrderList(
      @RequestBody @Validated(InsertCheck.class) CanSchedulingOrderListReq req);


  /**
   * 根据ID 删除 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/deleteByIdList")
  ApsSchedulingDayConfigVersionDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingDayConfigVersionDeleteByIdListReq req);

  /**
   * 查询 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/queryList")
  ApsSchedulingDayConfigVersionQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingDayConfigVersionQueryListReq req);

  /**
   * 根据ID 更新 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/updateById")
  ApsSchedulingDayConfigVersionUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingDayConfigVersionUpdateByIdReq req);

  /**
   * 分页查询 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/queryPageList")
  DynamicsPage<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingDayConfigVersionExportQueryPageListReq req);

  /**
   * 导出 排程版本
   */
  @PostMapping("/apsSchedulingDayConfigVersion/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsSchedulingDayConfigVersionExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingDayConfigVersion/importData")
  ApsSchedulingDayConfigVersionImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingDayConfigVersion/queryByIdList")
  ApsSchedulingDayConfigVersionQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingDayConfigVersionQueryByIdListReq req);

  /***
   * detailList
   */
  @PostMapping("/apsSchedulingDayConfigVersion/detailList")
  ApsSchedulingDayConfigVersionDetailListRes detailList(
      @RequestBody @Valid ApsSchedulingDayConfigVersionDetailListReq req);

  // updateOrderSortIndex
  @PostMapping("/apsSchedulingDayConfigVersion/updateOrderSortIndex")
  ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes updateOrderSortIndex(
      @RequestBody @Valid ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq req);

  @PostMapping("/apsSchedulingDayConfigVersion/addOrder")
  ApsSchedulingDayConfigVersionAddOrderRes addOrder(
      @RequestBody @Valid ApsSchedulingDayConfigVersionAddOrderReq req);

  @PostMapping("/apsSchedulingDayConfigVersion/export")
  void apsSchedulingDayConfigVersionOrderExport(
      @RequestBody @Valid ApsSchedulingDayConfigVersionOrderExportReq req);

  @PostMapping("/apsSchedulingDayConfigVersion/schedulingOrderList")
  void schedulingOrderList(@RequestBody @Valid ApsSchedulingDayConfigVersionDto req);

}
