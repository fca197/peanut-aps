package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.*;
import com.olivia.peanut.aps.model.ApsProcessPathRoom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProcessPathRoomConverter {
  ApsProcessPathRoomConverter INSTANCE = Mappers.getMapper(ApsProcessPathRoomConverter.class);

  ApsProcessPathRoom insertReq(ApsProcessPathRoomInsertReq req);

  ApsProcessPathRoom updateReq(ApsProcessPathRoomUpdateByIdReq req);

  List<ApsProcessPathRoomDto> queryListRes(List<ApsProcessPathRoom> list);

  List<ApsProcessPathRoomExportQueryPageListInfoRes> queryPageListRes(List<ApsProcessPathRoom> list);

  List<ApsProcessPathRoom> importReq(List<ApsProcessPathRoomImportReq> reqList);
}

