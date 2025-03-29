package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionDay;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionDayConverter {
  ApsSchedulingVersionDayConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionDayConverter.class);

  ApsSchedulingVersionDay insertReq(ApsSchedulingVersionDayInsertReq req);

  ApsSchedulingVersionDay updateReq(ApsSchedulingVersionDayUpdateByIdReq req);

  List<ApsSchedulingVersionDayDto> queryListRes(List<ApsSchedulingVersionDay> list);

  List<ApsSchedulingVersionDayExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingVersionDay> list);

  List<ApsSchedulingVersionDay> importReq(List<ApsSchedulingVersionDayImportReq> reqList);
}

