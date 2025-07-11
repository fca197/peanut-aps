package com.olivia.peanut.aps.api.entity.apsGoodsForecastMakeBomUse;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsGoodsForecastMakeBomUse)查询对象入参
 *
 * @author peanut
 * @since 2024-05-15 10:26:04
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastMakeBomUseQueryByIdListReq {

  private List<Long> idList;


}

