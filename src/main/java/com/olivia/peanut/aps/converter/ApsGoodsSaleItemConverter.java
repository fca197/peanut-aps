package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsSaleItem.ApsGoodsSaleItemDto;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleItem.ApsGoodsSaleItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleItem.ApsGoodsSaleItemImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleItem.ApsGoodsSaleItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleItem.ApsGoodsSaleItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsSaleItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsSaleItemConverter {

  ApsGoodsSaleItemConverter INSTANCE = Mappers.getMapper(ApsGoodsSaleItemConverter.class);

  ApsGoodsSaleItem insertReq(ApsGoodsSaleItemInsertReq req);

  ApsGoodsSaleItem updateReq(ApsGoodsSaleItemUpdateByIdReq req);

  List<ApsGoodsSaleItemDto> queryListRes(List<ApsGoodsSaleItem> list);

  List<ApsGoodsSaleItemExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsSaleItem> list);

  List<ApsGoodsSaleItem> importReq(List<ApsGoodsSaleItemImportReq> reqList);
}

