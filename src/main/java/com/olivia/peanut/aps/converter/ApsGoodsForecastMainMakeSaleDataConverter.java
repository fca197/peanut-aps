package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMakeSaleData.ApsGoodsForecastMainMakeSaleDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMakeSaleData.ApsGoodsForecastMainMakeSaleDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMakeSaleData.ApsGoodsForecastMainMakeSaleDataImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMakeSaleData.ApsGoodsForecastMainMakeSaleDataInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMakeSaleData.ApsGoodsForecastMainMakeSaleDataUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainMakeSaleData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainMakeSaleDataConverter {

  ApsGoodsForecastMainMakeSaleDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMainMakeSaleDataConverter.class);

  ApsGoodsForecastMainMakeSaleData insertReq(ApsGoodsForecastMainMakeSaleDataInsertReq req);

  ApsGoodsForecastMainMakeSaleData updateReq(ApsGoodsForecastMainMakeSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastMainMakeSaleDataDto> queryListRes(
      List<ApsGoodsForecastMainMakeSaleData> list);

  List<ApsGoodsForecastMainMakeSaleDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMainMakeSaleData> list);

  List<ApsGoodsForecastMainMakeSaleData> importReq(
      List<ApsGoodsForecastMainMakeSaleDataImportReq> reqList);
}

