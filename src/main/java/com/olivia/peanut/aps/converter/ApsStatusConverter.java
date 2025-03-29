package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsStatus.*;
import com.olivia.peanut.aps.model.ApsStatus;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsStatusConverter {
  ApsStatusConverter INSTANCE = Mappers.getMapper(ApsStatusConverter.class);

  ApsStatus insertReq(ApsStatusInsertReq req);

  ApsStatus updateReq(ApsStatusUpdateByIdReq req);

  List<ApsStatusDto> queryListRes(List<ApsStatus> list);

  List<ApsStatusExportQueryPageListInfoRes> queryPageListRes(List<ApsStatus> list);

  List<ApsStatus> importReq(List<ApsStatusImportReq> reqList);
}

