package com.olivia.peanut.aps.api.entity.apsGoodsBom;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class CheckBomUseExpressionReq {

  //
  //使用表达 工程值: 格式 . 所有工序  (AA001&&AC002)&&(AB001||AB002)
  @NotBlank(message = "零件使用表达式不能为空")
  private String bomUseExpression;

}
