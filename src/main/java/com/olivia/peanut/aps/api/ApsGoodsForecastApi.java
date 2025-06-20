package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastImportRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeResultReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeResultRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.DeployReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.DeployRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.UploadTemplateRes;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsGoodsForecast)对外API
 *
 * @author peanut
 * @since 2024-03-30 13:38:52
 */
// @FeignClient(value = "",contextId = "apsGoodsForecast-api",url = "${ portal..center.endpoint:}")
public interface ApsGoodsForecastApi {

  /**
   * 保存
   */
  @PostMapping("/apsGoodsForecast/insert")
  ApsGoodsForecastInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsGoodsForecastInsertReq req);

  /**
   * 根据ID 删除
   */
  @PostMapping("/apsGoodsForecast/deleteByIdList")
  ApsGoodsForecastDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsGoodsForecastDeleteByIdListReq req);

  /**
   * 查询
   */
  @PostMapping("/apsGoodsForecast/queryList")
  ApsGoodsForecastQueryListRes queryList(@RequestBody @Valid ApsGoodsForecastQueryListReq req);

  /**
   * 根据ID 更新
   */
  @PostMapping("/apsGoodsForecast/updateById")
  ApsGoodsForecastUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsGoodsForecastUpdateByIdReq req);

  /**
   * 分页查询
   */
  @PostMapping("/apsGoodsForecast/queryPageList")
  DynamicsPage<ApsGoodsForecastExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsGoodsForecastExportQueryPageListReq req);

  /**
   * 导出
   */
  @PostMapping("/apsGoodsForecast/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsGoodsForecastExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsGoodsForecast/importData")
  ApsGoodsForecastImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsGoodsForecast/queryByIdList")
  ApsGoodsForecastQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsGoodsForecastQueryByIdListReq req);


  @PostMapping("/apsGoodsForecast/downloadTemplate/{id}")
  void downloadTemplate(@PathVariable("id") Long id);

  @PostMapping("/apsGoodsForecast/uploadTemplate/{id}")
  UploadTemplateRes uploadTemplate(@PathVariable("id") Long id,
      @RequestParam("file") MultipartFile multipartFile);


  @PostMapping("/apsGoodsForecast/getForecastDataById")
  DynamicsPage<GetForecastDataByIdRes> getForecastDataById(
      @RequestBody @Valid GetForecastDataByIdReq req);

  @PostMapping("/apsGoodsForecast/computeResult")
  DynamicsPage<ComputeResultRes> computeResult(@RequestBody @Valid ComputeResultReq req);

  @PostMapping("/apsGoodsForecast/compute")
  ComputeRes compute(@RequestBody @Valid ComputeReq req);


  @PostMapping("/apsGoodsForecast/deploy")
  DeployRes deploy(@RequestBody @Valid DeployReq req);


}
