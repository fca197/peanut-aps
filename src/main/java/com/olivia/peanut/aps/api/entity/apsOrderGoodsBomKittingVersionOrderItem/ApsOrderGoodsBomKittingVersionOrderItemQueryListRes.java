package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 20:30:05
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderItemQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsBomKittingVersionOrderItemDto> dataList;


}

