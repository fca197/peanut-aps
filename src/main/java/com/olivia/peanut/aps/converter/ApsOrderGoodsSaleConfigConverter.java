package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleConfig.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsSaleConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsSaleConfigConverter {

  ApsOrderGoodsSaleConfigConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsSaleConfigConverter.class);

  ApsOrderGoodsSaleConfig insertReq(ApsOrderGoodsSaleConfigInsertReq req);

  ApsOrderGoodsSaleConfig updateReq(ApsOrderGoodsSaleConfigUpdateByIdReq req);

  List<ApsOrderGoodsSaleConfigDto> queryListRes(List<ApsOrderGoodsSaleConfig> list);

  List<ApsOrderGoodsSaleConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsSaleConfig> list);

  List<ApsOrderGoodsSaleConfig> importReq(List<ApsOrderGoodsSaleConfigImportReq> reqList);
}

