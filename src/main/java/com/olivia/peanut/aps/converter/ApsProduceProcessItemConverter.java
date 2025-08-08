package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.*;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
import com.olivia.peanut.aps.utils.process.entity.ProduceOrderMachine;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProduceProcessItemConverter {

  ApsProduceProcessItemConverter INSTANCE = Mappers.getMapper(ApsProduceProcessItemConverter.class);

  ApsProduceProcessItem insertReq(ApsProduceProcessItemInsertReq req);

  ApsProduceProcessItem updateReq(ApsProduceProcessItemUpdateByIdReq req);

  List<ApsProduceProcessItemDto> queryListRes(List<ApsProduceProcessItem> list);

  List<ApsProduceProcessItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsProduceProcessItem> list);

  List<ApsProduceProcessItem> importReq(List<ApsProduceProcessItemImportReq> reqList);

  ProduceOrderMachine convertProduceOrderMachine(ApsProduceProcessItem req);
}

