package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigImportReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsOrderGoodsProjectConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsProjectConfigConverter {

  ApsOrderGoodsProjectConfigConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsProjectConfigConverter.class);

  ApsOrderGoodsProjectConfig insertReq(ApsOrderGoodsProjectConfigInsertReq req);

  ApsOrderGoodsProjectConfig updateReq(ApsOrderGoodsProjectConfigUpdateByIdReq req);

  List<ApsOrderGoodsProjectConfigDto> queryListRes(List<ApsOrderGoodsProjectConfig> list);

  List<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsProjectConfig> list);

  List<ApsOrderGoodsProjectConfig> importReq(List<ApsOrderGoodsProjectConfigImportReq> reqList);
}

