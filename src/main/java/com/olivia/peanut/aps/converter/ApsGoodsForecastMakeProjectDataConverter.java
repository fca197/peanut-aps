package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.ApsGoodsForecastMakeProjectDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.ApsGoodsForecastMakeProjectDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.ApsGoodsForecastMakeProjectDataImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.ApsGoodsForecastMakeProjectDataInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeProjectData.ApsGoodsForecastMakeProjectDataUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastMakeProjectData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeProjectDataConverter {

  ApsGoodsForecastMakeProjectDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMakeProjectDataConverter.class);

  ApsGoodsForecastMakeProjectData insertReq(ApsGoodsForecastMakeProjectDataInsertReq req);

  ApsGoodsForecastMakeProjectData updateReq(ApsGoodsForecastMakeProjectDataUpdateByIdReq req);

  List<ApsGoodsForecastMakeProjectDataDto> queryListRes(List<ApsGoodsForecastMakeProjectData> list);

  List<ApsGoodsForecastMakeProjectDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMakeProjectData> list);

  List<ApsGoodsForecastMakeProjectData> importReq(
      List<ApsGoodsForecastMakeProjectDataImportReq> reqList);
}

