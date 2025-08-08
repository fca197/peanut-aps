package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSaleConfig.*;
import com.olivia.peanut.aps.model.ApsSaleConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSaleConfigConverter {

  ApsSaleConfigConverter INSTANCE = Mappers.getMapper(ApsSaleConfigConverter.class);

  ApsSaleConfig insertReq(ApsSaleConfigInsertReq req);

  ApsSaleConfig updateReq(ApsSaleConfigUpdateByIdReq req);

  List<ApsSaleConfigDto> queryListRes(List<ApsSaleConfig> list);

  List<ApsSaleConfigExportQueryPageListInfoRes> queryPageListRes(List<ApsSaleConfig> list);

  List<ApsSaleConfig> importReq(List<ApsSaleConfigImportReq> reqList);
}

