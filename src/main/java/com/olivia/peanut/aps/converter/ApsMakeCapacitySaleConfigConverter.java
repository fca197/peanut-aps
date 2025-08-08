package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMakeCapacitySaleConfig.*;
import com.olivia.peanut.aps.model.ApsMakeCapacitySaleConfig;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMakeCapacitySaleConfigConverter {

  ApsMakeCapacitySaleConfigConverter INSTANCE = Mappers.getMapper(
      ApsMakeCapacitySaleConfigConverter.class);

  ApsMakeCapacitySaleConfig insertReq(ApsMakeCapacitySaleConfigInsertReq req);

  ApsMakeCapacitySaleConfig updateReq(ApsMakeCapacitySaleConfigUpdateByIdReq req);

  List<ApsMakeCapacitySaleConfigDto> queryListRes(List<ApsMakeCapacitySaleConfig> list);

  List<ApsMakeCapacitySaleConfigExportQueryPageListInfoRes> queryPageListRes(
      List<ApsMakeCapacitySaleConfig> list);

  List<ApsMakeCapacitySaleConfig> importReq(List<ApsMakeCapacitySaleConfigImportReq> reqList);
}

