package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.ApsMakeCapacityFactoryDto;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.ApsMakeCapacityFactoryExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.ApsMakeCapacityFactoryImportReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.ApsMakeCapacityFactoryInsertReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityFactory.ApsMakeCapacityFactoryUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsMakeCapacityFactory;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMakeCapacityFactoryConverter {

  ApsMakeCapacityFactoryConverter INSTANCE = Mappers.getMapper(
      ApsMakeCapacityFactoryConverter.class);

  ApsMakeCapacityFactory insertReq(ApsMakeCapacityFactoryInsertReq req);

  ApsMakeCapacityFactory updateReq(ApsMakeCapacityFactoryUpdateByIdReq req);

  List<ApsMakeCapacityFactoryDto> queryListRes(List<ApsMakeCapacityFactory> list);

  List<ApsMakeCapacityFactoryExportQueryPageListInfoRes> queryPageListRes(
      List<ApsMakeCapacityFactory> list);

  List<ApsMakeCapacityFactory> importReq(List<ApsMakeCapacityFactoryImportReq> reqList);
}

