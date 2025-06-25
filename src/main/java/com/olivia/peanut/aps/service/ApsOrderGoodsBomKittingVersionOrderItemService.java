package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表服务接口
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
public interface ApsOrderGoodsBomKittingVersionOrderItemService extends
    MPJBaseService<ApsOrderGoodsBomKittingVersionOrderItem> {

  ApsOrderGoodsBomKittingVersionOrderItemQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderItemQueryListReq req);

  DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req);


  void setName(
      List<? extends ApsOrderGoodsBomKittingVersionOrderItemDto> apsOrderGoodsBomKittingVersionOrderItemDtoList);
}

