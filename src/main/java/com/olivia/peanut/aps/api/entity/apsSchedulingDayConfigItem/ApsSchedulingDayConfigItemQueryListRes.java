package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigItem;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本配置表(ApsSchedulingDayConfigItem)查询对象返回
 *
 * @author peanut
 * @since 2024-07-19 19:19:52
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigItemQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingDayConfigItemDto> dataList;


}

