package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
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
 * 订单显示模板(ApsOrderFieldShowTemplate)对外API
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
// @FeignClient(value = "",contextId = "apsOrderFieldShowTemplate-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderFieldShowTemplateApi {

  /**
   * 保存 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/insert")
  ApsOrderFieldShowTemplateInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderFieldShowTemplateInsertReq req);

  /**
   * 根据ID 删除 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/deleteByIdList")
  ApsOrderFieldShowTemplateDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderFieldShowTemplateDeleteByIdListReq req);

  /**
   * 查询 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/queryList")
  ApsOrderFieldShowTemplateQueryListRes queryList(
      @RequestBody @Valid ApsOrderFieldShowTemplateQueryListReq req);

  /**
   * 根据ID 更新 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/updateById")
  ApsOrderFieldShowTemplateUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderFieldShowTemplateUpdateByIdReq req);

  /**
   * 分页查询 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/queryPageList")
  DynamicsPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderFieldShowTemplateExportQueryPageListReq req);

  /**
   * 导出 订单显示模板
   */
  @PostMapping("/apsOrderFieldShowTemplate/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsOrderFieldShowTemplateExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderFieldShowTemplate/importData")
  ApsOrderFieldShowTemplateImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderFieldShowTemplate/queryByIdList")
  ApsOrderFieldShowTemplateQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderFieldShowTemplateQueryByIdListReq req);


}
