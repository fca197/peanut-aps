package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainMake.ApsGoodsForecastMainMakeUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainMake;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainMakeConverter {

  ApsGoodsForecastMainMakeConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMainMakeConverter.class);

  ApsGoodsForecastMainMake insertReq(ApsGoodsForecastMainMakeInsertReq req);

  ApsGoodsForecastMainMake updateReq(ApsGoodsForecastMainMakeUpdateByIdReq req);

  List<ApsGoodsForecastMainMakeDto> queryListRes(List<ApsGoodsForecastMainMake> list);

  List<ApsGoodsForecastMainMakeExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMainMake> list);

  List<ApsGoodsForecastMainMake> importReq(List<ApsGoodsForecastMainMakeImportReq> reqList);
}

