package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程结果机器使用率(ApsSchedulingDayConfigVersionDetailMachineUseTime)查询对象返回
 *
 * @author makejava
 * @since 2024-11-11 15:21:50
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionDetailMachineUseTimeQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingDayConfigVersionDetailMachineUseTimeDto> dataList;


}

