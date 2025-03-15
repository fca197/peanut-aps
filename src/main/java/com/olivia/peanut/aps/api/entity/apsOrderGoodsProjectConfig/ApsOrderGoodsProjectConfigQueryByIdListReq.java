package com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (ApsOrderGoodsProjectConfig)查询对象入参
 *
 * @author peanut
 * @since 2024-04-09 13:19:37
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsProjectConfigQueryByIdListReq {

  private List<Long> idList;


}

