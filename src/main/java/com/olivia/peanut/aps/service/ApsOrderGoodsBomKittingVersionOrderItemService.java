package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderBom;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.*;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表服务接口
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
public interface ApsOrderGoodsBomKittingVersionOrderItemService extends
    MPJBaseService<ApsOrderGoodsBomKittingVersionOrderBom> {

  ApsOrderGoodsBomKittingVersionOrderBomQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderBomQueryListReq req);

  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req);


  void setName(
      List<? extends ApsOrderGoodsBomKittingVersionOrderBomDto> apsOrderGoodsBomKittingVersionOrderItemDtoList);
}

