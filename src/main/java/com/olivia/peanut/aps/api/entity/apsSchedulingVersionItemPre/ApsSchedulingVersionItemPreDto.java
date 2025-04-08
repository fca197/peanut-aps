package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)查询对象返回
 *
 * @author makejava
 * @since 2025-04-06 14:16:41
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreDto extends BaseEntityDto {

  /***
   *  排产版本ID
   */
  //  @JSONField(label = "schedulingVersionId")
  @NotNull(message = "排产版本ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long schedulingVersionId;
  /***
   *  当前日期
   */
  @NotBlank(message = "当前日期不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "currentDay")

  private LocalDate currentDay;
  /***
   *  订单ID
   */
  //  @JSONField(label = "orderId")
  @NotNull(message = "订单ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long orderId;
  /***
   *  商品ID
   */
  //  @JSONField(label = "goodsId")
  @NotNull(message = "商品ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long goodsId;
  /***
   *  生产序号
   */
  //  @JSONField(label = "numberIndex")
  @NotNull(message = "生产序号不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Integer numberIndex;
  /***
   *  工厂id
   */
  //  @JSONField(label = "factoryId")
  @NotNull(message = "工厂id不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long factoryId;
  /***
   *  显示字段
   */
  @NotBlank(message = "显示字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "showField")

  private Map<String, Object> showField;
  /***
   *  订单号
   */
  @NotBlank(message = "订单号不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderNo")

  private String orderNo;



  /***
   * 是否遗留
   */
  private Boolean legacyOrder;


  private String goodsName;
  private String factoryName;

  private LocalDate oldScheduleDate;
}


