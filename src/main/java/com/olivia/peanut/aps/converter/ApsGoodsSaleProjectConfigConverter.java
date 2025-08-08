package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.*;
import com.olivia.peanut.aps.model.ApsGoodsSaleProjectConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsSaleProjectConfigConverter {

  ApsGoodsSaleProjectConfigConverter INSTANCE = Mappers.getMapper(ApsGoodsSaleProjectConfigConverter.class);

  ApsGoodsSaleProjectConfig insertReq(ApsGoodsSaleProjectConfigInsertReq req);

  ApsGoodsSaleProjectConfig updateReq(ApsGoodsSaleProjectConfigUpdateByIdReq req);

  List<ApsGoodsSaleProjectConfigDto> queryListRes(List<ApsGoodsSaleProjectConfig> list);

  List<ApsGoodsSaleProjectConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsSaleProjectConfig> list);

  List<ApsGoodsSaleProjectConfig> importReq(List<ApsGoodsSaleProjectConfigImportReq> reqList);
}

