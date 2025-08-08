package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)根据ID删除多个反参
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

