package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMakeProjectData;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeProjectDataConverter {
  ApsGoodsForecastMakeProjectDataConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMakeProjectDataConverter.class);

  ApsGoodsForecastMakeProjectData insertReq(ApsGoodsForecastMakeProjectDataInsertReq req);

  ApsGoodsForecastMakeProjectData updateReq(ApsGoodsForecastMakeProjectDataUpdateByIdReq req);

  List<ApsGoodsForecastMakeProjectDataDto> queryListRes(List<ApsGoodsForecastMakeProjectData> list);

  List<ApsGoodsForecastMakeProjectDataExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastMakeProjectData> list);

  List<ApsGoodsForecastMakeProjectData> importReq(List<ApsGoodsForecastMakeProjectDataImportReq> reqList);
}

