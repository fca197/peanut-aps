package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本详情_机器(ApsSchedulingDayConfigVersionDetailMachine)表实体类
 *
 * @author makejava
 * @since 2024-10-27 00:12:55
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_scheduling_day_config_version_detail_machine")
public class ApsSchedulingDayConfigVersionDetailMachine extends BaseEntity<ApsSchedulingDayConfigVersionDetailMachine> {

  /***
   *  版本ID
   */
  private Long schedulingDayId;
  /***
   *  订单ID
   */
  private Long orderId;
  /***
   *  机器ID
   */
  private Long machineId;
  /***
   *  状态ID
   */
  private Long statusId;
  /***
   *  开始时间
   */
  private LocalDateTime beginDateTime;
  /***
   *  结束时间
   */
  private LocalDateTime endDateTime;

  private Long startSecond;
  private Long endSecond;
  private Long useTime;


  /***
   *  生产路径 Id aps_produce_process
   */
  private Long produceProcessId;


  /***
   * 状态
   */
  private Long goodsStatusId;
  private String goodsStatusName;

  /***
   *  工作站id
   */
  @TableField("machine_workstation_id")
  private Long machineWorkstationId;
  private String machineWorkstationName;

  @TableField("machine_name")
  private String machineName;

//  @TableField("use_time")
//  private Long useTime;
  /***
   *  最小功率
   */
  // @TableField("min_power")
  //private BigDecimal minPower;
  /***
   *  最大功率
   */
  @TableField("max_power")
  private Integer maxPower;
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


  private Long orderCreateIndex;
  private Long orderStepIndex;
}


