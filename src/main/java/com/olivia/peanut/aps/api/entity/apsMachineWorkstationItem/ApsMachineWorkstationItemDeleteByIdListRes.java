package com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationItemDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

