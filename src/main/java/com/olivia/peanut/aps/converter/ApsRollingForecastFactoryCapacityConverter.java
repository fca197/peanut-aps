package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastFactoryCapacity.*;
import com.olivia.peanut.aps.model.ApsRollingForecastFactoryCapacity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastFactoryCapacityConverter {
  ApsRollingForecastFactoryCapacityConverter INSTANCE = Mappers.getMapper(ApsRollingForecastFactoryCapacityConverter.class);

  ApsRollingForecastFactoryCapacity insertReq(ApsRollingForecastFactoryCapacityInsertReq req);

  ApsRollingForecastFactoryCapacity updateReq(ApsRollingForecastFactoryCapacityUpdateByIdReq req);

  List<ApsRollingForecastFactoryCapacityDto> queryListRes(List<ApsRollingForecastFactoryCapacity> list);

  List<ApsRollingForecastFactoryCapacityExportQueryPageListInfoRes> queryPageListRes(List<ApsRollingForecastFactoryCapacity> list);

  List<ApsRollingForecastFactoryCapacity> importReq(List<ApsRollingForecastFactoryCapacityImportReq> reqList);
}

