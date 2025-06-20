package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.ApsSchedulingVersionDayDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.ApsSchedulingVersionDayExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.ApsSchedulingVersionDayImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.ApsSchedulingVersionDayInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionDay.ApsSchedulingVersionDayUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingVersionDay;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionDayConverter {

  ApsSchedulingVersionDayConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingVersionDayConverter.class);

  ApsSchedulingVersionDay insertReq(ApsSchedulingVersionDayInsertReq req);

  ApsSchedulingVersionDay updateReq(ApsSchedulingVersionDayUpdateByIdReq req);

  List<ApsSchedulingVersionDayDto> queryListRes(List<ApsSchedulingVersionDay> list);

  List<ApsSchedulingVersionDayExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersionDay> list);

  List<ApsSchedulingVersionDay> importReq(List<ApsSchedulingVersionDayImportReq> reqList);
}

