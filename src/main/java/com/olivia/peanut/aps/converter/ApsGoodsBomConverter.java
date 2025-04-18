package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBom.*;
import com.olivia.peanut.aps.model.ApsGoodsBom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomConverter {
  ApsGoodsBomConverter INSTANCE = Mappers.getMapper(ApsGoodsBomConverter.class);

  ApsGoodsBom insertReq(ApsGoodsBomInsertReq req);

  ApsGoodsBom updateReq(ApsGoodsBomUpdateByIdReq req);

  List<ApsGoodsBomDto> queryListRes(List<ApsGoodsBom> list);

  List<ApsGoodsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsBom> list);

  List<ApsGoodsBom> importReq(List<ApsGoodsBomImportReq> reqList);
}

