package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)对外API
 *
 * @author admin
 * @since 2025-06-25 20:30:05
 */
// @FeignClient(value = "",contextId = "apsOrderGoodsBomKittingVersionOrderItem-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderGoodsBomKittingVersionOrderItemApi {

  /**
   * 保存 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/insert")
  ApsOrderGoodsBomKittingVersionOrderItemInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderGoodsBomKittingVersionOrderItemInsertReq req);

  /**
   * 根据ID 删除 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/deleteByIdList")
  ApsOrderGoodsBomKittingVersionOrderItemDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderItemDeleteByIdListReq req);

  /**
   * 查询 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/queryList")
  ApsOrderGoodsBomKittingVersionOrderItemQueryListRes queryList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderItemQueryListReq req);

  /**
   * 根据ID 更新 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/updateById")
  ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdReq req);

  /**
   * 分页查询 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/queryPageList")
  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req);

  /**
   * 导出 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/importData")
  ApsOrderGoodsBomKittingVersionOrderItemImportRes importData(
      @RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderItem/queryByIdList")
  ApsOrderGoodsBomKittingVersionOrderItemQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderItemQueryByIdListReq req);


}
