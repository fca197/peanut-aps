package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ApsGoodsForecastQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeResultReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.ComputeResultRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.DeployReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.DeployRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.GetForecastDataByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecast.UploadTemplateRes;
import com.olivia.peanut.aps.model.ApsGoodsForecast;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsGoodsForecast)表服务接口
 *
 * @author peanut
 * @since 2024-03-30 13:38:53
 */
public interface ApsGoodsForecastService extends MPJBaseService<ApsGoodsForecast> {

  ApsGoodsForecastQueryListRes queryList(ApsGoodsForecastQueryListReq req);

  DynamicsPage<ApsGoodsForecastExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastExportQueryPageListReq req);


  void setName(List<? extends ApsGoodsForecastDto> apsGoodsForecastDtoList);

  void downloadTemplate(Long id);

  UploadTemplateRes uploadTemplate(Long id, MultipartFile multipartFile);

  DynamicsPage<GetForecastDataByIdRes> getForecastDataById(GetForecastDataByIdReq req);

  ComputeRes compute(ComputeReq req);

  DynamicsPage<ComputeResultRes> computeResult(ComputeResultReq req);

  DeployRes deploy(DeployReq req);
}

