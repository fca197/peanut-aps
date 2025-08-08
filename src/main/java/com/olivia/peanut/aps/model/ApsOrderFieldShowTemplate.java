package com.olivia.peanut.aps.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.mybatis.type.impl.ListKVTypeHandler;
import com.olivia.sdk.utils.BaseEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@TableName(value = "aps_order_field_show_template", autoResultMap = true)
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
  @TableField(value = "aps_order_sale_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> apsOrderSaleConfigList;
  /***
   *  订单配置
   */
  @TableField(value = "aps_order_order_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> apsOrderOrderConfigList;
  /***
   *  订单配置
   */
  @TableField(value = "aps_order_order_user_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> apsOrderOrderUserConfigList;

}

