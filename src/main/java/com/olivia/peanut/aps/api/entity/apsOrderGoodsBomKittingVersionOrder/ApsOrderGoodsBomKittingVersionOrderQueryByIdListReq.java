package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)查询对象入参
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderQueryByIdListReq {

  private List<Long> idList;

}

