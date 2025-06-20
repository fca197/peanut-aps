package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemDto;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsBomBuyPlanItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomBuyPlanItemConverter {

  ApsGoodsBomBuyPlanItemConverter INSTANCE = Mappers.getMapper(
      ApsGoodsBomBuyPlanItemConverter.class);

  ApsGoodsBomBuyPlanItem insertReq(ApsGoodsBomBuyPlanItemInsertReq req);

  ApsGoodsBomBuyPlanItem updateReq(ApsGoodsBomBuyPlanItemUpdateByIdReq req);

  List<ApsGoodsBomBuyPlanItemDto> queryListRes(List<ApsGoodsBomBuyPlanItem> list);

  List<ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsBomBuyPlanItem> list);

  List<ApsGoodsBomBuyPlanItem> importReq(List<ApsGoodsBomBuyPlanItemImportReq> reqList);
}

