package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)保存返回
 *
 * @author makejava
 * @since 2025-04-06 14:16:39
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreInsertRes {
  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

