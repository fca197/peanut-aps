package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingTemplateConverter {

  ApsOrderGoodsBomKittingTemplateConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsBomKittingTemplateConverter.class);

  ApsOrderGoodsBomKittingTemplate insertReq(ApsOrderGoodsBomKittingTemplateInsertReq req);

  ApsOrderGoodsBomKittingTemplate updateReq(ApsOrderGoodsBomKittingTemplateUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingTemplateDto> queryListRes(List<ApsOrderGoodsBomKittingTemplate> list);

  List<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsBomKittingTemplate> list);

  List<ApsOrderGoodsBomKittingTemplate> importReq(List<ApsOrderGoodsBomKittingTemplateImportReq> reqList);
}

