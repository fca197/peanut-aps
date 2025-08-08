package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersion;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionConverter {

  ApsSchedulingDayConfigVersionConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigVersionConverter.class);

  ApsSchedulingDayConfigVersion insertReq(ApsSchedulingDayConfigVersionInsertReq req);

  ApsSchedulingDayConfigVersion updateReq(ApsSchedulingDayConfigVersionUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDto> queryListRes(List<ApsSchedulingDayConfigVersion> list);

  List<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigVersion> list);

  List<ApsSchedulingDayConfigVersion> importReq(List<ApsSchedulingDayConfigVersionImportReq> reqList);

  ApsSchedulingDayConfigVersion dto2Model(ApsSchedulingDayConfigVersionDto req);
}

