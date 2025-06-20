package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.ApsProcessPathRoomDto;
import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.ApsProcessPathRoomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.ApsProcessPathRoomImportReq;
import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.ApsProcessPathRoomInsertReq;
import com.olivia.peanut.aps.api.entity.apsProcessPathRoom.ApsProcessPathRoomUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsProcessPathRoom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProcessPathRoomConverter {

  ApsProcessPathRoomConverter INSTANCE = Mappers.getMapper(ApsProcessPathRoomConverter.class);

  ApsProcessPathRoom insertReq(ApsProcessPathRoomInsertReq req);

  ApsProcessPathRoom updateReq(ApsProcessPathRoomUpdateByIdReq req);

  List<ApsProcessPathRoomDto> queryListRes(List<ApsProcessPathRoom> list);

  List<ApsProcessPathRoomExportQueryPageListInfoRes> queryPageListRes(
      List<ApsProcessPathRoom> list);

  List<ApsProcessPathRoom> importReq(List<ApsProcessPathRoomImportReq> reqList);
}

