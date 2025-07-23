package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)对外API
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
// @FeignClient(value = "",contextId = "apsMachineWorkstationItem-api",url = "${ portal..center.endpoint:}")
public interface ApsMachineWorkstationItemApi {

  /**
   * 保存 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/insert")
  ApsMachineWorkstationItemInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsMachineWorkstationItemInsertReq req);

  /**
   * 根据ID 删除 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/deleteByIdList")
  ApsMachineWorkstationItemDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsMachineWorkstationItemDeleteByIdListReq req);

  /**
   * 查询 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/queryList")
  ApsMachineWorkstationItemQueryListRes queryList(
      @RequestBody @Valid ApsMachineWorkstationItemQueryListReq req);

  /**
   * 根据ID 更新 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/updateById")
  ApsMachineWorkstationItemUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsMachineWorkstationItemUpdateByIdReq req);

  /**
   * 分页查询 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/queryPageList")
  DynamicsPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsMachineWorkstationItemExportQueryPageListReq req);

  /**
   * 导出 aps 生产机器 工作站机器配置
   */
  @PostMapping("/apsMachineWorkstationItem/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsMachineWorkstationItemExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsMachineWorkstationItem/importData")
  ApsMachineWorkstationItemImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsMachineWorkstationItem/queryByIdList")
  ApsMachineWorkstationItemQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsMachineWorkstationItemQueryByIdListReq req);


}
