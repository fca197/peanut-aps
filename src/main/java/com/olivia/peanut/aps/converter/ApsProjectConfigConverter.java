package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigDto;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigImportReq;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsProjectConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProjectConfigConverter {

  ApsProjectConfigConverter INSTANCE = Mappers.getMapper(ApsProjectConfigConverter.class);

  ApsProjectConfig insertReq(ApsProjectConfigInsertReq req);

  ApsProjectConfig updateReq(ApsProjectConfigUpdateByIdReq req);

  List<ApsProjectConfigDto> queryListRes(List<ApsProjectConfig> list);

  List<ApsProjectConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsProjectConfig> list);

  List<ApsProjectConfig> importReq(List<ApsProjectConfigImportReq> reqList);
}

