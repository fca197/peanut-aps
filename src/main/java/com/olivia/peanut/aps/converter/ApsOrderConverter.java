package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrder.*;
import com.olivia.peanut.aps.model.ApsOrder;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderConverter {
  ApsOrderConverter INSTANCE = Mappers.getMapper(ApsOrderConverter.class);

  ApsOrder insertReq(ApsOrderInsertReq req);

  ApsOrder updateReq(ApsOrderUpdateByIdReq req);

  List<ApsOrderDto> queryListRes(List<ApsOrder> list);

  List<ApsOrderExportQueryPageListInfoRes> queryPageListRes(List<ApsOrder> list);

  List<ApsOrder> importReq(List<ApsOrderImportReq> reqList);
}

