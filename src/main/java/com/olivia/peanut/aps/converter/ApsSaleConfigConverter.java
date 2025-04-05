package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSaleConfig.*;
import com.olivia.peanut.aps.model.ApsSaleConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSaleConfigConverter {
  ApsSaleConfigConverter INSTANCE = Mappers.getMapper(ApsSaleConfigConverter.class);

  ApsSaleConfig insertReq(ApsSaleConfigInsertReq req);

  ApsSaleConfig updateReq(ApsSaleConfigUpdateByIdReq req);

  List<ApsSaleConfigDto> queryListRes(List<ApsSaleConfig> list);

  List<ApsSaleConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsSaleConfig> list);

  List<ApsSaleConfig> importReq(List<ApsSaleConfigImportReq> reqList);
}

