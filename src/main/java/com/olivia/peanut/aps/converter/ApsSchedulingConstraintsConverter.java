package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.*;
import com.olivia.peanut.aps.model.ApsSchedulingConstraints;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingConstraintsConverter {

  ApsSchedulingConstraintsConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingConstraintsConverter.class);

  ApsSchedulingConstraints insertReq(ApsSchedulingConstraintsInsertReq req);

  ApsSchedulingConstraints updateReq(ApsSchedulingConstraintsUpdateByIdReq req);

  List<ApsSchedulingConstraintsDto> queryListRes(List<ApsSchedulingConstraints> list);

  List<ApsSchedulingConstraintsExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingConstraints> list);

  List<ApsSchedulingConstraints> importReq(List<ApsSchedulingConstraintsImportReq> reqList);
}

