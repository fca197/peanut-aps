package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)查询对象入参
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateQueryByIdListReq {

  private List<Long> idList;

}

