package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBom.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomConverter {

  ApsOrderGoodsBomConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsBomConverter.class);

  ApsOrderGoodsBom insertReq(ApsOrderGoodsBomInsertReq req);

  ApsOrderGoodsBom updateReq(ApsOrderGoodsBomUpdateByIdReq req);

  List<ApsOrderGoodsBomDto> queryListRes(List<ApsOrderGoodsBom> list);

  List<ApsOrderGoodsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsBom> list);

  List<ApsOrderGoodsBom> importReq(List<ApsOrderGoodsBomImportReq> reqList);
}

