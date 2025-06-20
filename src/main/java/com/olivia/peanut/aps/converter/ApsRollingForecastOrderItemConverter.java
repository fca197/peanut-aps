package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemDto;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemImportReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem.ApsRollingForecastOrderItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsRollingForecastOrderItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastOrderItemConverter {

  ApsRollingForecastOrderItemConverter INSTANCE = Mappers.getMapper(
      ApsRollingForecastOrderItemConverter.class);

  ApsRollingForecastOrderItem insertReq(ApsRollingForecastOrderItemInsertReq req);

  ApsRollingForecastOrderItem updateReq(ApsRollingForecastOrderItemUpdateByIdReq req);

  List<ApsRollingForecastOrderItemDto> queryListRes(List<ApsRollingForecastOrderItem> list);

  List<ApsRollingForecastOrderItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsRollingForecastOrderItem> list);

  List<ApsRollingForecastOrderItem> importReq(List<ApsRollingForecastOrderItemImportReq> reqList);
}

