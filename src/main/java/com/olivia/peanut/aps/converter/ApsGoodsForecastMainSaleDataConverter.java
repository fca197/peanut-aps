package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainSaleData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainSaleData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainSaleDataConverter {

  ApsGoodsForecastMainSaleDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMainSaleDataConverter.class);

  ApsGoodsForecastMainSaleData insertReq(ApsGoodsForecastMainSaleDataInsertReq req);

  ApsGoodsForecastMainSaleData updateReq(ApsGoodsForecastMainSaleDataUpdateByIdReq req);

  List<ApsGoodsForecastMainSaleDataDto> queryListRes(List<ApsGoodsForecastMainSaleData> list);

  List<ApsGoodsForecastMainSaleDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMainSaleData> list);

  List<ApsGoodsForecastMainSaleData> importReq(List<ApsGoodsForecastMainSaleDataImportReq> reqList);
}

