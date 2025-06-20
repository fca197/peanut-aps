package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderDto;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderImportReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsRollingForecastOrder.ApsRollingForecastOrderUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsRollingForecastOrder;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastOrderConverter {

  ApsRollingForecastOrderConverter INSTANCE = Mappers.getMapper(
      ApsRollingForecastOrderConverter.class);

  ApsRollingForecastOrder insertReq(ApsRollingForecastOrderInsertReq req);

  ApsRollingForecastOrder updateReq(ApsRollingForecastOrderUpdateByIdReq req);

  List<ApsRollingForecastOrderDto> queryListRes(List<ApsRollingForecastOrder> list);

  List<ApsRollingForecastOrderExportQueryPageListInfoRes> queryPageListRes(
      List<ApsRollingForecastOrder> list);

  List<ApsRollingForecastOrder> importReq(List<ApsRollingForecastOrderImportReq> reqList);
}

