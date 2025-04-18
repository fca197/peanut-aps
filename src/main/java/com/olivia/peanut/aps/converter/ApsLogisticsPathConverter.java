package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsLogisticsPath.*;
import com.olivia.peanut.aps.model.ApsLogisticsPath;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsLogisticsPathConverter {
  ApsLogisticsPathConverter INSTANCE = Mappers.getMapper(ApsLogisticsPathConverter.class);

  ApsLogisticsPath insertReq(ApsLogisticsPathInsertReq req);

  ApsLogisticsPath updateReq(ApsLogisticsPathUpdateByIdReq req);

  List<ApsLogisticsPathDto> queryListRes(List<ApsLogisticsPath> list);

  List<ApsLogisticsPathExportQueryPageListInfoRes> queryPageListRes(List<ApsLogisticsPath> list);

  List<ApsLogisticsPath> importReq(List<ApsLogisticsPathImportReq> reqList);
}

