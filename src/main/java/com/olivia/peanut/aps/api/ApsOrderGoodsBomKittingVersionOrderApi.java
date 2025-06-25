package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)对外API
 *
 * @author admin
 * @since 2025-06-25 14:23:48
 */
// @FeignClient(value = "",contextId = "apsOrderGoodsBomKittingVersionOrder-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderGoodsBomKittingVersionOrderApi {

  /**
   * 保存 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/insert")
  ApsOrderGoodsBomKittingVersionOrderInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderGoodsBomKittingVersionOrderInsertReq req);

  /**
   * 根据ID 删除 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/deleteByIdList")
  ApsOrderGoodsBomKittingVersionOrderDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderDeleteByIdListReq req);

  /**
   * 查询 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/queryList")
  ApsOrderGoodsBomKittingVersionOrderQueryListRes queryList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderQueryListReq req);

  /**
   * 根据ID 更新 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/updateById")
  ApsOrderGoodsBomKittingVersionOrderUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderGoodsBomKittingVersionOrderUpdateByIdReq req);

  /**
   * 分页查询 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/queryPageList")
  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req);

  /**
   * 导出 齐套检查订单详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/importData")
  ApsOrderGoodsBomKittingVersionOrderImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrder/queryByIdList")
  ApsOrderGoodsBomKittingVersionOrderQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderQueryByIdListReq req);


}
