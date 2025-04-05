package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoods.*;
import com.olivia.peanut.aps.model.ApsOrderGoods;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsConverter {
  ApsOrderGoodsConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsConverter.class);

  ApsOrderGoods insertReq(ApsOrderGoodsInsertReq req);

  ApsOrderGoods updateReq(ApsOrderGoodsUpdateByIdReq req);

  List<ApsOrderGoodsDto> queryListRes(List<ApsOrderGoods> list);

  List<ApsOrderGoodsExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoods> list);

  List<ApsOrderGoods> importReq(List<ApsOrderGoodsImportReq> reqList);
}

