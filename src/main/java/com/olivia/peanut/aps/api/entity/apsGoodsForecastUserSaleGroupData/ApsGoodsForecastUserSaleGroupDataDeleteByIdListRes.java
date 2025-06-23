package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

