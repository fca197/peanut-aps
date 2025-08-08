package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsStatusDate;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsStatusDateConverter {

  ApsOrderGoodsStatusDateConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsStatusDateConverter.class);

  ApsOrderGoodsStatusDate insertReq(ApsOrderGoodsStatusDateInsertReq req);

  ApsOrderGoodsStatusDate updateReq(ApsOrderGoodsStatusDateUpdateByIdReq req);

  List<ApsOrderGoodsStatusDateDto> queryListRes(List<ApsOrderGoodsStatusDate> list);

  List<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsStatusDate> list);

  List<ApsOrderGoodsStatusDate> importReq(List<ApsOrderGoodsStatusDateImportReq> reqList);
}

