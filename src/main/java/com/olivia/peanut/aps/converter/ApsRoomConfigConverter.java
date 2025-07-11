package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigDto;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigImportReq;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsRoomConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRoomConfigConverter {

  ApsRoomConfigConverter INSTANCE = Mappers.getMapper(ApsRoomConfigConverter.class);

  ApsRoomConfig insertReq(ApsRoomConfigInsertReq req);

  ApsRoomConfig updateReq(ApsRoomConfigUpdateByIdReq req);

  List<ApsRoomConfigDto> queryListRes(List<ApsRoomConfig> list);

  List<ApsRoomConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsRoomConfig> list);

  List<ApsRoomConfig> importReq(List<ApsRoomConfigImportReq> reqList);
}

