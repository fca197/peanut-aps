package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * aps 生产机器 工作站(ApsMachineWorkstation)对外API
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
// @FeignClient(value = "",contextId = "apsMachineWorkstation-api",url = "${ portal..center.endpoint:}")
public interface ApsMachineWorkstationApi {

  /**
   * 保存 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/insert")
  ApsMachineWorkstationInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsMachineWorkstationInsertReq req);

  /**
   * 根据ID 删除 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/deleteByIdList")
  ApsMachineWorkstationDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsMachineWorkstationDeleteByIdListReq req);

  /**
   * 查询 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/queryList")
  ApsMachineWorkstationQueryListRes queryList(
      @RequestBody @Valid ApsMachineWorkstationQueryListReq req);

  /**
   * 根据ID 更新 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/updateById")
  ApsMachineWorkstationUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsMachineWorkstationUpdateByIdReq req);

  /**
   * 分页查询 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/queryPageList")
  DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsMachineWorkstationExportQueryPageListReq req);

  /**
   * 导出 aps 生产机器 工作站
   */
  @PostMapping("/apsMachineWorkstation/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsMachineWorkstationExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsMachineWorkstation/importData")
  ApsMachineWorkstationImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsMachineWorkstation/queryByIdList")
  ApsMachineWorkstationQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsMachineWorkstationQueryByIdListReq req);


}
