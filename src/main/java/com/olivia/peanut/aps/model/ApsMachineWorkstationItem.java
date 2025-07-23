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
public class ApsMachineWorkstationItem extends BaseEntity {

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

