package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleConfig.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsSaleConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsSaleConfigConverter {
  ApsOrderGoodsSaleConfigConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsSaleConfigConverter.class);

  ApsOrderGoodsSaleConfig insertReq(ApsOrderGoodsSaleConfigInsertReq req);

  ApsOrderGoodsSaleConfig updateReq(ApsOrderGoodsSaleConfigUpdateByIdReq req);

  List<ApsOrderGoodsSaleConfigDto> queryListRes(List<ApsOrderGoodsSaleConfig> list);

  List<ApsOrderGoodsSaleConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsSaleConfig> list);

  List<ApsOrderGoodsSaleConfig> importReq(List<ApsOrderGoodsSaleConfigImportReq> reqList);
}

