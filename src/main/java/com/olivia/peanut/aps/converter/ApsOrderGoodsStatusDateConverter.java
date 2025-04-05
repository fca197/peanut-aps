package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsStatusDate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsStatusDateConverter {
  ApsOrderGoodsStatusDateConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsStatusDateConverter.class);

  ApsOrderGoodsStatusDate insertReq(ApsOrderGoodsStatusDateInsertReq req);

  ApsOrderGoodsStatusDate updateReq(ApsOrderGoodsStatusDateUpdateByIdReq req);

  List<ApsOrderGoodsStatusDateDto> queryListRes(List<ApsOrderGoodsStatusDate> list);

  List<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsStatusDate> list);

  List<ApsOrderGoodsStatusDate> importReq(List<ApsOrderGoodsStatusDateImportReq> reqList);
}

