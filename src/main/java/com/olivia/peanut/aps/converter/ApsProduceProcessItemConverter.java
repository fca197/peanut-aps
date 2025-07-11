package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.ApsProduceProcessItemDto;
import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.ApsProduceProcessItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.ApsProduceProcessItemImportReq;
import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.ApsProduceProcessItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsProduceProcessItem.ApsProduceProcessItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
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
}

