package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigConverter {

  ApsSchedulingDayConfigConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingDayConfigConverter.class);

  ApsSchedulingDayConfig insertReq(ApsSchedulingDayConfigInsertReq req);

  ApsSchedulingDayConfig updateReq(ApsSchedulingDayConfigUpdateByIdReq req);

  List<ApsSchedulingDayConfigDto> queryListRes(List<ApsSchedulingDayConfig> list);

  List<ApsSchedulingDayConfigExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingDayConfig> list);

  List<ApsSchedulingDayConfig> importReq(List<ApsSchedulingDayConfigImportReq> reqList);
}

