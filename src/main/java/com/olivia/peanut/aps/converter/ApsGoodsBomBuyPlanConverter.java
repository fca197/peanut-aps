package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.*;
import com.olivia.peanut.aps.model.ApsGoodsBomBuyPlan;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomBuyPlanConverter {
  ApsGoodsBomBuyPlanConverter INSTANCE = Mappers.getMapper(ApsGoodsBomBuyPlanConverter.class);

  ApsGoodsBomBuyPlan insertReq(ApsGoodsBomBuyPlanInsertReq req);

  ApsGoodsBomBuyPlan updateReq(ApsGoodsBomBuyPlanUpdateByIdReq req);

  List<ApsGoodsBomBuyPlanDto> queryListRes(List<ApsGoodsBomBuyPlan> list);

  List<ApsGoodsBomBuyPlanExportQueryPageListInfoRes> queryPageListRes(List<ApsGoodsBomBuyPlan> list);

  List<ApsGoodsBomBuyPlan> importReq(List<ApsGoodsBomBuyPlanImportReq> reqList);
}

