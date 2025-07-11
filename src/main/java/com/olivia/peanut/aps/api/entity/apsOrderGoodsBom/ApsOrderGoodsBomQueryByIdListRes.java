package com.olivia.peanut.aps.api.entity.apsOrderGoodsBom;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单商品零件表(ApsOrderGoodsBom)查询对象返回
 *
 * @author peanut
 * @since 2024-07-30 10:28:23
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsBomDto> dataList;


}

