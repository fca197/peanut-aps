package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)查询对象入参
 *
 * @author makejava
 * @since 2025-04-06 14:16:40
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreExportQueryPageListReq {
  private int pageNum;
  private int pageSize;
  private Boolean queryPage = true;
  private ApsSchedulingVersionItemPreDto data;
}

