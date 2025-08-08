package com.olivia.peanut.aps.api.entity.apsMachineWorkstation;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)根据ID删除多个入参
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationDeleteByIdListReq {

  /***
   * 要删除的ID
   */
  @NotEmpty(message = "请选择删除对象")
  private List<Long> idList;

}

