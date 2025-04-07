package com.olivia.peanut.aps.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.TableField;
import com.olivia.sdk.mybatis.type.MapTypeHandler;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)表实体类
 *
 * @author makejava
 * @since 2025-04-06 14:16:40
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_scheduling_version_item_pre")
public class ApsSchedulingVersionItemPre extends BaseEntity {
  /***
   *  排产版本ID
   */
  private Long schedulingVersionId;
  /***
   *  当前日期
   */
  private LocalDate currentDay;
  /***
   *  订单ID
   */
  private Long orderId;
  /***
   *  商品ID
   */
  private Long goodsId;
  /***
   *  生产序号
   */
  private Integer numberIndex;
  /***
   *  工厂id
   */
  private Long factoryId;
  /***
   *  显示字段
   */
  @TableField(typeHandler = MapTypeHandler.class)
  private Map<String,Object> showField;
  /***
   *  订单号
   */
  private String orderNo;

  /***
   * 是否遗留
   */
  private Boolean legacyOrder;

}

