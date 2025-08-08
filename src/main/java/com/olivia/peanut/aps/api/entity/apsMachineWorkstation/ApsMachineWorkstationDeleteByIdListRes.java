package com.olivia.peanut.aps.api.entity.apsMachineWorkstation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

