package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
import com.olivia.peanut.aps.model.ApsOrderFieldShowTemplate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderFieldShowTemplateConverter {

  ApsOrderFieldShowTemplateConverter INSTANCE = Mappers.getMapper(
      ApsOrderFieldShowTemplateConverter.class);

  ApsOrderFieldShowTemplate insertReq(ApsOrderFieldShowTemplateInsertReq req);

  ApsOrderFieldShowTemplate updateReq(ApsOrderFieldShowTemplateUpdateByIdReq req);

  List<ApsOrderFieldShowTemplateDto> queryListRes(List<ApsOrderFieldShowTemplate> list);

  List<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderFieldShowTemplate> list);

  List<ApsOrderFieldShowTemplate> importReq(List<ApsOrderFieldShowTemplateImportReq> reqList);
}

