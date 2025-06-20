package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserDto;
import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserImportReq;
import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsOrderUser;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderUserConverter {

  ApsOrderUserConverter INSTANCE = Mappers.getMapper(ApsOrderUserConverter.class);

  ApsOrderUser insertReq(ApsOrderUserInsertReq req);

  ApsOrderUser updateReq(ApsOrderUserUpdateByIdReq req);

  List<ApsOrderUserDto> queryListRes(List<ApsOrderUser> list);

  List<ApsOrderUserExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderUser> list);

  List<ApsOrderUser> importReq(List<ApsOrderUserImportReq> reqList);
}

