package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleData;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (ApsGoodsForecastUserSaleData)查询对象入参
 *
 * @author peanut
 * @since 2024-03-30 18:29:07
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleDataQueryByIdListReq {

  private List<Long> idList;


}

