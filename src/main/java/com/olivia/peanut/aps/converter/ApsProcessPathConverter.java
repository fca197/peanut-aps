package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathDto;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathImportReq;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathInsertReq;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsProcessPath;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProcessPathConverter {

  ApsProcessPathConverter INSTANCE = Mappers.getMapper(ApsProcessPathConverter.class);

  ApsProcessPath insertReq(ApsProcessPathInsertReq req);

  ApsProcessPath updateReq(ApsProcessPathUpdateByIdReq req);

  List<ApsProcessPathDto> queryListRes(List<ApsProcessPath> list);

  List<ApsProcessPathExportQueryPageListInfoRes> queryPageListRes(List<ApsProcessPath> list);

  List<ApsProcessPath> importReq(List<ApsProcessPathImportReq> reqList);
}

