package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserGoodsData;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastUserGoodsDataConverter {
  ApsGoodsForecastUserGoodsDataConverter INSTANCE = Mappers.getMapper(ApsGoodsForecastUserGoodsDataConverter.class);

  ApsGoodsForecastUserGoodsData insertReq(ApsGoodsForecastUserGoodsDataInsertReq req);

  ApsGoodsForecastUserGoodsData updateReq(ApsGoodsForecastUserGoodsDataUpdateByIdReq req);

  List<ApsGoodsForecastUserGoodsDataDto> queryListRes(List<ApsGoodsForecastUserGoodsData> list);

  List<ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsForecastUserGoodsData> list);

  List<ApsGoodsForecastUserGoodsData> importReq(List<ApsGoodsForecastUserGoodsDataImportReq> reqList);
}

