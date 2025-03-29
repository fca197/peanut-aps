package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigItem.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigItemConverter {
  ApsSchedulingDayConfigItemConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigItemConverter.class);

  ApsSchedulingDayConfigItem insertReq(ApsSchedulingDayConfigItemInsertReq req);

  ApsSchedulingDayConfigItem updateReq(ApsSchedulingDayConfigItemUpdateByIdReq req);

  List<ApsSchedulingDayConfigItemDto> queryListRes(List<ApsSchedulingDayConfigItem> list);

  List<ApsSchedulingDayConfigItemExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigItem> list);

  List<ApsSchedulingDayConfigItem> importReq(List<ApsSchedulingDayConfigItemImportReq> reqList);
}

