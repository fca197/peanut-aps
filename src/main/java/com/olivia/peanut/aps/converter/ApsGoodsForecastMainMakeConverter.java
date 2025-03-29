package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainMake;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainMakeConverter {
  ApsGoodsForecastMainMakeConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMainMakeConverter.class);

  ApsGoodsForecastMainMake insertReq(ApsGoodsForecastMainMakeInsertReq req);

  ApsGoodsForecastMainMake updateReq(ApsGoodsForecastMainMakeUpdateByIdReq req);

  List<ApsGoodsForecastMainMakeDto> queryListRes(List<ApsGoodsForecastMainMake> list);

  List<ApsGoodsForecastMainMakeExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMainMake> list);

  List<ApsGoodsForecastMainMake> importReq(List<ApsGoodsForecastMainMakeImportReq> reqList);
}

