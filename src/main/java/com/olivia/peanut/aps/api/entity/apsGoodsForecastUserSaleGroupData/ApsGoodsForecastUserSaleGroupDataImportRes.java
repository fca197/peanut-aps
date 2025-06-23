package com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)保存返回
 *
 * @author admin
 * @since 2025-06-23 13:13:59
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsForecastUserSaleGroupDataImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

