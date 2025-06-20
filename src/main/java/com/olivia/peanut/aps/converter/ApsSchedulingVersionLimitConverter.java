package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.ApsSchedulingVersionLimitDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.ApsSchedulingVersionLimitExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.ApsSchedulingVersionLimitImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.ApsSchedulingVersionLimitInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionLimit.ApsSchedulingVersionLimitUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingVersionLimit;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionLimitConverter {

  ApsSchedulingVersionLimitConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingVersionLimitConverter.class);

  ApsSchedulingVersionLimit insertReq(ApsSchedulingVersionLimitInsertReq req);

  ApsSchedulingVersionLimit updateReq(ApsSchedulingVersionLimitUpdateByIdReq req);

  List<ApsSchedulingVersionLimitDto> queryListRes(List<ApsSchedulingVersionLimit> list);

  List<ApsSchedulingVersionLimitExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersionLimit> list);

  List<ApsSchedulingVersionLimit> importReq(List<ApsSchedulingVersionLimitImportReq> reqList);
}

