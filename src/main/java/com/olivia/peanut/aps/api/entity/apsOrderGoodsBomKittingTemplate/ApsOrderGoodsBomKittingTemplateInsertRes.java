package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)保存返回
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateInsertRes {

  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

