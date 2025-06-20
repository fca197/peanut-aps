package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalCreateBomBuyPlanReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalCreateBomBuyPlanRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryBomTotalReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryBomTotalRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryListRes;
import com.olivia.peanut.aps.model.ApsSchedulingGoodsBomTotal;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 订单商品零件汇总表(ApsSchedulingGoodsBomTotal)表服务接口
 *
 * @author peanut
 * @since 2024-06-02 22:04:08
 */
public interface ApsSchedulingGoodsBomTotalService extends
    MPJBaseService<ApsSchedulingGoodsBomTotal> {

  ApsSchedulingGoodsBomTotalQueryListRes queryList(ApsSchedulingGoodsBomTotalQueryListReq req);

  DynamicsPage<ApsSchedulingGoodsBomTotalExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingGoodsBomTotalExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingGoodsBomTotalDto> apsSchedulingGoodsBomTotalDtoList);

  DynamicsPage<ApsSchedulingGoodsBomTotalQueryBomTotalRes> queryBomTotal(
      ApsSchedulingGoodsBomTotalQueryBomTotalReq req);

  ApsSchedulingGoodsBomTotalCreateBomBuyPlanRes createBomBuyPlan(
      ApsSchedulingGoodsBomTotalCreateBomBuyPlanReq req);
}

