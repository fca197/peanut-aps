package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMake;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeConverter {
  ApsGoodsForecastMakeConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMakeConverter.class);

  ApsGoodsForecastMake insertReq(ApsGoodsForecastMakeInsertReq req);

  ApsGoodsForecastMake updateReq(ApsGoodsForecastMakeUpdateByIdReq req);

  List<ApsGoodsForecastMakeDto> queryListRes(List<ApsGoodsForecastMake> list);

  List<ApsGoodsForecastMakeExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMake> list);

  List<ApsGoodsForecastMake> importReq(List<ApsGoodsForecastMakeImportReq> reqList);
}

