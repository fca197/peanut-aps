package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

