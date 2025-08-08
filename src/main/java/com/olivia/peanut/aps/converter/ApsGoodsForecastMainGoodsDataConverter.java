package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsForecastMainGoodsData.*;
import com.olivia.peanut.aps.model.ApsGoodsForecastMainGoodsData;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsForecastMainGoodsDataConverter {

  ApsGoodsForecastMainGoodsDataConverter INSTANCE = Mappers.getMapper(
      ApsGoodsForecastMainGoodsDataConverter.class);

  ApsGoodsForecastMainGoodsData insertReq(ApsGoodsForecastMainGoodsDataInsertReq req);

  ApsGoodsForecastMainGoodsData updateReq(ApsGoodsForecastMainGoodsDataUpdateByIdReq req);

  List<ApsGoodsForecastMainGoodsDataDto> queryListRes(List<ApsGoodsForecastMainGoodsData> list);

  List<ApsGoodsForecastMainGoodsDataExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsForecastMainGoodsData> list);

  List<ApsGoodsForecastMainGoodsData> importReq(
      List<ApsGoodsForecastMainGoodsDataImportReq> reqList);
}

