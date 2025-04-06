package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)根据ID删除多个反参
 *
 * @author makejava
 * @since 2025-04-06 14:16:39
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreDeleteByIdListRes {
  /***
   * 受影响行数
   */
  private int count;

}

