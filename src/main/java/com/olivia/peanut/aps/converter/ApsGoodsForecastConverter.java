package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecast.*;
import com.olivia.peanut.aps.model.ApsGoodsForecast;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastConverter {
  ApsGoodsForecastConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastConverter.class);

  ApsGoodsForecast insertReq(ApsGoodsForecastInsertReq req);

  ApsGoodsForecast updateReq(ApsGoodsForecastUpdateByIdReq req);

  List<ApsGoodsForecastDto> queryListRes(List<ApsGoodsForecast> list);

  List<ApsGoodsForecastExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecast> list);

  List<ApsGoodsForecast> importReq(List<ApsGoodsForecastImportReq> reqList);
}

