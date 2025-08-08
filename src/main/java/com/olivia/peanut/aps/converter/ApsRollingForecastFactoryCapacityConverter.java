package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRollingForecastFactoryCapacity.*;
import com.olivia.peanut.aps.model.ApsRollingForecastFactoryCapacity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRollingForecastFactoryCapacityConverter {

  ApsRollingForecastFactoryCapacityConverter INSTANCE = Mappers.getMapper(ApsRollingForecastFactoryCapacityConverter.class);

  ApsRollingForecastFactoryCapacity insertReq(ApsRollingForecastFactoryCapacityInsertReq req);

  ApsRollingForecastFactoryCapacity updateReq(ApsRollingForecastFactoryCapacityUpdateByIdReq req);

  List<ApsRollingForecastFactoryCapacityDto> queryListRes(List<ApsRollingForecastFactoryCapacity> list);

  List<ApsRollingForecastFactoryCapacityExportQueryPageListInfoRes> queryPageListRes(List<ApsRollingForecastFactoryCapacity> list);

  List<ApsRollingForecastFactoryCapacity> importReq(List<ApsRollingForecastFactoryCapacityImportReq> reqList);
}

