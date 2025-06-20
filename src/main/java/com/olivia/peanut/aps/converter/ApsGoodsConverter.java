package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoods.ApsGoodsDto;
import com.olivia.peanut.aps.api.entity.apsGoods.ApsGoodsExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoods.ApsGoodsImportReq;
import com.olivia.peanut.aps.api.entity.apsGoods.ApsGoodsInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoods.ApsGoodsUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoods;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsConverter {

  ApsGoodsConverter INSTANCE = Mappers.getMapper(ApsGoodsConverter.class);

  ApsGoods insertReq(ApsGoodsInsertReq req);

  ApsGoods updateReq(ApsGoodsUpdateByIdReq req);

  List<ApsGoodsDto> queryListRes(List<ApsGoods> list);

  List<ApsGoodsExportQueryPageListInfoRes> queryPageListRes(List<ApsGoods> list);

  List<ApsGoods> importReq(List<ApsGoodsImportReq> reqList);
}

