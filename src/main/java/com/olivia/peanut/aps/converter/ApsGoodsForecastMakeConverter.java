package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMake.ApsGoodsForecastMakeUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastMake;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMakeConverter {

  ApsGoodsForecastMakeConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastMakeConverter.class);

  ApsGoodsForecastMake insertReq(ApsGoodsForecastMakeInsertReq req);

  ApsGoodsForecastMake updateReq(ApsGoodsForecastMakeUpdateByIdReq req);

  List<ApsGoodsForecastMakeDto> queryListRes(List<ApsGoodsForecastMake> list);

  List<ApsGoodsForecastMakeExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMake> list);

  List<ApsGoodsForecastMake> importReq(List<ApsGoodsForecastMakeImportReq> reqList);
}

