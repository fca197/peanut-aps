package com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 历史订单记录(ApsOrderGoodsHistory)查询对象返回
 *
 * @author makejava
 * @since 2025-02-20 17:18:46
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsHistoryQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderGoodsHistoryDto> dataList;


}

