package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)根据ID删除多个入参
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateDeleteByIdListReq {

  /***
   * 要删除的ID
   */
  @NotEmpty(message = "请选择删除对象")
  private List<Long> idList;

}

