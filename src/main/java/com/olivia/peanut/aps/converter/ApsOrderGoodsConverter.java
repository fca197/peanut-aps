package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoods.*;
import com.olivia.peanut.aps.model.ApsOrderGoods;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsConverter {

  ApsOrderGoodsConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsConverter.class);

  ApsOrderGoods insertReq(ApsOrderGoodsInsertReq req);

  ApsOrderGoods updateReq(ApsOrderGoodsUpdateByIdReq req);

  List<ApsOrderGoodsDto> queryListRes(List<ApsOrderGoods> list);

  List<ApsOrderGoodsExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoods> list);

  List<ApsOrderGoods> importReq(List<ApsOrderGoodsImportReq> reqList);
}

