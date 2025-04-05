package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionItemConverter {
  ApsSchedulingVersionItemConverter INSTANCE = Mappers.getMapper(ApsSchedulingVersionItemConverter.class);

  ApsSchedulingVersionItem insertReq(ApsSchedulingVersionItemInsertReq req);

  ApsSchedulingVersionItem updateReq(ApsSchedulingVersionItemUpdateByIdReq req);

  List<ApsSchedulingVersionItemDto> queryListRes(List<ApsSchedulingVersionItem> list);

  List<ApsSchedulingVersionItemExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingVersionItem> list);

  List<ApsSchedulingVersionItem> importReq(List<ApsSchedulingVersionItemImportReq> reqList);
}

