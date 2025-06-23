package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)查询对象入参
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataQueryListReq {

  private ApsGoodsForecastUserSaleGroupDataDto data;
}

