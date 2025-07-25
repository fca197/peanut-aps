package com.olivia.peanut.aps.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表实体类
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_machine_workstation")
public class ApsMachineWorkstation extends BaseEntity {

  /***
   *  工作站编号
   */
  @TableField("machine_workstation_no")
  private String machineWorkstationNo;
  /***
   *  工作站名称
   */
  @TableField("machine_workstation_name")
  private String machineWorkstationName;
  /***
   *  最小功率
   */
  @TableField("min_power")
  private BigDecimal minPower;
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

}

