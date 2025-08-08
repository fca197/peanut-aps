package com.olivia.peanut.aps.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器(ApsMachine)表实体类
 *
 * @author admin
 * @since 2025-07-23 13:18:22
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_machine")
public class ApsMachine extends BaseEntity {

  /***
   *  机器编号
   */
  @TableField("machine_no")
  private String machineNo;
  /***
   *  机器名称
   */
  @TableField("machine_name")
  private String machineName;
  /***
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;
  /***
   *  最小功率
   */
  // @TableField("min_power")
  //private BigDecimal minPower;
  /***
   *  最大功率
   */
  @TableField("max_power")
  private BigDecimal maxPower;
  /***
   *  排序索引
   */
  @TableField("sort_index")
  private Long sortIndex;

}

