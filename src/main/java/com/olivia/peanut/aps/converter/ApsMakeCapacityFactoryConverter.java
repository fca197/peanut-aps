package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.*;
import com.olivia.peanut.aps.model.ApsMakeCapacityFactory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMakeCapacityFactoryConverter {
  ApsMakeCapacityFactoryConverter INSTANCE = Mappers.getMapper(ApsMakeCapacityFactoryConverter.class);

  ApsMakeCapacityFactory insertReq(ApsMakeCapacityFactoryInsertReq req);

  ApsMakeCapacityFactory updateReq(ApsMakeCapacityFactoryUpdateByIdReq req);

  List<ApsMakeCapacityFactoryDto> queryListRes(List<ApsMakeCapacityFactory> list);

  List<ApsMakeCapacityFactoryExportQueryPageListInfoRes> queryPageListRes(List<ApsMakeCapacityFactory> list);

  List<ApsMakeCapacityFactory> importReq(List<ApsMakeCapacityFactoryImportReq> reqList);
}

