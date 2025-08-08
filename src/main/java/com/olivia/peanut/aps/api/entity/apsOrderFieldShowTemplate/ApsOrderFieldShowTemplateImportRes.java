package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)保存返回
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

