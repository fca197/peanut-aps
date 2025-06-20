package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.ApsSchedulingDayConfigVersionDetailDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.ApsSchedulingDayConfigVersionDetailExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.ApsSchedulingDayConfigVersionDetailImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.ApsSchedulingDayConfigVersionDetailInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail.ApsSchedulingDayConfigVersionDetailUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetail;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailConverter {

  ApsSchedulingDayConfigVersionDetailConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingDayConfigVersionDetailConverter.class);

  ApsSchedulingDayConfigVersionDetail insertReq(ApsSchedulingDayConfigVersionDetailInsertReq req);

  ApsSchedulingDayConfigVersionDetail updateReq(
      ApsSchedulingDayConfigVersionDetailUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailDto> queryListRes(
      List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetailExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingDayConfigVersionDetail> list);

  List<ApsSchedulingDayConfigVersionDetail> importReq(
      List<ApsSchedulingDayConfigVersionDetailImportReq> reqList);
}

