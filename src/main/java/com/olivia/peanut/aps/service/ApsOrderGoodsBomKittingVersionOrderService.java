package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrder;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.*;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)表服务接口
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
public interface ApsOrderGoodsBomKittingVersionOrderService extends
    MPJBaseService<ApsOrderGoodsBomKittingVersionOrder> {

  ApsOrderGoodsBomKittingVersionOrderQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderQueryListReq req);

  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req);


  void setName(
      List<? extends ApsOrderGoodsBomKittingVersionOrderDto> apsOrderGoodsBomKittingVersionOrderDtoList);
}

