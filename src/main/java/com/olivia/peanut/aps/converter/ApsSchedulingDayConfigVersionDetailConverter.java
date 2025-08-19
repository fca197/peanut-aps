package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetail;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailConverter {

  ApsSchedulingDayConfigVersionDetailConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigVersionDetailConverter.class);

  ApsSchedulingDayConfigVersionDetail insertReq(ApsSchedulingDayConfigVersionDetailInsertReq req);

  ApsSchedulingDayConfigVersionDetail updateReq(ApsSchedulingDayConfigVersionDetailUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailDto> queryListRes(List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetailExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetail> importReq(List<ApsSchedulingDayConfigVersionDetailImportReq> reqList);

  List<ApsSchedulingDayConfigVersionDetail> dto2entity(List<com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingDayConfigVersionDetailDto> dto);
}

