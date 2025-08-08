package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)根据ID删除多个入参
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateDeleteByIdListReq {

  /***
   * 要删除的ID
   */
  @NotEmpty(message = "请选择删除对象")
  private List<Long> idList;

}

