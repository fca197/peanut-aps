package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.*;
import com.olivia.peanut.aps.model.ApsGoodsSaleProjectConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsSaleProjectConfigConverter {
  ApsGoodsSaleProjectConfigConverter INSTANCE = Mappers.getMapper(ApsGoodsSaleProjectConfigConverter.class);

  ApsGoodsSaleProjectConfig insertReq(ApsGoodsSaleProjectConfigInsertReq req);

  ApsGoodsSaleProjectConfig updateReq(ApsGoodsSaleProjectConfigUpdateByIdReq req);

  List<ApsGoodsSaleProjectConfigDto> queryListRes(List<ApsGoodsSaleProjectConfig> list);

  List<ApsGoodsSaleProjectConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsSaleProjectConfig> list);

  List<ApsGoodsSaleProjectConfig> importReq(List<ApsGoodsSaleProjectConfigImportReq> reqList);
}

