package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsProjectConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsProjectConfigConverter {
  ApsOrderGoodsProjectConfigConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsProjectConfigConverter.class);

  ApsOrderGoodsProjectConfig insertReq(ApsOrderGoodsProjectConfigInsertReq req);

  ApsOrderGoodsProjectConfig updateReq(ApsOrderGoodsProjectConfigUpdateByIdReq req);

  List<ApsOrderGoodsProjectConfigDto> queryListRes(List<ApsOrderGoodsProjectConfig> list);

  List<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsProjectConfig> list);

  List<ApsOrderGoodsProjectConfig> importReq(List<ApsOrderGoodsProjectConfigImportReq> reqList);
}

