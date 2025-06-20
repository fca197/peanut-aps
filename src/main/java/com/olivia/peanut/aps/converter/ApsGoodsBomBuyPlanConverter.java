package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.ApsGoodsBomBuyPlanDto;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.ApsGoodsBomBuyPlanExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.ApsGoodsBomBuyPlanImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.ApsGoodsBomBuyPlanInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlan.ApsGoodsBomBuyPlanUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsGoodsBomBuyPlan;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsGoodsBomBuyPlanConverter {

  ApsGoodsBomBuyPlanConverter INSTANCE = Mappers.getMapper(ApsGoodsBomBuyPlanConverter.class);

  ApsGoodsBomBuyPlan insertReq(ApsGoodsBomBuyPlanInsertReq req);

  ApsGoodsBomBuyPlan updateReq(ApsGoodsBomBuyPlanUpdateByIdReq req);

  List<ApsGoodsBomBuyPlanDto> queryListRes(List<ApsGoodsBomBuyPlan> list);

  List<ApsGoodsBomBuyPlanExportQueryPageListInfoRes> queryPageListRes(
      List<ApsGoodsBomBuyPlan> list);

  List<ApsGoodsBomBuyPlan> importReq(List<ApsGoodsBomBuyPlanImportReq> reqList);
}

