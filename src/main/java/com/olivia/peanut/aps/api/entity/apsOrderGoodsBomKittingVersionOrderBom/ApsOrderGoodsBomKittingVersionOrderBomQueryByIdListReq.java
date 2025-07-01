package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)查询对象入参
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListReq {

  private List<Long> idList;

}

