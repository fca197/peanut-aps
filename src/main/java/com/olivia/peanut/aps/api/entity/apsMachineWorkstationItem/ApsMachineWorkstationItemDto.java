package com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)查询对象返回
 *
 * @author admin
 * @since 2025-07-23 13:20:08
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationItemDto extends BaseEntityDto {

  /***
   *  工作站id
   */
  //  @JSONField(label = "machineWorkstationId")
//  @NotNull(message = "工作站id不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long machineWorkstationId;

  /***
   *  机器ID
   */
  //  @JSONField(label = "machineId")
  @NotNull(message = "机器ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long machineId;

  /***
   *  最小功率
   */
  //  @JSONField(label = "minPower")
//  @NotNull(message = "最小功率不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private BigDecimal minPower;

  /***
   *  最大功率
   */
  //  @JSONField(label = "maxPower")
  // @NotNull(message = "最大功率不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private BigDecimal maxPower;

  /***
   *  工厂ID
   */
  //  @JSONField(label = "factoryId")
//  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long factoryId;

  /***
   *  排序索引
   */
  //  @JSONField(label = "sortIndex")
  //  @NotNull(message = "排序索引不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long sortIndex;

  private String machineName;

  private Long useTime;

  private Long goodsStatusId;

}


