package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecast.*;
import com.olivia.peanut.aps.model.ApsGoodsForecast;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastConverter {

  ApsGoodsForecastConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastConverter.class);

  ApsGoodsForecast insertReq(ApsGoodsForecastInsertReq req);

  ApsGoodsForecast updateReq(ApsGoodsForecastUpdateByIdReq req);

  List<ApsGoodsForecastDto> queryListRes(List<ApsGoodsForecast> list);

  List<ApsGoodsForecastExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecast> list);

  List<ApsGoodsForecast> importReq(List<ApsGoodsForecastImportReq> reqList);
}

