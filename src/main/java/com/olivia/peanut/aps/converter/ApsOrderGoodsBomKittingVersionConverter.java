package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingVersionConverter {

  ApsOrderGoodsBomKittingVersionConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsBomKittingVersionConverter.class);

  ApsOrderGoodsBomKittingVersion insertReq(ApsOrderGoodsBomKittingVersionInsertReq req);

  ApsOrderGoodsBomKittingVersion updateReq(ApsOrderGoodsBomKittingVersionUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingVersionDto> queryListRes(List<ApsOrderGoodsBomKittingVersion> list);

  List<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsBomKittingVersion> list);

  List<ApsOrderGoodsBomKittingVersion> importReq(
      List<ApsOrderGoodsBomKittingVersionImportReq> reqList);
}

