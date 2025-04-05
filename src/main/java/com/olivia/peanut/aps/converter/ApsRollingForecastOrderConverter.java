package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.*;
import com.olivia.peanut.aps.model.ApsRollingForecastOrder;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastOrderConverter {
  ApsRollingForecastOrderConverter INSTANCE = Mappers.getMapper(ApsRollingForecastOrderConverter.class);

  ApsRollingForecastOrder insertReq(ApsRollingForecastOrderInsertReq req);

  ApsRollingForecastOrder updateReq(ApsRollingForecastOrderUpdateByIdReq req);

  List<ApsRollingForecastOrderDto> queryListRes(List<ApsRollingForecastOrder> list);

  List<ApsRollingForecastOrderExportQueryPageListInfoRes> queryPageListRes(List<ApsRollingForecastOrder> list);

  List<ApsRollingForecastOrder> importReq(List<ApsRollingForecastOrderImportReq> reqList);
}

