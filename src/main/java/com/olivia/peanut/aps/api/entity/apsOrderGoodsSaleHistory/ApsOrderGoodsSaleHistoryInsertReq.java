package com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleHistory;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 销售规划订单历史销售占比(ApsOrderGoodsSaleHistory)保存入参
 *
 * @author makejava
 * @since 2025-02-18 14:28:40
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsSaleHistoryInsertReq extends ApsOrderGoodsSaleHistoryDto {

  public void checkParam() {
  }
}

