package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.*;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsBom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingGoodsBomConverter {
  ApsSchedulingGoodsBomConverter INSTANCE = Mappers.getMapper(ApsSchedulingGoodsBomConverter.class);

  ApsSchedulingGoodsBom insertReq(ApsSchedulingGoodsBomInsertReq req);

  ApsSchedulingGoodsBom updateReq(ApsSchedulingGoodsBomUpdateByIdReq req);

  List<ApsSchedulingGoodsBomDto> queryListRes(List<ApsSchedulingGoodsBom> list);

  List<ApsSchedulingGoodsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingGoodsBom> list);

  List<ApsSchedulingGoodsBom> importReq(List<ApsSchedulingGoodsBomImportReq> reqList);
}

