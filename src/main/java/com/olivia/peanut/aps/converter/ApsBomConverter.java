package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsBom.*;
import com.olivia.peanut.aps.model.ApsBom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsBomConverter {

  ApsBomConverter INSTANCE = Mappers.getMapper(ApsBomConverter.class);

  ApsBom insertReq(ApsBomInsertReq req);

  ApsBom updateReq(ApsBomUpdateByIdReq req);

  List<ApsBomDto> queryListRes(List<ApsBom> list);

  List<ApsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsBom> list);

  List<ApsBom> importReq(List<ApsBomImportReq> reqList);
}

