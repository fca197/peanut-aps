package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderUser.*;
import com.olivia.peanut.aps.model.ApsOrderUser;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderUserConverter {
  ApsOrderUserConverter INSTANCE = Mappers.getMapper(ApsOrderUserConverter.class);

  ApsOrderUser insertReq(ApsOrderUserInsertReq req);

  ApsOrderUser updateReq(ApsOrderUserUpdateByIdReq req);

  List<ApsOrderUserDto> queryListRes(List<ApsOrderUser> list);

  List<ApsOrderUserExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderUser> list);

  List<ApsOrderUser> importReq(List<ApsOrderUserImportReq> reqList);
}

