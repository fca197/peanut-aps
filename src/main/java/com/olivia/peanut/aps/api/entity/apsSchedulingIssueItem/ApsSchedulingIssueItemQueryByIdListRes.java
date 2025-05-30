package com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 排产下发详情(ApsSchedulingIssueItem)查询对象返回
 *
 * @author peanut
 * @since 2024-07-20 13:55:55
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingIssueItemQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<ApsSchedulingIssueItemDto> dataList;


}

