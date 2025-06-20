package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.ApsGoodsForecastUserSaleDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.ApsGoodsForecastUserSaleDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.ApsGoodsForecastUserSaleDataImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.ApsGoodsForecastUserSaleDataInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData.ApsGoodsForecastUserSaleDataUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastUserSaleDataConverter {

  ApsGoodsForecastUserSaleDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastUserSaleDataConverter.class);

  ApsGoodsForecastUserSaleData insertReq(ApsGoodsForecastUserSaleDataInsertReq req);

  ApsGoodsForecastUserSaleData updateReq(ApsGoodsForecastUserSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastUserSaleDataDto> queryListRes(List<ApsGoodsForecastUserSaleData> list);

  List<ApsGoodsForecastUserSaleDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastUserSaleData> list);

  List<ApsGoodsForecastUserSaleData> importReq(List<ApsGoodsForecastUserSaleDataImportReq> reqList);
}

