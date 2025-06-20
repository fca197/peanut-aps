package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingVersion;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionConverter {

  ApsSchedulingVersionConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionConverter.class);

  ApsSchedulingVersion insertReq(ApsSchedulingVersionInsertReq req);

  ApsSchedulingVersion updateReq(ApsSchedulingVersionUpdateByIdReq req);

  List<ApsSchedulingVersionDto> queryListRes(List<ApsSchedulingVersion> list);

  List<ApsSchedulingVersionExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersion> list);

  List<ApsSchedulingVersion> importReq(List<ApsSchedulingVersionImportReq> reqList);
}

