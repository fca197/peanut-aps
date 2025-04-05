package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProjectConfig.*;
import com.olivia.peanut.aps.model.ApsProjectConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProjectConfigConverter {
  ApsProjectConfigConverter INSTANCE = Mappers.getMapper(ApsProjectConfigConverter.class);

  ApsProjectConfig insertReq(ApsProjectConfigInsertReq req);

  ApsProjectConfig updateReq(ApsProjectConfigUpdateByIdReq req);

  List<ApsProjectConfigDto> queryListRes(List<ApsProjectConfig> list);

  List<ApsProjectConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsProjectConfig> list);

  List<ApsProjectConfig> importReq(List<ApsProjectConfigImportReq> reqList);
}

