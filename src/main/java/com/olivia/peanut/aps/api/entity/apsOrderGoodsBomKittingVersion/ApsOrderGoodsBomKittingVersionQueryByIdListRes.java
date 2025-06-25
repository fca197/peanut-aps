package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsBomKittingVersionDto> dataList;


}

