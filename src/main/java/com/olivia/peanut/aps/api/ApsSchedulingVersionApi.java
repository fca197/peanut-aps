package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionFinishReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionFinishRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsResultReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsResultRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityResultReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityResultRes;
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
 * (ApsSchedulingVersion)对外API
 *
 * @author peanut
 * @since 2024-04-13 21:32:13
 */
// @FeignClient(value = "",contextId = "apsSchedulingVersion-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingVersionApi {

  /**
   * 保存
   */
  @PostMapping("/apsSchedulingVersion/insert")
  ApsSchedulingVersionInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingVersionInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsSchedulingVersion/deleteByIdList")
  ApsSchedulingVersionDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingVersionDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsSchedulingVersion/queryList")
  ApsSchedulingVersionQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingVersionQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsSchedulingVersion/updateById")
  ApsSchedulingVersionUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingVersionUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsSchedulingVersion/queryPageList")
  DynamicsPage<ApsSchedulingVersionExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingVersionExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsSchedulingVersion/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSchedulingVersionExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingVersion/importData")
  ApsSchedulingVersionImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingVersion/queryByIdList")
  ApsSchedulingVersionQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingVersionQueryByIdListReq req);


  @PostMapping("/apsSchedulingVersion/useConstraints")
  ApsSchedulingVersionUseConstraintsRes useConstraints(
      @RequestBody @Valid ApsSchedulingVersionUseConstraintsReq req);

  @PostMapping("/apsSchedulingVersion/useConstraintsResult")
  DynamicsPage<ApsSchedulingVersionUseConstraintsResultRes> useConstraintsResult(
      @RequestBody @Valid ApsSchedulingVersionUseConstraintsResultReq req);

  @PostMapping("/apsSchedulingVersion/useMakeCapacity")
  ApsSchedulingVersionUseMakeCapacityRes useMakeCapacity(
      @RequestBody @Valid ApsSchedulingVersionUseMakeCapacityReq req);

  @PostMapping("/apsSchedulingVersion/useMakeCapacityResult")
  DynamicsPage<ApsSchedulingVersionUseMakeCapacityResultRes> useMakeCapacityResult(
      @RequestBody @Valid ApsSchedulingVersionUseMakeCapacityResultReq req);

  @PostMapping("/apsSchedulingVersion/finish")
  ApsSchedulingVersionFinishRes finish(@RequestBody @Valid ApsSchedulingVersionFinishReq req);


}
