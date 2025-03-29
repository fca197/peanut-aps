package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.*;
import com.olivia.peanut.aps.model.ApsGoodsBomBuyPlanItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomBuyPlanItemConverter {
  ApsGoodsBomBuyPlanItemConverter INSTANCE = Mappers.getMapper(ApsGoodsBomBuyPlanItemConverter.class);

  ApsGoodsBomBuyPlanItem insertReq(ApsGoodsBomBuyPlanItemInsertReq req);

  ApsGoodsBomBuyPlanItem updateReq(ApsGoodsBomBuyPlanItemUpdateByIdReq req);

  List<ApsGoodsBomBuyPlanItemDto> queryListRes(List<ApsGoodsBomBuyPlanItem> list);

  List<ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsBomBuyPlanItem> list);

  List<ApsGoodsBomBuyPlanItem> importReq(List<ApsGoodsBomBuyPlanItemImportReq> reqList);
}

