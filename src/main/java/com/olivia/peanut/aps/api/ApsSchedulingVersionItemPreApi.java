package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)对外API
 *
 * @author makejava
 * @since 2025-04-06 14:16:39
 */
// @FeignClient(value = "",contextId = "apsSchedulingVersionItemPre-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingVersionItemPreApi {

  /**
   * 保存 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/insert")
  ApsSchedulingVersionItemPreInsertRes insert(@RequestBody @Validated(InsertCheck.class) ApsSchedulingVersionItemPreInsertReq req);

  /**
   * 根据ID 删除 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/deleteByIdList")
  ApsSchedulingVersionItemPreDeleteByIdListRes deleteByIdList(@RequestBody @Valid ApsSchedulingVersionItemPreDeleteByIdListReq req);

  /**
   * 查询 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/queryList")
  ApsSchedulingVersionItemPreQueryListRes queryList(@RequestBody @Valid ApsSchedulingVersionItemPreQueryListReq req);

  /**
   * 根据ID 更新 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/updateById")
  ApsSchedulingVersionItemPreUpdateByIdRes updateById(@RequestBody @Validated(UpdateCheck.class) ApsSchedulingVersionItemPreUpdateByIdReq req);

  /**
   * 分页查询 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/queryPageList")
  DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageList(@RequestBody @Valid ApsSchedulingVersionItemPreExportQueryPageListReq req);

  /**
   * 导出 排产下发订单预览
   */
  @PostMapping("/apsSchedulingVersionItemPre/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSchedulingVersionItemPreExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingVersionItemPre/importData")
  ApsSchedulingVersionItemPreImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingVersionItemPre/queryByIdList")
  ApsSchedulingVersionItemPreQueryByIdListRes queryByIdListRes(@RequestBody @Valid ApsSchedulingVersionItemPreQueryByIdListReq req);


}
