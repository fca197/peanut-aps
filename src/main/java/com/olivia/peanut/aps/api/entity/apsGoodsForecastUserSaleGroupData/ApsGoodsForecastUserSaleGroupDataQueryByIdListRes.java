package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)查询对象返回
 *
 * @author admin
 * @since 2025-06-23 13:13:59
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsGoodsForecastUserSaleGroupDataDto> dataList;


}

