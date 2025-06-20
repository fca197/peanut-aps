package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDto;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderImportReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsOrder;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsOrderConverter {

  ApsOrderConverter INSTANCE = Mappers.getMapper(ApsOrderConverter.class);

  ApsOrder insertReq(ApsOrderInsertReq req);

  ApsOrder updateReq(ApsOrderUpdateByIdReq req);

  List<ApsOrderDto> queryListRes(List<ApsOrder> list);

  List<ApsOrderExportQueryPageListInfoRes> queryPageListRes(List<ApsOrder> list);

  List<ApsOrder> importReq(List<ApsOrderImportReq> reqList);
}

