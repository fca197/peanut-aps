package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

