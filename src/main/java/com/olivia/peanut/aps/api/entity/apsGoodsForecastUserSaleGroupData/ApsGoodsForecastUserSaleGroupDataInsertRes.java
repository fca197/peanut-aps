package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)保存返回
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataInsertRes {

  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

