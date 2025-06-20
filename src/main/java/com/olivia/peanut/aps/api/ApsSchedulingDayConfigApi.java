package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigUpdateByIdRes;
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
 * 排程版本表(ApsSchedulingDayConfig)对外API
 *
 * @author peanut
 * @since 2024-07-19 19:19:48
 */
// @FeignClient(value = "",contextId = "apsSchedulingDayConfig-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingDayConfigApi {

  /**
   * 保存 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/insert")
  ApsSchedulingDayConfigInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingDayConfigInsertReq req);

  /**
   * 根据ID 删除 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/deleteByIdList")
  ApsSchedulingDayConfigDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingDayConfigDeleteByIdListReq req);

  /**
   * 查询 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/queryList")
  ApsSchedulingDayConfigQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingDayConfigQueryListReq req);

  /**
   * 根据ID 更新 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/updateById")
  ApsSchedulingDayConfigUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingDayConfigUpdateByIdReq req);

  /**
   * 分页查询 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/queryPageList")
  DynamicsPage<ApsSchedulingDayConfigExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingDayConfigExportQueryPageListReq req);

  /**
   * 导出 排程版本表
   */
  @PostMapping("/apsSchedulingDayConfig/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSchedulingDayConfigExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingDayConfig/importData")
  ApsSchedulingDayConfigImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingDayConfig/queryByIdList")
  ApsSchedulingDayConfigQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingDayConfigQueryByIdListReq req);


}
