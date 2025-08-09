package com.olivia.peanut.aps.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)表实体类
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_machine_workstation_item")
public class ApsMachineWorkstationItem extends BaseEntity<ApsMachineWorkstationItem> {

  /***
   *  工作站id
   */
  @TableField("machine_workstation_id")
  private Long machineWorkstationId;
  /***
   *  机器ID
   */
  @TableField("machine_id")
  private Long machineId;

  @TableField("machine_name")
  private String machineName;

  @TableField("use_time")
  private Long useTime;
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
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;
  /***
   *  排序索引
   */
  @TableField("sort_index")
  private Long sortIndex;

  @TableField("goods_status_id")
  private Long goodsStatusId;
}

