package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigItem.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigItemConverter {

  ApsSchedulingDayConfigItemConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigItemConverter.class);

  ApsSchedulingDayConfigItem insertReq(ApsSchedulingDayConfigItemInsertReq req);

  ApsSchedulingDayConfigItem updateReq(ApsSchedulingDayConfigItemUpdateByIdReq req);

  List<ApsSchedulingDayConfigItemDto> queryListRes(List<ApsSchedulingDayConfigItem> list);

  List<ApsSchedulingDayConfigItemExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigItem> list);

  List<ApsSchedulingDayConfigItem> importReq(List<ApsSchedulingDayConfigItemImportReq> reqList);
}

