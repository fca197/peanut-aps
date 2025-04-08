package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class ApsSchedulingDayConfigVersionAddOrderReq {

  @NotNull(message = "版本不能为空")
  private Long schedulingVersionId;

  @NotNull(message = "类型不能为空")
  private ApsSchedulingDayConfigVersionAddOrderTypeEnum type;

  @NotBlank(message = "值不能为空")
  private String valueList;

}
