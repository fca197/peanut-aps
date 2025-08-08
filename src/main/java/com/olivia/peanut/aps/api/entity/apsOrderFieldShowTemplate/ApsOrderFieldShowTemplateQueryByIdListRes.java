package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)查询对象返回
 *
 * @author admin
 * @since 2025-07-11 17:32:01
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderFieldShowTemplateDto> dataList;


}

