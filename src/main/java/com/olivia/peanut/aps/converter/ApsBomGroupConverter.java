package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsBomGroup.*;
import com.olivia.peanut.aps.model.ApsBomGroup;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsBomGroupConverter {
  ApsBomGroupConverter INSTANCE = Mappers.getMapper(ApsBomGroupConverter.class);

  ApsBomGroup insertReq(ApsBomGroupInsertReq req);

  ApsBomGroup updateReq(ApsBomGroupUpdateByIdReq req);

  List<ApsBomGroupDto> queryListRes(List<ApsBomGroup> list);

  List<ApsBomGroupExportQueryPageListInfoRes> queryPageListRes(List<ApsBomGroup> list);

  List<ApsBomGroup> importReq(List<ApsBomGroupImportReq> reqList);
}

