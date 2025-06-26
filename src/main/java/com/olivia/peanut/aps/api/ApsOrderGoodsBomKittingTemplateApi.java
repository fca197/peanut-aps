package com.olivia.peanut.aps.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)对外API
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
// @FeignClient(value = "",contextId = "apsOrderGoodsBomKittingTemplate-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderGoodsBomKittingTemplateApi {

  /**
   * 保存 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/insert")
  ApsOrderGoodsBomKittingTemplateInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderGoodsBomKittingTemplateInsertReq req);

  /**
   * 根据ID 删除 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/deleteByIdList")
  ApsOrderGoodsBomKittingTemplateDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderGoodsBomKittingTemplateDeleteByIdListReq req);

  /**
   * 查询 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/queryList")
  ApsOrderGoodsBomKittingTemplateQueryListRes queryList(
      @RequestBody @Valid ApsOrderGoodsBomKittingTemplateQueryListReq req);

  /**
   * 根据ID 更新 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/updateById")
  ApsOrderGoodsBomKittingTemplateUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderGoodsBomKittingTemplateUpdateByIdReq req);

  /**
   * 分页查询 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/queryPageList")
  DynamicsPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req);

  /**
   * 导出 齐套模板
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/importData")
  ApsOrderGoodsBomKittingTemplateImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderGoodsBomKittingTemplate/queryByIdList")
  ApsOrderGoodsBomKittingTemplateQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderGoodsBomKittingTemplateQueryByIdListReq req);


}
