package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class CanSchedulingOrderListReq {

  private Long schedulingVersionId;

  private List<Long> goodsIdList;

}
