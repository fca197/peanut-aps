package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本配置明细表(ApsSchedulingDayConfigVersionDetail)查询对象返回
 *
 * @author peanut
 * @since 2024-07-19 19:19:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionDetailQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingDayConfigVersionDetailDto> dataList;


}

