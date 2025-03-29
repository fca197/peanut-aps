package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionLimit;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionLimitConverter {
  ApsSchedulingVersionLimitConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionLimitConverter.class);

  ApsSchedulingVersionLimit insertReq(ApsSchedulingVersionLimitInsertReq req);

  ApsSchedulingVersionLimit updateReq(ApsSchedulingVersionLimitUpdateByIdReq req);

  List<ApsSchedulingVersionLimitDto> queryListRes(List<ApsSchedulingVersionLimit> list);

  List<ApsSchedulingVersionLimitExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingVersionLimit> list);

  List<ApsSchedulingVersionLimit> importReq(List<ApsSchedulingVersionLimitImportReq> reqList);
}

