package com.olivia.peanut.aps.api.entity.apsMachine;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器(ApsMachine)查询对象返回
 *
 * @author makejava
 * @since 2024-10-24 16:31:14
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsMachineDto> dataList;


}

