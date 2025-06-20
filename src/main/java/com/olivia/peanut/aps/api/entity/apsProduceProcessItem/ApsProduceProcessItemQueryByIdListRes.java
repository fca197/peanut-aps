package com.olivia.peanut.aps.api.entity.apsProduceProcessItem;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器(ApsProduceProcessItem)查询对象返回
 *
 * @author makejava
 * @since 2024-10-24 17:00:22
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsProduceProcessItemQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsProduceProcessItemDto> dataList;


}

