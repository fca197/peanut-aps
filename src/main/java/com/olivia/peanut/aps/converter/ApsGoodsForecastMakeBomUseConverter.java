package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeBomUse.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMakeBomUse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeBomUseConverter {
  ApsGoodsForecastMakeBomUseConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMakeBomUseConverter.class);

  ApsGoodsForecastMakeBomUse insertReq(ApsGoodsForecastMakeBomUseInsertReq req);

  ApsGoodsForecastMakeBomUse updateReq(ApsGoodsForecastMakeBomUseUpdateByIdReq req);

  List<ApsGoodsForecastMakeBomUseDto> queryListRes(List<ApsGoodsForecastMakeBomUse> list);

  List<ApsGoodsForecastMakeBomUseExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMakeBomUse> list);

  List<ApsGoodsForecastMakeBomUse> importReq(List<ApsGoodsForecastMakeBomUseImportReq> reqList);
}

