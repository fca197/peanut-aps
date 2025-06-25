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
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表实体类
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_order_goods_bom_kitting_version_order_item")
public class ApsOrderGoodsBomKittingVersionOrderItem extends BaseEntity {

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
   *  开始制造时间
   */
  @TableField("order_make_begin_date_time")
  private LocalDateTime orderMakeBeginDateTime;
  /***
   *  商品ID
   */
  @TableField("goods_id")
  private Long goodsId;
  /***
   *  商品名称
   */
  @TableField("goods_name")
  private String goodsName;
  /***
   *  工段Id
   */
  @TableField("workshop_section_id")
  private Long workshopSectionId;
  /***
   *  工段名称
   */
  @TableField("workshop_section_name")
  private String workshopSectionName;
  /***
   *  工位ID
   */
  @TableField("workshop_station_id")
  private Long workshopStationId;
  /***
   *  工位名称
   */
  @TableField("workshop_station_name")
  private String workshopStationName;
  /***
   *  车间ID
   */
  @TableField("aps_room_id")
  private Long apsRoomId;
  /***
   *  车间名称
   */
  @TableField("aps_room_name")
  private String apsRoomName;
  /***
   *  零件ID
   */
  @TableField("bom_id")
  private Long bomId;
  /***
   *  零件名称
   */
  @TableField("bom_name")
  private String bomName;
  /***
   *  单个商品用量
   */
  @TableField("bom_usage")
  private BigDecimal bomUsage;
  /***
   *  库存使用前数量
   */
  @TableField("inventory_before_count")
  private BigDecimal inventoryBeforeCount;
  /***
   *  库存使用后数量
   */
  @TableField("inventory_after_count")
  private BigDecimal inventoryAfterCount;
  /***
   *  状态ID
   */
  @TableField("goods_status_id")
  private Long goodsStatusId;
  /***
   *  状态名称
   */
  @TableField("goods_status_name")
  private String goodsStatusName;
  /***
   *  零件使用时间
   */
  @TableField("bom_use_date_time")
  private LocalDateTime bomUseDateTime;
  /***
   *  计算日期
   */
  @TableField("create_date")
  private LocalDate createDate;
  /***
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;

  @TableField("is_enough")
  private Boolean isEnough;
}

