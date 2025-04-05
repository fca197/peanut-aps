package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetail;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailConverter {
  ApsSchedulingDayConfigVersionDetailConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigVersionDetailConverter.class);

  ApsSchedulingDayConfigVersionDetail insertReq(ApsSchedulingDayConfigVersionDetailInsertReq req);

  ApsSchedulingDayConfigVersionDetail updateReq(ApsSchedulingDayConfigVersionDetailUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailDto> queryListRes(List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetailExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetail> importReq(List<ApsSchedulingDayConfigVersionDetailImportReq> reqList);
}

