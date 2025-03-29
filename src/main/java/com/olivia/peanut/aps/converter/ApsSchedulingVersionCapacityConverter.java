package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionCapacity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionCapacityConverter {
  ApsSchedulingVersionCapacityConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionCapacityConverter.class);

  ApsSchedulingVersionCapacity insertReq(ApsSchedulingVersionCapacityInsertReq req);

  ApsSchedulingVersionCapacity updateReq(ApsSchedulingVersionCapacityUpdateByIdReq req);

  List<ApsSchedulingVersionCapacityDto> queryListRes(List<ApsSchedulingVersionCapacity> list);

  List<ApsSchedulingVersionCapacityExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingVersionCapacity> list);

  List<ApsSchedulingVersionCapacity> importReq(List<ApsSchedulingVersionCapacityImportReq> reqList);
}

