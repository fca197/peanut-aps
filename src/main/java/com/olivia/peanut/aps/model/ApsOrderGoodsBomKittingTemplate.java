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
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)表实体类
 *
 * @author admin
 * @since 2025-06-26 17:08:56
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName(value = "aps_order_goods_bom_kitting_template", autoResultMap = true)
public class ApsOrderGoodsBomKittingTemplate extends BaseEntity {

  /***
   *  模板编号
   */
  @TableField("kitting_template_no")
  private String kittingTemplateNo;
  /***
   *  模板名称
   */
  @TableField("kitting_template_name")
  private String kittingTemplateName;
  /***
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;
  /***
   *  销售配置
   */
  @TableField(value = "kitting_template_sale_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> kittingTemplateSaleConfigList;
  /***
   *  订单配置
   */
  @TableField(value = "kitting_template_order_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> kittingTemplateOrderConfigList;
  /***
   *  订单用户配置
   */
  @TableField(value = "kitting_template_order_user_config_list", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> kittingTemplateOrderUserConfigList;

}

