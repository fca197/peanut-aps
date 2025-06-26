package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingTemplateConverter {

  ApsOrderGoodsBomKittingTemplateConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsBomKittingTemplateConverter.class);

  ApsOrderGoodsBomKittingTemplate insertReq(ApsOrderGoodsBomKittingTemplateInsertReq req);

  ApsOrderGoodsBomKittingTemplate updateReq(ApsOrderGoodsBomKittingTemplateUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingTemplateDto> queryListRes(List<ApsOrderGoodsBomKittingTemplate> list);

  List<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsBomKittingTemplate> list);

  List<ApsOrderGoodsBomKittingTemplate> importReq(
      List<ApsOrderGoodsBomKittingTemplateImportReq> reqList);
}

