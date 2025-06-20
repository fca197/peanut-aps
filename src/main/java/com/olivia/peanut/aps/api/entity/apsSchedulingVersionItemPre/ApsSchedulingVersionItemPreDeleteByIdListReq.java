package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)根据ID删除多个入参
 *
 * @author makejava
 * @since 2025-04-06 14:16:39
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreDeleteByIdListReq {

  /***
   * 要删除的ID
   */
  @NotEmpty(message = "请选择删除对象")
  private List<Long> idList;

}

