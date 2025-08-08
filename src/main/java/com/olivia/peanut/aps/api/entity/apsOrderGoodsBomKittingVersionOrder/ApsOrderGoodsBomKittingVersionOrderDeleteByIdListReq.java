package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)根据ID删除多个入参
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderDeleteByIdListReq {

  /***
   * 要删除的ID
   */
  @NotEmpty(message = "请选择删除对象")
  private List<Long> idList;

}

