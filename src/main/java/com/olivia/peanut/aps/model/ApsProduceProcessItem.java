package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器(ApsProduceProcessItem)表实体类
 *
 * @author makejava
 * @since 2024-10-24 17:00:21
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_produce_process_item")
public class ApsProduceProcessItem extends BaseEntity<ApsProduceProcessItem> {

  /***
   *  生产路径 Id aps_produce_process
   */
  private Long produceProcessId;
  /***
   *  机器ID
   */
  private Long machineId;


  /***
   * 状态
   */
  private Long goodsStatusId;
  private String goodsStatusName;

  /***
   *  耗时（秒）
   */
  private Long useTime;

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

