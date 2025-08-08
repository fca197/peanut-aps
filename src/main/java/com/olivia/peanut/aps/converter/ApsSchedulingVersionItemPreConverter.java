package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionItemPreConverter {

  ApsSchedulingVersionItemPreConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingVersionItemPreConverter.class);

  ApsSchedulingVersionItemPre insertReq(ApsSchedulingVersionItemPreInsertReq req);

  ApsSchedulingVersionItemPre updateReq(ApsSchedulingVersionItemPreUpdateByIdReq req);

  List<ApsSchedulingVersionItemPreDto> queryListRes(List<ApsSchedulingVersionItemPre> list);

  List<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersionItemPre> list);

  List<ApsSchedulingVersionItemPre> importReq(List<ApsSchedulingVersionItemPreImportReq> reqList);
}

