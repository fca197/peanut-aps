package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSellerStore.ApsSellerStoreDto;
import com.olivia.peanut.aps.api.entity.apsSellerStore.ApsSellerStoreExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSellerStore.ApsSellerStoreImportReq;
import com.olivia.peanut.aps.api.entity.apsSellerStore.ApsSellerStoreInsertReq;
import com.olivia.peanut.aps.api.entity.apsSellerStore.ApsSellerStoreUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSellerStore;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSellerStoreConverter {

  ApsSellerStoreConverter INSTANCE = Mappers.getMapper(ApsSellerStoreConverter.class);

  ApsSellerStore insertReq(ApsSellerStoreInsertReq req);

  ApsSellerStore updateReq(ApsSellerStoreUpdateByIdReq req);

  List<ApsSellerStoreDto> queryListRes(List<ApsSellerStore> list);

  List<ApsSellerStoreExportQueryPageListInfoRes> queryPageListRes(List<ApsSellerStore> list);

  List<ApsSellerStore> importReq(List<ApsSellerStoreImportReq> reqList);
}

