package com.olivia.peanut.aps.service.impl.po;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class ApsOrderGoodsSaleHistoryCount {

  /***
   *  工厂ID
   */
  private Long factoryId;
  /***
   *  商品ID
   */
  private Long goodsId;
  /***
   *  销售ID
   */
  private Long saleConfigId;

  private Long total;

  public ApsOrderGoodsSaleHistoryCount() {

  }

  public ApsOrderGoodsSaleHistoryCount(Map<String, Object> map) {
    this.factoryId = (Long) map.get("factoryId");
    this.goodsId = (Long) map.get("goodsId");
    this.saleConfigId = (Long) map.get("saleConfigId");
    this.total = (Long) map.get("total");
  }
}
