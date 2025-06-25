package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)保存入参
 *
 * @author admin
 * @since 2025-06-25 14:23:48
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderInsertReq extends
    ApsOrderGoodsBomKittingVersionOrderDto {

  public void checkParam() {
  }
}

