package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastComputeSaleData;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastComputeSaleDataConverter {
  ApsGoodsForecastComputeSaleDataConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastComputeSaleDataConverter.class);

  ApsGoodsForecastComputeSaleData insertReq(ApsGoodsForecastComputeSaleDataInsertReq req);

  ApsGoodsForecastComputeSaleData updateReq(ApsGoodsForecastComputeSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastComputeSaleDataDto> queryListRes(List<ApsGoodsForecastComputeSaleData> list);

  List<ApsGoodsForecastComputeSaleDataExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastComputeSaleData> list);

  List<ApsGoodsForecastComputeSaleData> importReq(List<ApsGoodsForecastComputeSaleDataImportReq> reqList);
}

