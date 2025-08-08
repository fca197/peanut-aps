package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

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

