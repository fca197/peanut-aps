package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRoomConfig.*;
import com.olivia.peanut.aps.model.ApsRoomConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRoomConfigConverter {
  ApsRoomConfigConverter INSTANCE = Mappers.getMapper(ApsRoomConfigConverter.class);

  ApsRoomConfig insertReq(ApsRoomConfigInsertReq req);

  ApsRoomConfig updateReq(ApsRoomConfigUpdateByIdReq req);

  List<ApsRoomConfigDto> queryListRes(List<ApsRoomConfig> list);

  List<ApsRoomConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsRoomConfig> list);

  List<ApsRoomConfig> importReq(List<ApsRoomConfigImportReq> reqList);
}

