package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderBomDto extends BaseEntityDto {

  /***
   *  齐套版本id
   */
  //  @JSONField(label = "kittingVersionId")
  @NotNull(message = "齐套版本id不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long kittingVersionId;
  /***
   *  订单ID
   */
  //  @JSONField(label = "orderId")
  @NotNull(message = "订单ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long orderId;
  /***
   *  订单ID
   */
  @NotBlank(message = "订单ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderNo")

  private String orderNo;
  /***
   *  开始制造时间
   */
  //  @JSONField(label = "orderMakeBeginDateTime")
  @NotNull(message = "开始制造时间不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private LocalDateTime orderMakeBeginDateTime;
  /***
   *  商品ID
   */
  //  @JSONField(label = "goodsId")
  @NotNull(message = "商品ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long goodsId;
  /***
   *  商品名称
   */
  @NotBlank(message = "商品名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "goodsName")

  private String goodsName;
  /***
   *  工段Id
   */
  //  @JSONField(label = "workshopSectionId")
  @NotNull(message = "工段Id不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long workshopSectionId;
  /***
   *  工段名称
   */
  @NotBlank(message = "工段名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "workshopSectionName")

  private String workshopSectionName;
  /***
   *  工位ID
   */
  //  @JSONField(label = "workshopStationId")
  @NotNull(message = "工位ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long workshopStationId;
  /***
   *  工位名称
   */
  @NotBlank(message = "工位名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "workshopStationName")

  private String workshopStationName;
  /***
   *  车间ID
   */
  //  @JSONField(label = "apsRoomId")
  @NotNull(message = "车间ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long apsRoomId;
  /***
   *  车间名称
   */
  @NotBlank(message = "车间名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "apsRoomName")

  private String apsRoomName;
  /***
   *  零件ID
   */
  //  @JSONField(label = "bomId")
  @NotNull(message = "零件ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long bomId;
  /***
   *  零件名称
   */
  @NotBlank(message = "零件名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "bomName")

  private String bomName;
  /***
   *  单个商品用量
   */
  //  @JSONField(label = "bomUsage")
  @NotNull(message = "单个商品用量不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private BigDecimal bomUsage;
  /***
   *  库存使用前数量
   */
  //  @JSONField(label = "inventoryBeforeCount")
  @NotNull(message = "库存使用前数量不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private BigDecimal inventoryBeforeCount;
  /***
   *  库存使用后数量
   */
  //  @JSONField(label = "inventoryAfterCount")
  @NotNull(message = "库存使用后数量不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private BigDecimal inventoryAfterCount;
  /***
   *  状态ID
   */
  //  @JSONField(label = "goodsStatusId")
  @NotNull(message = "状态ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long goodsStatusId;
  /***
   *  状态名称
   */
  @NotBlank(message = "状态名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "goodsStatusName")

  private String goodsStatusName;
  /***
   *  零件使用时间
   */
  //  @JSONField(label = "bomUseDateTime")
  @NotNull(message = "零件使用时间不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private LocalDateTime bomUseDateTime;
  /***
   *  计算日期
   */
  //  @JSONField(label = "createDate")
  @NotNull(message = "计算日期不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private LocalDate createDate;
  /***
   *  工厂ID
   */
  //  @JSONField(label = "factoryId")
  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long factoryId;

  private Boolean isEnough;


  private Long numberIndex;

}


