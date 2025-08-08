package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)保存返回
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

