package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本(ApsSchedulingDayConfigVersion)查询对象返回
 *
 * @author peanut
 * @since 2024-07-19 19:19:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingDayConfigVersionDto> dataList;


}

