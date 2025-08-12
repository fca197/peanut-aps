package com.olivia.peanut.aps.api.entity.apsMachine;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * aps 生产机器(ApsMachine)查询对象返回
 *
 * @author admin
 * @since 2025-07-23 13:19:18
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineDto extends BaseEntityDto {

  /***
   *  机器编号
   */
  @NotBlank(message = "机器编号不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "machineNo")
  private String machineNo;

  /***
   *  机器名称
   */
  @NotBlank(message = "机器名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "machineName")
  private String machineName;

  /***
   *  工厂ID
   */
  //  @JSONField(label = "factoryId")
  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long factoryId;

  /***
   *  最小功率
   */
  //  @JSONField(label = "minPower")
  // @NotNull(message = "最小功率不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //private BigDecimal minPower;

  /***
   *  最大功率
   */
  //  @JSONField(label = "maxPower")
  // @NotNull(message = "最大功率不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Integer maxPower;

  /***
   *  排序索引
   */
  //  @JSONField(label = "sortIndex")
  //  @NotNull(message = "排序索引不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long sortIndex;

  private String factoryName;
}


