package com.olivia.peanut.aps.api.entity.apsOrderUser;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (ApsOrderUser)查询对象返回
 *
 * @author peanut
 * @since 2024-04-09 13:19:39
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderUserQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsOrderUserDto> dataList;


}

