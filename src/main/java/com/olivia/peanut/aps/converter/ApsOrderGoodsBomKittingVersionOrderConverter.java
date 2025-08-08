package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrder;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsBomKittingVersionOrderConverter {

  ApsOrderGoodsBomKittingVersionOrderConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsBomKittingVersionOrderConverter.class);

  ApsOrderGoodsBomKittingVersionOrder insertReq(ApsOrderGoodsBomKittingVersionOrderInsertReq req);

  ApsOrderGoodsBomKittingVersionOrder updateReq(ApsOrderGoodsBomKittingVersionOrderUpdateByIdReq req);

  List<ApsOrderGoodsBomKittingVersionOrderDto> queryListRes(List<ApsOrderGoodsBomKittingVersionOrder> list);

  List<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsBomKittingVersionOrder> list);

  List<ApsOrderGoodsBomKittingVersionOrder> importReq(List<ApsOrderGoodsBomKittingVersionOrderImportReq> reqList);
}

