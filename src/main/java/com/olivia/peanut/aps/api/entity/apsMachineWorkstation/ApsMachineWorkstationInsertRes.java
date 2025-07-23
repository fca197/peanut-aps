package com.olivia.peanut.aps.api.entity.apsMachineWorkstation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)保存返回
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationInsertRes {

  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

