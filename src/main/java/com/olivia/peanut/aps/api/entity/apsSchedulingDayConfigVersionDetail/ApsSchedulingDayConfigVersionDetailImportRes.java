package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetail;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本配置明细表(ApsSchedulingDayConfigVersionDetail)保存返回
 *
 * @author peanut
 * @since 2024-07-19 19:19:57
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionDetailImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

