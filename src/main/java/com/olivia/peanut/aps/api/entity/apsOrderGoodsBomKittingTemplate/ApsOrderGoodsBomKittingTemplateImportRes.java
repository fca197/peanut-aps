package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)保存返回
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

