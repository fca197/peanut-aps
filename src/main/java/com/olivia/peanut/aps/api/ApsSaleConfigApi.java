package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigImportRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSaleConfig.ApsSaleConfigUpdateByIdRes;
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
 * (ApsSaleConfig)对外API
 *
 * @author peanut
 * @since 2024-03-29 23:10:38
 */
// @FeignClient(value = "",contextId = "apsSaleConfig-api",url = "${ portal..center.endpoint:}")
public interface ApsSaleConfigApi {

  /**
   * 保存
   */
  @PostMapping("/apsSaleConfig/insert")
  ApsSaleConfigInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSaleConfigInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsSaleConfig/deleteByIdList")
  ApsSaleConfigDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSaleConfigDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsSaleConfig/queryList")
  ApsSaleConfigQueryListRes queryList(@RequestBody @Valid ApsSaleConfigQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsSaleConfig/updateById")
  ApsSaleConfigUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSaleConfigUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsSaleConfig/queryPageList")
  DynamicsPage<ApsSaleConfigExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSaleConfigExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsSaleConfig/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSaleConfigExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSaleConfig/importData")
  ApsSaleConfigImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSaleConfig/queryByIdList")
  ApsSaleConfigQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSaleConfigQueryByIdListReq req);


}
