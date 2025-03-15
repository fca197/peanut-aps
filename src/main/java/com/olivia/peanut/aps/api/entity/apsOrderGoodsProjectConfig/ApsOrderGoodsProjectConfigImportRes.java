package com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (ApsOrderGoodsProjectConfig)保存返回
 *
 * @author peanut
 * @since 2024-04-09 13:19:37
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsProjectConfigImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

