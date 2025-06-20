package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.ApsGoodsForecastComputeSaleDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.ApsGoodsForecastComputeSaleDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.ApsGoodsForecastComputeSaleDataImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.ApsGoodsForecastComputeSaleDataInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastComputeSaleData.ApsGoodsForecastComputeSaleDataUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastComputeSaleData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastComputeSaleDataConverter {

  ApsGoodsForecastComputeSaleDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastComputeSaleDataConverter.class);

  ApsGoodsForecastComputeSaleData insertReq(ApsGoodsForecastComputeSaleDataInsertReq req);

  ApsGoodsForecastComputeSaleData updateReq(ApsGoodsForecastComputeSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastComputeSaleDataDto> queryListRes(List<ApsGoodsForecastComputeSaleData> list);

  List<ApsGoodsForecastComputeSaleDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastComputeSaleData> list);

  List<ApsGoodsForecastComputeSaleData> importReq(
      List<ApsGoodsForecastComputeSaleDataImportReq> reqList);
}

