package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsForecastMake;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsForecastMakeConverter {
  ApsOrderGoodsForecastMakeConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsForecastMakeConverter.class);

  ApsOrderGoodsForecastMake insertReq(ApsOrderGoodsForecastMakeInsertReq req);

  ApsOrderGoodsForecastMake updateReq(ApsOrderGoodsForecastMakeUpdateByIdReq req);

  List<ApsOrderGoodsForecastMakeDto> queryListRes(List<ApsOrderGoodsForecastMake> list);

  List<ApsOrderGoodsForecastMakeExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsForecastMake> list);

  List<ApsOrderGoodsForecastMake> importReq(List<ApsOrderGoodsForecastMakeImportReq> reqList);
}

