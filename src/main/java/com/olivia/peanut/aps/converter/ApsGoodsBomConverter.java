package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomDto;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsBom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomConverter {

  ApsGoodsBomConverter INSTANCE = Mappers.getMapper(ApsGoodsBomConverter.class);

  ApsGoodsBom insertReq(ApsGoodsBomInsertReq req);

  ApsGoodsBom updateReq(ApsGoodsBomUpdateByIdReq req);

  List<ApsGoodsBomDto> queryListRes(List<ApsGoodsBom> list);

  List<ApsGoodsBomExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsBom> list);

  List<ApsGoodsBom> importReq(List<ApsGoodsBomImportReq> reqList);
}

