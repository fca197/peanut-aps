package com.olivia.peanut.aps.api.entity.apsRollingForecastOrderItem;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 滚动预测订单节点表(ApsRollingForecastOrderItem)查询对象入参
 *
 * @author peanut
 * @since 2024-07-16 10:31:20
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsRollingForecastOrderItemQueryByIdListReq {

  private List<Long> idList;


}

