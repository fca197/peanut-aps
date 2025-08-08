package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
public class ApsOrderGoodsBomKittingVersionExportQueryPageListReq {

  private int pageNum;
  private int pageSize;
  private Boolean queryPage = true;
  private ApsOrderGoodsBomKittingVersionDto data;
}

