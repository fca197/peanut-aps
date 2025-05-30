package com.olivia.peanut.aps.api.entity.apsRollingForecastFactoryCapacity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 滚动预测(ApsRollingForecastFactoryCapacity)查询对象返回
 *
 * @author peanut
 * @since 2024-07-14 20:22:22
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsRollingForecastFactoryCapacityQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsRollingForecastFactoryCapacityDto> dataList;


}

