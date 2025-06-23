package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)对外API
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
// @FeignClient(value = "",contextId = "apsGoodsForecastUserSaleGroupData-api",url = "${ portal..center.endpoint:}")
public interface ApsGoodsForecastUserSaleGroupDataApi {

  /**
   * 保存 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/insert")
  ApsGoodsForecastUserSaleGroupDataInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsGoodsForecastUserSaleGroupDataInsertReq req);

  /**
   * 根据ID 删除 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/deleteByIdList")
  ApsGoodsForecastUserSaleGroupDataDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsGoodsForecastUserSaleGroupDataDeleteByIdListReq req);

  /**
   * 查询 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/queryList")
  ApsGoodsForecastUserSaleGroupDataQueryListRes queryList(
      @RequestBody @Valid ApsGoodsForecastUserSaleGroupDataQueryListReq req);

  /**
   * 根据ID 更新 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/updateById")
  ApsGoodsForecastUserSaleGroupDataUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsGoodsForecastUserSaleGroupDataUpdateByIdReq req);

  /**
   * 分页查询 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/queryPageList")
  DynamicsPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req);

  /**
   * 导出 预测销售组数据
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/importData")
  ApsGoodsForecastUserSaleGroupDataImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsGoodsForecastUserSaleGroupData/queryByIdList")
  ApsGoodsForecastUserSaleGroupDataQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsGoodsForecastUserSaleGroupDataQueryByIdListReq req);


}
