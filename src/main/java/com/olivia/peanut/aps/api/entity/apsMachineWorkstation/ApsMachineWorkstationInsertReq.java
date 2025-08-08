package com.olivia.peanut.aps.api.entity.apsMachineWorkstation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)保存入参
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationInsertReq extends ApsMachineWorkstationDto {

  public void checkParam() {
  }
}

