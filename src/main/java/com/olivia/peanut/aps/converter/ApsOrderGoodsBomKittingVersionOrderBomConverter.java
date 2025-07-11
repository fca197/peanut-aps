package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderBom;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingVersionOrderBomConverter {

  ApsOrderGoodsBomKittingVersionOrderBomConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsBomKittingVersionOrderBomConverter.class);

  ApsOrderGoodsBomKittingVersionOrderBom insertReq(
      ApsOrderGoodsBomKittingVersionOrderBomInsertReq req);

  ApsOrderGoodsBomKittingVersionOrderBom updateReq(
      ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingVersionOrderBomDto> queryListRes(
      List<ApsOrderGoodsBomKittingVersionOrderBom> list);

  List<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsBomKittingVersionOrderBom> list);

  List<ApsOrderGoodsBomKittingVersionOrderBom> importReq(
      List<ApsOrderGoodsBomKittingVersionOrderBomImportReq> reqList);
}

