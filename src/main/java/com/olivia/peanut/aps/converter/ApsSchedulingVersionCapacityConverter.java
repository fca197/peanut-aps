package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.ApsSchedulingVersionCapacityDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.ApsSchedulingVersionCapacityExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.ApsSchedulingVersionCapacityImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.ApsSchedulingVersionCapacityInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity.ApsSchedulingVersionCapacityUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingVersionCapacity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionCapacityConverter {

  ApsSchedulingVersionCapacityConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingVersionCapacityConverter.class);

  ApsSchedulingVersionCapacity insertReq(ApsSchedulingVersionCapacityInsertReq req);

  ApsSchedulingVersionCapacity updateReq(ApsSchedulingVersionCapacityUpdateByIdReq req);

  List<ApsSchedulingVersionCapacityDto> queryListRes(List<ApsSchedulingVersionCapacity> list);

  List<ApsSchedulingVersionCapacityExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersionCapacity> list);

  List<ApsSchedulingVersionCapacity> importReq(List<ApsSchedulingVersionCapacityImportReq> reqList);
}

