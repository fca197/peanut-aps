package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleData;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastUserSaleDataConverter {
  ApsGoodsForecastUserSaleDataConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastUserSaleDataConverter.class);

  ApsGoodsForecastUserSaleData insertReq(ApsGoodsForecastUserSaleDataInsertReq req);

  ApsGoodsForecastUserSaleData updateReq(ApsGoodsForecastUserSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastUserSaleDataDto> queryListRes(List<ApsGoodsForecastUserSaleData> list);

  List<ApsGoodsForecastUserSaleDataExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastUserSaleData> list);

  List<ApsGoodsForecastUserSaleData> importReq(List<ApsGoodsForecastUserSaleDataImportReq> reqList);
}

