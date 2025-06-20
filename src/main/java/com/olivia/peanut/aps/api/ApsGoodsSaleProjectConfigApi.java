package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigImportRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigSale2ProjectReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigSale2ProjectRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigUpdateByIdRes;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsGoodsSaleProjectConfig)对外API
 *
 * @author peanut
 * @since 2024-04-27 16:07:21
 */
// @FeignClient(value = "",contextId = "apsGoodsSaleProjectConfig-api",url = "${ portal..center.endpoint:}")
public interface ApsGoodsSaleProjectConfigApi {

  /**
   * 保存
   */
  @PostMapping("/apsGoodsSaleProjectConfig/insert")
  ApsGoodsSaleProjectConfigInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsGoodsSaleProjectConfigInsertReq req);

  @PostMapping("/apsGoodsSaleProjectConfig/insertBatch")
  ApsGoodsSaleProjectConfigInsertRes insertBatch(
      @RequestBody @Valid List<ApsGoodsSaleProjectConfigInsertReq> req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsGoodsSaleProjectConfig/deleteByIdList")
  ApsGoodsSaleProjectConfigDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsGoodsSaleProjectConfigDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsGoodsSaleProjectConfig/queryList")
  ApsGoodsSaleProjectConfigQueryListRes queryList(
      @RequestBody @Valid ApsGoodsSaleProjectConfigQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsGoodsSaleProjectConfig/updateById")
  ApsGoodsSaleProjectConfigUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsGoodsSaleProjectConfigUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsGoodsSaleProjectConfig/queryPageList")
  DynamicsPage<ApsGoodsSaleProjectConfigExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsGoodsSaleProjectConfigExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsGoodsSaleProjectConfig/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsGoodsSaleProjectConfigExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsGoodsSaleProjectConfig/importData")
  ApsGoodsSaleProjectConfigImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsGoodsSaleProjectConfig/queryByIdList")
  ApsGoodsSaleProjectConfigQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsGoodsSaleProjectConfigQueryByIdListReq req);


  @PostMapping("/apsGoodsSaleProjectConfig/sale2project")
  ApsGoodsSaleProjectConfigSale2ProjectRes sale2project(
      @RequestBody @Valid ApsGoodsSaleProjectConfigSale2ProjectReq req) throws ExecutionException;

}
