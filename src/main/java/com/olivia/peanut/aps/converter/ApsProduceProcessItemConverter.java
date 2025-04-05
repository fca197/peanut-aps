package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.*;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProduceProcessItemConverter {
  ApsProduceProcessItemConverter INSTANCE = Mappers.getMapper(ApsProduceProcessItemConverter.class);

  ApsProduceProcessItem insertReq(ApsProduceProcessItemInsertReq req);

  ApsProduceProcessItem updateReq(ApsProduceProcessItemUpdateByIdReq req);

  List<ApsProduceProcessItemDto> queryListRes(List<ApsProduceProcessItem> list);

  List<ApsProduceProcessItemExportQueryPageListInfoRes> queryPageListRes(List<ApsProduceProcessItem> list);

  List<ApsProduceProcessItem> importReq(List<ApsProduceProcessItemImportReq> reqList);
}

