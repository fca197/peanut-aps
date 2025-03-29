package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBom.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomConverter {
  ApsOrderGoodsBomConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsBomConverter.class);

  ApsOrderGoodsBom insertReq(ApsOrderGoodsBomInsertReq req);

  ApsOrderGoodsBom updateReq(ApsOrderGoodsBomUpdateByIdReq req);

  List<ApsOrderGoodsBomDto> queryListRes(List<ApsOrderGoodsBom> list);

  List<ApsOrderGoodsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsBom> list);

  List<ApsOrderGoodsBom> importReq(List<ApsOrderGoodsBomImportReq> reqList);
}

