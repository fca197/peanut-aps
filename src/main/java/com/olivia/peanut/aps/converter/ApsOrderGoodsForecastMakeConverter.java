package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.ApsOrderGoodsForecastMakeDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.ApsOrderGoodsForecastMakeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.ApsOrderGoodsForecastMakeImportReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.ApsOrderGoodsForecastMakeInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsForecastMake.ApsOrderGoodsForecastMakeUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsOrderGoodsForecastMake;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsForecastMakeConverter {

  ApsOrderGoodsForecastMakeConverter INSTANCE = Mappers.getMapper(
      ApsOrderGoodsForecastMakeConverter.class);

  ApsOrderGoodsForecastMake insertReq(ApsOrderGoodsForecastMakeInsertReq req);

  ApsOrderGoodsForecastMake updateReq(ApsOrderGoodsForecastMakeUpdateByIdReq req);

  List<ApsOrderGoodsForecastMakeDto> queryListRes(List<ApsOrderGoodsForecastMake> list);

  List<ApsOrderGoodsForecastMakeExportQueryPageListInfoRes> queryPageListRes(
      List<ApsOrderGoodsForecastMake> list);

  List<ApsOrderGoodsForecastMake> importReq(List<ApsOrderGoodsForecastMakeImportReq> reqList);
}

