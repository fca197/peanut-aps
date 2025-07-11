package com.olivia.peanut.aps.api.entity.apsSchedulingVersionCapacity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsSchedulingVersionCapacity)查询对象入参
 *
 * @author peanut
 * @since 2024-04-18 14:57:35
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionCapacityQueryByIdListReq {

  private List<Long> idList;


}

