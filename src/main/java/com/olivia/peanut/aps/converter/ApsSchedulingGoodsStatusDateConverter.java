package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.ApsSchedulingGoodsStatusDateDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.ApsSchedulingGoodsStatusDateExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.ApsSchedulingGoodsStatusDateImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.ApsSchedulingGoodsStatusDateInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsStatusDate.ApsSchedulingGoodsStatusDateUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsStatusDate;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingGoodsStatusDateConverter {

  ApsSchedulingGoodsStatusDateConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingGoodsStatusDateConverter.class);

  ApsSchedulingGoodsStatusDate insertReq(ApsSchedulingGoodsStatusDateInsertReq req);

  ApsSchedulingGoodsStatusDate updateReq(ApsSchedulingGoodsStatusDateUpdateByIdReq req);

  List<ApsSchedulingGoodsStatusDateDto> queryListRes(List<ApsSchedulingGoodsStatusDate> list);

  List<ApsSchedulingGoodsStatusDateExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingGoodsStatusDate> list);

  List<ApsSchedulingGoodsStatusDate> importReq(List<ApsSchedulingGoodsStatusDateImportReq> reqList);
}

