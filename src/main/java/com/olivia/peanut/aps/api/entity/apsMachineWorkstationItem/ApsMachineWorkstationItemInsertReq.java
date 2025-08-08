package com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)保存入参
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationItemInsertReq extends ApsMachineWorkstationItemDto {

  public void checkParam() {
  }
}

