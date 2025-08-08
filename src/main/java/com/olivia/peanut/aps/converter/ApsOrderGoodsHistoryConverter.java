package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.*;
import com.olivia.peanut.aps.model.ApsOrderGoodsHistory;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderGoodsHistoryConverter {

  ApsOrderGoodsHistoryConverter INSTANCE = Mappers.getMapper(ApsOrderGoodsHistoryConverter.class);

  ApsOrderGoodsHistory insertReq(ApsOrderGoodsHistoryInsertReq req);

  ApsOrderGoodsHistory updateReq(ApsOrderGoodsHistoryUpdateByIdReq req);

  List<ApsOrderGoodsHistoryDto> queryListRes(List<ApsOrderGoodsHistory> list);

  List<ApsOrderGoodsHistoryExportQueryPageListInfoRes> queryPageListRes(List<ApsOrderGoodsHistory> list);

  List<ApsOrderGoodsHistory> importReq(List<ApsOrderGoodsHistoryImportReq> reqList);
}

