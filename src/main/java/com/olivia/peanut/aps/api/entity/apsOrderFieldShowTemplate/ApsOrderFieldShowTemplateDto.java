package com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate;

import com.olivia.sdk.utils.fastjson.Str2BooleanConverter;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.List;
import java.math.BigDecimal;
import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.alibaba.excel.annotation.ExcelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)查询对象返回
 *
 * @author admin
 * @since 2025-07-11 17:32:01
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderFieldShowTemplateDto extends BaseEntityDto {

  /***
   *  模板编号
   */
  @NotBlank(message = "模板编号不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsOrderUserNo")

  private String apsOrderUserNo;
  /***
   *  模板名称
   */
  @NotBlank(message = "模板名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsOrderUserName")

  private String apsOrderUserName;
  /***
   *  是否默认
   */
  //   @JSONField(label = "isDefault", serializeUsing = Boolean2StrFeature.class, deserializeUsing = Str2BooleanConverter.class)
  @ExcelProperty(value = "是否默认", converter = Str2BooleanConverter.class)

  private Boolean isDefault;
  /***
   *  销售配置
   */
  @NotBlank(message = "销售配置不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsOrderUserSaleConfigList")

  private String apsOrderUserSaleConfigList;
  /***
   *  订单配置
   */
  @NotBlank(message = "订单配置不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsOrderUserOrderConfigList")

  private String apsOrderUserOrderConfigList;
  /***
   *  订单配置
   */
  @NotBlank(message = "订单配置不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsOrderUserOrderUserConfigList")

  private String apsOrderUserOrderUserConfigList;

}


