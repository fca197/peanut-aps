package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)查询对象返回
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderFieldShowTemplateDto> dataList;


}

