package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomImportRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdRes;
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
 * 齐套检查版本详情(apsOrderGoodsBomKittingVersionOrderBom)对外API
 *
 * @author admin
 * @since 2025-06-25 20:30:05
 */
// @FeignClient(value = "",contextId = "apsOrderGoodsBomKittingVersionOrderBom-api",url = "${ portal..center.endpoint:}")
public interface ApsOrderGoodsBomKittingVersionOrderBomApi {

  /**
   * 保存 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/insert")
  ApsOrderGoodsBomKittingVersionOrderBomInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsOrderGoodsBomKittingVersionOrderBomInsertReq req);

  /**
   * 根据ID 删除 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/deleteByIdList")
  ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListReq req);

  /**
   * 查询 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/queryList")
  ApsOrderGoodsBomKittingVersionOrderBomQueryListRes queryList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderBomQueryListReq req);

  /**
   * 根据ID 更新 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/updateById")
  ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdReq req);

  /**
   * 分页查询 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/queryPageList")
  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req);

  /**
   * 导出 齐套检查版本详情
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/importData")
  ApsOrderGoodsBomKittingVersionOrderBomImportRes importData(
      @RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsOrderGoodsBomKittingVersionOrderBom/queryByIdList")
  ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListReq req);


}
