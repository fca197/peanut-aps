package com.olivia.peanut.aps.api.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsGoodsForecastApi;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastImportReq;
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
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ForecastStatusEnum;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.UploadTemplateRes;
import com.olivia.peanut.aps.api.impl.listener.ApsGoodsForecastImportListenerAbstract;
import com.olivia.peanut.aps.model.ApsGoodsForecast;
import com.olivia.peanut.aps.service.ApsGoodsForecastService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DateUtils;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.JSON;
import com.olivia.sdk.utils.PoiExcelUtil;
import com.olivia.sdk.utils.model.YearMonth;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsGoodsForecast)表服务实现类
 *
 * @author peanut
 * @since 2024-03-30 13:38:52
 */
@Slf4j
@RestController
public class ApsGoodsForecastApiImpl implements ApsGoodsForecastApi {

  private @Autowired ApsGoodsForecastService apsGoodsForecastService;


  /****
   * insert
   *
   */
  public @Override ApsGoodsForecastInsertRes insert(ApsGoodsForecastInsertReq req) {
    String ms = JSON.toJSONString(
        DateUtils.getMonthList(req.getForecastBeginDate(), req.getForecastEndDate()).stream()
            .map(YearMonth::toString).toList());
    req.setMonths(ms);
    this.apsGoodsForecastService.save($.copy(req, ApsGoodsForecast.class)
        .setForecastStatus(ForecastStatusEnum.TO_UPLOAD.getCode()));
    return new ApsGoodsForecastInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsGoodsForecastDeleteByIdListRes deleteByIdList(
      ApsGoodsForecastDeleteByIdListReq req) {
    apsGoodsForecastService.removeByIds(req.getIdList());
    return new ApsGoodsForecastDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsGoodsForecastQueryListRes queryList(ApsGoodsForecastQueryListReq req) {
    return apsGoodsForecastService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsGoodsForecastUpdateByIdRes updateById(ApsGoodsForecastUpdateByIdReq req) {

    String ms = JSON.toJSONString(
        DateUtils.getMonthList(req.getForecastBeginDate(), req.getForecastEndDate()).stream()
            .map(YearMonth::toString).toList());
    req.setMonths(ms);
    ApsGoodsForecast forecast = $.copy(req, ApsGoodsForecast.class);
    apsGoodsForecastService.updateById(forecast);
    return new ApsGoodsForecastUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsGoodsForecastExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastExportQueryPageListReq req) {
    return apsGoodsForecastService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsGoodsForecastExportQueryPageListReq req) {
    DynamicsPage<ApsGoodsForecastExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsGoodsForecastExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsGoodsForecastExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsGoodsForecastExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsGoodsForecastExportQueryPageListInfoRes.class, listInfoRes, "");
  }

  public @Override ApsGoodsForecastImportRes importData(@RequestParam("file") MultipartFile file) {
    List<ApsGoodsForecastImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsGoodsForecastImportListenerAbstract(), ApsGoodsForecastImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsGoodsForecast> readList = $.copyList(reqList, ApsGoodsForecast.class);
    boolean bool = apsGoodsForecastService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsGoodsForecastImportRes().setCount(c);
  }

  public @Override ApsGoodsForecastQueryByIdListRes queryByIdListRes(
      ApsGoodsForecastQueryByIdListReq req) {
    MPJLambdaWrapper<ApsGoodsForecast> q = new MPJLambdaWrapper<ApsGoodsForecast>(
        ApsGoodsForecast.class).selectAll(ApsGoodsForecast.class)
        .in(ApsGoodsForecast::getId, req.getIdList());
    List<ApsGoodsForecast> list = this.apsGoodsForecastService.list(q);
    List<ApsGoodsForecastDto> dataList = $.copyList(list, ApsGoodsForecastDto.class);
    return new ApsGoodsForecastQueryByIdListRes().setDataList(dataList);
  }

  @Override
  public void downloadTemplate(Long id) {
    this.apsGoodsForecastService.downloadTemplate(id);
  }

  @Override
  public UploadTemplateRes uploadTemplate(@PathVariable("id") Long id,
      MultipartFile multipartFile) {
    try {
      return this.apsGoodsForecastService.uploadTemplate(id, multipartFile);
    } catch (Exception e) {
      log.error("Error a upload template id  {} msg: {}", id, e.getMessage(), e);
      throw e;
    }
  }

  @Override
  public DynamicsPage<GetForecastDataByIdRes> getForecastDataById(GetForecastDataByIdReq req) {
    return this.apsGoodsForecastService.getForecastDataById(req);
  }

  @Override
  public ComputeRes compute(ComputeReq req) {
    return this.apsGoodsForecastService.compute(req);
  }

  @Override
  public DeployRes deploy(DeployReq req) {
    return this.apsGoodsForecastService.deploy(req);
  }

  @Override
  public DynamicsPage<ComputeResultRes> computeResult(ComputeResultReq req) {
    return this.apsGoodsForecastService.computeResult(req);
  }
}
