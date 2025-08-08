package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsBomGroup.*;
import com.olivia.peanut.aps.model.ApsBomGroup;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsBomGroupConverter {

  ApsBomGroupConverter INSTANCE = Mappers.getMapper(ApsBomGroupConverter.class);

  ApsBomGroup insertReq(ApsBomGroupInsertReq req);

  ApsBomGroup updateReq(ApsBomGroupUpdateByIdReq req);

  List<ApsBomGroupDto> queryListRes(List<ApsBomGroup> list);

  List<ApsBomGroupExportQueryPageListInfoRes> queryPageListRes(List<ApsBomGroup> list);

  List<ApsBomGroup> importReq(List<ApsBomGroupImportReq> reqList);
}

