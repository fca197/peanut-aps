package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)查询对象入参
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionQueryByIdListReq {

  private List<Long> idList;

}

