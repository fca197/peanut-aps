package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)查询对象返回
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsBomKittingTemplateDto> dataList;


}

