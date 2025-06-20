package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.ApsSchedulingGoodsBomDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.ApsSchedulingGoodsBomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.ApsSchedulingGoodsBomImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.ApsSchedulingGoodsBomInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBom.ApsSchedulingGoodsBomUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsBom;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingGoodsBomConverter {

  ApsSchedulingGoodsBomConverter INSTANCE = Mappers.getMapper(ApsSchedulingGoodsBomConverter.class);

  ApsSchedulingGoodsBom insertReq(ApsSchedulingGoodsBomInsertReq req);

  ApsSchedulingGoodsBom updateReq(ApsSchedulingGoodsBomUpdateByIdReq req);

  List<ApsSchedulingGoodsBomDto> queryListRes(List<ApsSchedulingGoodsBom> list);

  List<ApsSchedulingGoodsBomExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingGoodsBom> list);

  List<ApsSchedulingGoodsBom> importReq(List<ApsSchedulingGoodsBomImportReq> reqList);
}

