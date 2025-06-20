package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemUpdateByIdRes;
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
 * (ApsSchedulingVersionItem)对外API
 *
 * @author peanut
 * @since 2024-04-16 09:24:05
 */
// @FeignClient(value = "",contextId = "apsSchedulingVersionItem-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingVersionItemApi {

  /**
   * 保存
   */
  @PostMapping("/apsSchedulingVersionItem/insert")
  ApsSchedulingVersionItemInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingVersionItemInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsSchedulingVersionItem/deleteByIdList")
  ApsSchedulingVersionItemDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingVersionItemDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsSchedulingVersionItem/queryList")
  ApsSchedulingVersionItemQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingVersionItemQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsSchedulingVersionItem/updateById")
  ApsSchedulingVersionItemUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingVersionItemUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsSchedulingVersionItem/queryPageList")
  DynamicsPage<ApsSchedulingVersionItemExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingVersionItemExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsSchedulingVersionItem/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsSchedulingVersionItemExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingVersionItem/importData")
  ApsSchedulingVersionItemImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingVersionItem/queryByIdList")
  ApsSchedulingVersionItemQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingVersionItemQueryByIdListReq req);


}
