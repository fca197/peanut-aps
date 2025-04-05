package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoods.*;
import com.olivia.peanut.aps.model.ApsGoods;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsConverter {
  ApsGoodsConverter INSTANCE = Mappers.getMapper(ApsGoodsConverter.class);

  ApsGoods insertReq(ApsGoodsInsertReq req);

  ApsGoods updateReq(ApsGoodsUpdateByIdReq req);

  List<ApsGoodsDto> queryListRes(List<ApsGoods> list);

  List<ApsGoodsExportQueryPageListInfoRes> queryPageListRes(List<ApsGoods> list);

  List<ApsGoods> importReq(List<ApsGoodsImportReq> reqList);
}

