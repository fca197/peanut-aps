package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsLogisticsPathItem.*;
import com.olivia.peanut.aps.model.ApsLogisticsPathItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsLogisticsPathItemConverter {

  ApsLogisticsPathItemConverter INSTANCE = Mappers.getMapper(ApsLogisticsPathItemConverter.class);

  ApsLogisticsPathItem insertReq(ApsLogisticsPathItemInsertReq req);

  ApsLogisticsPathItem updateReq(ApsLogisticsPathItemUpdateByIdReq req);

  List<ApsLogisticsPathItemDto> queryListRes(List<ApsLogisticsPathItem> list);

  List<ApsLogisticsPathItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsLogisticsPathItem> list);

  List<ApsLogisticsPathItem> importReq(List<ApsLogisticsPathItemImportReq> reqList);
}

