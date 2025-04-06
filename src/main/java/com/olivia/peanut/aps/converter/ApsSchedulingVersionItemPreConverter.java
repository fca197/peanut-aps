package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionItemPreConverter {
  ApsSchedulingVersionItemPreConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionItemPreConverter.class);

  ApsSchedulingVersionItemPre insertReq(ApsSchedulingVersionItemPreInsertReq req);

  ApsSchedulingVersionItemPre updateReq(ApsSchedulingVersionItemPreUpdateByIdReq req);

  List<ApsSchedulingVersionItemPreDto> queryListRes(List<ApsSchedulingVersionItemPre> list);

  List<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingVersionItemPre> list);

  List<ApsSchedulingVersionItemPre> importReq(List<ApsSchedulingVersionItemPreImportReq> reqList);
}

