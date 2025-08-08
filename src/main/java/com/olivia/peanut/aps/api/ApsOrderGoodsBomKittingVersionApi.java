package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;
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
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)对外API
 *
 * @author admin
 * @since 2025-06-25 10:13:07
 */
// @FeignClient(value = "",contextId = "apsOrderGoodsBomKittingVersion-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderGoodsBomKittingVersionApi {

  /**
   * 保存 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/insert")
  ApsOrderGoodsBomKittingVersionInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderGoodsBomKittingVersionInsertReq req);

  /**
   * 保存 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/createSchedulingKittingVersion")
  ApsOrderGoodsBomKittingVersionInsertRes createSchedulingKittingVersion(
      @RequestBody @Validated(InsertCheck.class) CreateSchedulingKittingVersion req);

  /**
   * 根据ID 删除 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/deleteByIdList")
  ApsOrderGoodsBomKittingVersionDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionDeleteByIdListReq req);

  /**
   * 查询 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/queryList")
  ApsOrderGoodsBomKittingVersionQueryListRes queryList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionQueryListReq req);

  /**
   * 根据ID 更新 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/updateById")
  ApsOrderGoodsBomKittingVersionUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderGoodsBomKittingVersionUpdateByIdReq req);

  /**
   * 分页查询 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/queryPageList")
  DynamicsPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionExportQueryPageListReq req);

  /**
   * 导出 齐套检查版本
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/importData")
  ApsOrderGoodsBomKittingVersionImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderGoodsBomKittingVersion/queryByIdList")
  ApsOrderGoodsBomKittingVersionQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionQueryByIdListReq req);


}
