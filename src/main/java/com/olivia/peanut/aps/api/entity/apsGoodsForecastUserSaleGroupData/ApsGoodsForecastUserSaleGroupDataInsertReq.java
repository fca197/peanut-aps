package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)保存入参
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataInsertReq extends
    ApsGoodsForecastUserSaleGroupDataDto {

  public void checkParam() {
  }
}

