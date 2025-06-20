package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.QueryDayCountReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.QueryDayCountRes;
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
 * 排产下发详情(ApsSchedulingIssueItem)对外API
 *
 * @author peanut
 * @since 2024-07-20 13:55:54
 */
// @FeignClient(value = "",contextId = "apsSchedulingIssueItem-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingIssueItemApi {

  /**
   * 保存 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/insert")
  ApsSchedulingIssueItemInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingIssueItemInsertReq req);

  /**
   * 根据ID 删除 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/deleteByIdList")
  ApsSchedulingIssueItemDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingIssueItemDeleteByIdListReq req);

  /**
   * 查询 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/queryList")
  ApsSchedulingIssueItemQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingIssueItemQueryListReq req);

  /**
   * 根据ID 更新 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/updateById")
  ApsSchedulingIssueItemUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingIssueItemUpdateByIdReq req);

  /**
   * 分页查询 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/queryPageList")
  DynamicsPage<ApsSchedulingIssueItemExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingIssueItemExportQueryPageListReq req);

  /**
   * 导出 排产下发详情
   */
  @PostMapping("/apsSchedulingIssueItem/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSchedulingIssueItemExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingIssueItem/importData")
  ApsSchedulingIssueItemImportRes importData(@RequestParam("file") MultipartFile file);

  @PostMapping("/apsSchedulingIssueItem/queryDayCount")
  QueryDayCountRes queryDayCount(@RequestBody QueryDayCountReq req);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingIssueItem/queryByIdList")
  ApsSchedulingIssueItemQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingIssueItemQueryByIdListReq req);


}
