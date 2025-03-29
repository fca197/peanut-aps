package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.*;
import com.olivia.peanut.aps.model.ApsRollingForecastOrderItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastOrderItemConverter {
  ApsRollingForecastOrderItemConverter INSTANCE = Mappers.getMapper(ApsRollingForecastOrderItemConverter.class);

  ApsRollingForecastOrderItem insertReq(ApsRollingForecastOrderItemInsertReq req);

  ApsRollingForecastOrderItem updateReq(ApsRollingForecastOrderItemUpdateByIdReq req);

  List<ApsRollingForecastOrderItemDto> queryListRes(List<ApsRollingForecastOrderItem> list);

  List<ApsRollingForecastOrderItemExportQueryPageListInfoRes> queryPageListRes(List<ApsRollingForecastOrderItem> list);

  List<ApsRollingForecastOrderItem> importReq(List<ApsRollingForecastOrderItemImportReq> reqList);
}

