package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSellerStore.*;
import com.olivia.peanut.aps.model.ApsSellerStore;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSellerStoreConverter {
  ApsSellerStoreConverter INSTANCE = Mappers.getMapper(ApsSellerStoreConverter.class);

  ApsSellerStore insertReq(ApsSellerStoreInsertReq req);

  ApsSellerStore updateReq(ApsSellerStoreUpdateByIdReq req);

  List<ApsSellerStoreDto> queryListRes(List<ApsSellerStore> list);

  List<ApsSellerStoreExportQueryPageListInfoRes> queryPageListRes(List<ApsSellerStore> list);

  List<ApsSellerStore> importReq(List<ApsSellerStoreImportReq> reqList);
}

