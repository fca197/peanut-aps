package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemDto;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.SendMail2supplierReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.SendMail2supplierRes;
import com.olivia.peanut.aps.model.ApsGoodsBomBuyPlanItem;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * BOM 购买清单(ApsGoodsBomBuyPlanItem)表服务接口
 *
 * @author peanut
 * @since 2024-06-05 14:35:31
 */
public interface ApsGoodsBomBuyPlanItemService extends MPJBaseService<ApsGoodsBomBuyPlanItem> {

  ApsGoodsBomBuyPlanItemQueryListRes queryList(ApsGoodsBomBuyPlanItemQueryListReq req);

  DynamicsPage<ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes> queryPageList(
      ApsGoodsBomBuyPlanItemExportQueryPageListReq req);


  void setName(List<? extends ApsGoodsBomBuyPlanItemDto> apsGoodsBomBuyPlanItemDtoList);

  SendMail2supplierRes sendMail2supplier(SendMail2supplierReq req);
}

