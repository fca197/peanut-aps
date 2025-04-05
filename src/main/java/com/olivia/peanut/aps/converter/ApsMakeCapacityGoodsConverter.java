package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.*;
import com.olivia.peanut.aps.model.ApsMakeCapacityGoods;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMakeCapacityGoodsConverter {
  ApsMakeCapacityGoodsConverter INSTANCE = Mappers.getMapper(ApsMakeCapacityGoodsConverter.class);

  ApsMakeCapacityGoods insertReq(ApsMakeCapacityGoodsInsertReq req);

  ApsMakeCapacityGoods updateReq(ApsMakeCapacityGoodsUpdateByIdReq req);

  List<ApsMakeCapacityGoodsDto> queryListRes(List<ApsMakeCapacityGoods> list);

  List<ApsMakeCapacityGoodsExportQueryPageListInfoRes> queryPageListRes(List<ApsMakeCapacityGoods> list);

  List<ApsMakeCapacityGoods> importReq(List<ApsMakeCapacityGoodsImportReq> reqList);
}

