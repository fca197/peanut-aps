package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)查询对象入参
 *
 * @author admin
 * @since 2025-07-11 17:32:01
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateQueryByIdListReq {

  private List<Long> idList;

}

