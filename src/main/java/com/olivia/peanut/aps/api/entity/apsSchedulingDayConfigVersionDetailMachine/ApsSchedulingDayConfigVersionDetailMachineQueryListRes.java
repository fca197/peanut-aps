package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本详情_机器(ApsSchedulingDayConfigVersionDetailMachine)查询对象返回
 *
 * @author makejava
 * @since 2024-10-27 00:12:54
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionDetailMachineQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingDayConfigVersionDetailMachineDto> dataList;


}

