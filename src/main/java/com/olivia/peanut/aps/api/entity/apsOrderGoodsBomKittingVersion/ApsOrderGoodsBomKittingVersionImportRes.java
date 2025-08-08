package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)保存返回
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

