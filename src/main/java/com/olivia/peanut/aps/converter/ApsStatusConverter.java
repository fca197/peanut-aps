package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusDto;
import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusImportReq;
import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusInsertReq;
import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsStatus;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsStatusConverter {

  ApsStatusConverter INSTANCE = Mappers.getMapper(ApsStatusConverter.class);

  ApsStatus insertReq(ApsStatusInsertReq req);

  ApsStatus updateReq(ApsStatusUpdateByIdReq req);

  List<ApsStatusDto> queryListRes(List<ApsStatus> list);

  List<ApsStatusExportQueryPageListInfoRes> queryPageListRes(List<ApsStatus> list);

  List<ApsStatus> importReq(List<ApsStatusImportReq> reqList);
}

