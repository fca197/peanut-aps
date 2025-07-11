package com.olivia.peanut.aps.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)表实体类
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_order_field_show_template")
public class ApsOrderFieldShowTemplate extends BaseEntity {

  /***
   *  模板编号
   */
  @TableField("aps_order_user_no")
  private String apsOrderUserNo;
  /***
   *  模板名称
   */
  @TableField("aps_order_user_name")
  private String apsOrderUserName;
  /***
   *  是否默认
   */
  @TableField("is_default")
  private Boolean isDefault;
  /***
   *  销售配置
   */
  @TableField("aps_order_user_sale_config_list")
  private String apsOrderUserSaleConfigList;
  /***
   *  订单配置
   */
  @TableField("aps_order_user_order_config_list")
  private String apsOrderUserOrderConfigList;
  /***
   *  订单配置
   */
  @TableField("aps_order_user_order_user_config_list")
  private String apsOrderUserOrderUserConfigList;

}

