package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeBomUse.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMakeBomUse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeBomUseConverter {

  ApsGoodsForecastMakeBomUseConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMakeBomUseConverter.class);

  ApsGoodsForecastMakeBomUse insertReq(ApsGoodsForecastMakeBomUseInsertReq req);

  ApsGoodsForecastMakeBomUse updateReq(ApsGoodsForecastMakeBomUseUpdateByIdReq req);

  List<ApsGoodsForecastMakeBomUseDto> queryListRes(List<ApsGoodsForecastMakeBomUse> list);

  List<ApsGoodsForecastMakeBomUseExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMakeBomUse> list);

  List<ApsGoodsForecastMakeBomUse> importReq(List<ApsGoodsForecastMakeBomUseImportReq> reqList);
}

