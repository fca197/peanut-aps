package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.*;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsStatusDate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingGoodsStatusDateConverter {
  ApsSchedulingGoodsStatusDateConverter INSTANCE = Mappers.getMapper(ApsSchedulingGoodsStatusDateConverter.class);

  ApsSchedulingGoodsStatusDate insertReq(ApsSchedulingGoodsStatusDateInsertReq req);

  ApsSchedulingGoodsStatusDate updateReq(ApsSchedulingGoodsStatusDateUpdateByIdReq req);

  List<ApsSchedulingGoodsStatusDateDto> queryListRes(List<ApsSchedulingGoodsStatusDate> list);

  List<ApsSchedulingGoodsStatusDateExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingGoodsStatusDate> list);

  List<ApsSchedulingGoodsStatusDate> importReq(List<ApsSchedulingGoodsStatusDateImportReq> reqList);
}

