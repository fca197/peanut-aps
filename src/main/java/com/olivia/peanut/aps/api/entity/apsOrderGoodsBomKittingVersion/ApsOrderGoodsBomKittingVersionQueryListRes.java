package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsBomKittingVersionDto> dataList;


}

