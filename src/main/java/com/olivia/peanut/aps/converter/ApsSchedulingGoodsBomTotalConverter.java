package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.*;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsBomTotal;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingGoodsBomTotalConverter {
  ApsSchedulingGoodsBomTotalConverter INSTANCE = Mappers.getMapper(ApsSchedulingGoodsBomTotalConverter.class);

  ApsSchedulingGoodsBomTotal insertReq(ApsSchedulingGoodsBomTotalInsertReq req);

  ApsSchedulingGoodsBomTotal updateReq(ApsSchedulingGoodsBomTotalUpdateByIdReq req);

  List<ApsSchedulingGoodsBomTotalDto> queryListRes(List<ApsSchedulingGoodsBomTotal> list);

  List<ApsSchedulingGoodsBomTotalExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingGoodsBomTotal> list);

  List<ApsSchedulingGoodsBomTotal> importReq(List<ApsSchedulingGoodsBomTotalImportReq> reqList);
}

