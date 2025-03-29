package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMain.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMain;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainConverter {
  ApsGoodsForecastMainConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMainConverter.class);

  ApsGoodsForecastMain insertReq(ApsGoodsForecastMainInsertReq req);

  ApsGoodsForecastMain updateReq(ApsGoodsForecastMainUpdateByIdReq req);

  List<ApsGoodsForecastMainDto> queryListRes(List<ApsGoodsForecastMain> list);

  List<ApsGoodsForecastMainExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMain> list);

  List<ApsGoodsForecastMain> importReq(List<ApsGoodsForecastMainImportReq> reqList);
}

