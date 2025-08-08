package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeSaleData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMakeSaleData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeSaleDataConverter {

  ApsGoodsForecastMakeSaleDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMakeSaleDataConverter.class);

  ApsGoodsForecastMakeSaleData insertReq(ApsGoodsForecastMakeSaleDataInsertReq req);

  ApsGoodsForecastMakeSaleData updateReq(ApsGoodsForecastMakeSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastMakeSaleDataDto> queryListRes(List<ApsGoodsForecastMakeSaleData> list);

  List<ApsGoodsForecastMakeSaleDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMakeSaleData> list);

  List<ApsGoodsForecastMakeSaleData> importReq(List<ApsGoodsForecastMakeSaleDataImportReq> reqList);
}

