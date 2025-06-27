package com.olivia.peanut.aps.model;

import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.mybatis.type.impl.ListKVTypeHandler;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.olivia.sdk.utils.BaseEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)表实体类
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName(value = "aps_order_goods_bom_kitting_version_order" ,autoResultMap = true)
public class ApsOrderGoodsBomKittingVersionOrder extends BaseEntity {

  /***
   *  齐套版本id
   */
  @TableField("kitting_version_id")
  private Long kittingVersionId;
  /***
   *  订单ID
   */
  @TableField("order_id")
  private Long orderId;
  /***
   *  订单ID
   */
  @TableField("order_no")
  private String orderNo;
  /***
   *  齐套率
   */
  @TableField("kitting_rate")
  private BigDecimal kittingRate;
  /***
   *  齐套状态 已齐套， 部分齐套，未齐套
   */
  @TableField("kitting_status")
  private String kittingStatus;
  /***
   *  缺失物料前10 [{id: label}]
   */
  @TableField(value = "kitting_missing_bom",typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> kittingMissingBom;

  /***
   *  订单字段
   */
  @TableField("order_field_01")
  private String orderField01;
  /***
   *  订单字段
   */
  @TableField("order_field_02")
  private String orderField02;
  /***
   *  订单字段
   */
  @TableField("order_field_03")
  private String orderField03;
  /***
   *  订单字段
   */
  @TableField("order_field_04")
  private String orderField04;
  /***
   *  订单字段
   */
  @TableField("order_field_05")
  private String orderField05;
  /***
   *  订单字段
   */
  @TableField("order_field_06")
  private String orderField06;
  /***
   *  订单字段
   */
  @TableField("order_field_07")
  private String orderField07;
  /***
   *  订单字段
   */
  @TableField("order_field_08")
  private String orderField08;
  /***
   *  订单字段
   */
  @TableField("order_field_09")
  private String orderField09;
  /***
   *  订单字段
   */
  @TableField("order_field_10")
  private String orderField10;
  /***
   *  订单字段
   */
  @TableField("order_field_11")
  private String orderField11;
  /***
   *  订单字段
   */
  @TableField("order_field_12")
  private String orderField12;
  /***
   *  订单字段
   */
  @TableField("order_field_13")
  private String orderField13;
  /***
   *  订单字段
   */
  @TableField("order_field_14")
  private String orderField14;
  /***
   *  订单字段
   */
  @TableField("order_field_15")
  private String orderField15;
  /***
   *  订单字段
   */
  @TableField("order_field_16")
  private String orderField16;
  /***
   *  订单字段
   */
  @TableField("order_field_17")
  private String orderField17;
  /***
   *  订单字段
   */
  @TableField("order_field_18")
  private String orderField18;
  /***
   *  订单字段
   */
  @TableField("order_field_19")
  private String orderField19;
  /***
   *  订单字段
   */
  @TableField("order_field_20")
  private String orderField20;
  /***
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;



  private Long numberIndex;
}

