package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainSaleData;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainSaleDataConverter {
  ApsGoodsForecastMainSaleDataConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMainSaleDataConverter.class);

  ApsGoodsForecastMainSaleData insertReq(ApsGoodsForecastMainSaleDataInsertReq req);

  ApsGoodsForecastMainSaleData updateReq(ApsGoodsForecastMainSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastMainSaleDataDto> queryListRes(List<ApsGoodsForecastMainSaleData> list);

  List<ApsGoodsForecastMainSaleDataExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMainSaleData> list);

  List<ApsGoodsForecastMainSaleData> importReq(List<ApsGoodsForecastMainSaleDataImportReq> reqList);
}

