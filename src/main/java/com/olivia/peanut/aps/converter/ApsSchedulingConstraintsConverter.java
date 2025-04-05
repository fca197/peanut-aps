package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.*;
import com.olivia.peanut.aps.model.ApsSchedulingConstraints;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingConstraintsConverter {
  ApsSchedulingConstraintsConverter INSTANCE = Mappers.getMapper(ApsSchedulingConstraintsConverter.class);

  ApsSchedulingConstraints insertReq(ApsSchedulingConstraintsInsertReq req);

  ApsSchedulingConstraints updateReq(ApsSchedulingConstraintsUpdateByIdReq req);

  List<ApsSchedulingConstraintsDto> queryListRes(List<ApsSchedulingConstraints> list);

  List<ApsSchedulingConstraintsExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingConstraints> list);

  List<ApsSchedulingConstraints> importReq(List<ApsSchedulingConstraintsImportReq> reqList);
}

