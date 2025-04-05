package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsProduceProcess.*;
import com.olivia.peanut.aps.model.ApsProduceProcess;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsProduceProcessConverter {
  ApsProduceProcessConverter INSTANCE = Mappers.getMapper(ApsProduceProcessConverter.class);

  ApsProduceProcess insertReq(ApsProduceProcessInsertReq req);

  ApsProduceProcess updateReq(ApsProduceProcessUpdateByIdReq req);

  List<ApsProduceProcessDto> queryListRes(List<ApsProduceProcess> list);

  List<ApsProduceProcessExportQueryPageListInfoRes> queryPageListRes(List<ApsProduceProcess> list);

  List<ApsProduceProcess> importReq(List<ApsProduceProcessImportReq> reqList);
}

