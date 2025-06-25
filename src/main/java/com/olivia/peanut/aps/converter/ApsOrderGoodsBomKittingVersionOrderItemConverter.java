package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingVersionOrderItemConverter {

  ApsOrderGoodsBomKittingVersionOrderItemConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsBomKittingVersionOrderItemConverter.class);

  ApsOrderGoodsBomKittingVersionOrderItem insertReq(
      ApsOrderGoodsBomKittingVersionOrderItemInsertReq req);

  ApsOrderGoodsBomKittingVersionOrderItem updateReq(
      ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingVersionOrderItemDto> queryListRes(
      List<ApsOrderGoodsBomKittingVersionOrderItem> list);

  List<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsBomKittingVersionOrderItem> list);

  List<ApsOrderGoodsBomKittingVersionOrderItem> importReq(
      List<ApsOrderGoodsBomKittingVersionOrderItemImportReq> reqList);
}

