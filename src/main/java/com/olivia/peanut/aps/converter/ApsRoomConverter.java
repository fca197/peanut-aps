package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsRoom.ApsRoomDto;
import com.olivia.peanut.aps.api.entity.apsRoom.ApsRoomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRoom.ApsRoomImportReq;
import com.olivia.peanut.aps.api.entity.apsRoom.ApsRoomInsertReq;
import com.olivia.peanut.aps.api.entity.apsRoom.ApsRoomUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsRoom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsRoomConverter {

  ApsRoomConverter INSTANCE = Mappers.getMapper(ApsRoomConverter.class);

  ApsRoom insertReq(ApsRoomInsertReq req);

  ApsRoom updateReq(ApsRoomUpdateByIdReq req);

  List<ApsRoomDto> queryListRes(List<ApsRoom> list);

  List<ApsRoomExportQueryPageListInfoRes> queryPageListRes(List<ApsRoom> list);

  List<ApsRoom> importReq(List<ApsRoomImportReq> reqList);
}

