package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeployReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDeployRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeImportRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryUseBomByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeQueryUseBomByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeUpdateByIdRes;
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
 * (ApsGoodsForecastMake)对外API
 *
 * @author peanut
 * @since 2024-04-07 15:07:48
 */
// @FeignClient(value = "",contextId = "apsGoodsForecastMake-api",url = "${ portal..center.endpoint:}")
public interface ApsGoodsForecastMakeApi {

  /**
   * 保存
   */
  @PostMapping("/apsGoodsForecastMake/insert")
  ApsGoodsForecastMakeInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsGoodsForecastMakeInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsGoodsForecastMake/deleteByIdList")
  ApsGoodsForecastMakeDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsGoodsForecastMakeDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsGoodsForecastMake/queryList")
  ApsGoodsForecastMakeQueryListRes queryList(
      @RequestBody @Valid ApsGoodsForecastMakeQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsGoodsForecastMake/updateById")
  ApsGoodsForecastMakeUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsGoodsForecastMakeUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsGoodsForecastMake/queryPageList")
  DynamicsPage<ApsGoodsForecastMakeExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsGoodsForecastMakeExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsGoodsForecastMake/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsGoodsForecastMakeExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsGoodsForecastMake/importData")
  ApsGoodsForecastMakeImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsGoodsForecastMake/queryByIdList")
  ApsGoodsForecastMakeQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsGoodsForecastMakeQueryByIdListReq req);

  @PostMapping("/apsGoodsForecastMake/queryDataById")
  DynamicsPage<ApsGoodsForecastMakeQueryDataByIdRes> queryDataById(
      @RequestBody @Valid ApsGoodsForecastMakeQueryDataByIdReq req);

  @PostMapping("/apsGoodsForecastMake/queryProjectDataById")
  DynamicsPage<ApsGoodsForecastMakeQueryDataByIdRes> queryProjectDataById(
      @RequestBody @Valid ApsGoodsForecastMakeQueryDataByIdReq req);

  @PostMapping("/apsGoodsForecastMake/queryBomUseDataById")
  DynamicsPage<ApsGoodsForecastMakeQueryUseBomByIdRes> queryBomUseDataById(
      @RequestBody @Valid ApsGoodsForecastMakeQueryUseBomByIdReq req);


  @PostMapping("/apsGoodsForecastMake/deploy")
  ApsGoodsForecastMakeDeployRes deploy(@RequestBody @Valid ApsGoodsForecastMakeDeployReq req);

}
