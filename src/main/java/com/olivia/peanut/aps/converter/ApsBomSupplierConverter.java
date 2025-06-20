package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsBomSupplier.ApsBomSupplierDto;
import com.olivia.peanut.aps.api.entity.apsBomSupplier.ApsBomSupplierExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsBomSupplier.ApsBomSupplierImportReq;
import com.olivia.peanut.aps.api.entity.apsBomSupplier.ApsBomSupplierInsertReq;
import com.olivia.peanut.aps.api.entity.apsBomSupplier.ApsBomSupplierUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsBomSupplier;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsBomSupplierConverter {

  ApsBomSupplierConverter INSTANCE = Mappers.getMapper(ApsBomSupplierConverter.class);

  ApsBomSupplier insertReq(ApsBomSupplierInsertReq req);

  ApsBomSupplier updateReq(ApsBomSupplierUpdateByIdReq req);

  List<ApsBomSupplierDto> queryListRes(List<ApsBomSupplier> list);

  List<ApsBomSupplierExportQueryPageListInfoRes> queryPageListRes(List<ApsBomSupplier> list);

  List<ApsBomSupplier> importReq(List<ApsBomSupplierImportReq> reqList);
}

