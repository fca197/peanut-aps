package com.olivia.peanut.aps.api.entity.apsGoodsBom;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsGoodsBom)根据ID删除多个反参
 *
 * @author peanut
 * @since 2024-04-03 22:28:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsGoodsBomDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

