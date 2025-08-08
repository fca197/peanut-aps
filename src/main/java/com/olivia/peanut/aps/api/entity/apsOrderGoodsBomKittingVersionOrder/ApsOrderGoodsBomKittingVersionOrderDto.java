package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.model.KVEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionOrderDto extends BaseEntityDto {

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
   *  齐套率
   */
  //  @JSONField(label = "kittingRate")
  @NotNull(message = "齐套率不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private BigDecimal kittingRate;
  /***
   *  齐套状态 已齐套， 部分齐套，未齐套
   */
  @NotBlank(message = "齐套状态 已齐套， 部分齐套，未齐套不能为空", groups = {InsertCheck.class,
      UpdateCheck.class})
  //  @JSONField(label = "kittingStatus")

  private String kittingStatus;
  /***
   *  缺失物料前10 [{id: label}]
   */
  @NotBlank(message = "缺失物料前10 [{id: label}]不能为空", groups = {InsertCheck.class,
      UpdateCheck.class})
  //  @JSONField(label = "kittingMissingBom")
  private List<KVEntity> kittingMissingBom;

  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField01")

  private String orderField01;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField02")

  private String orderField02;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField03")

  private String orderField03;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField04")

  private String orderField04;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField05")

  private String orderField05;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField06")

  private String orderField06;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField07")

  private String orderField07;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField08")

  private String orderField08;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField09")

  private String orderField09;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField10")

  private String orderField10;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField11")

  private String orderField11;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField12")

  private String orderField12;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField13")

  private String orderField13;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField14")

  private String orderField14;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField15")

  private String orderField15;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField16")

  private String orderField16;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField17")

  private String orderField17;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField18")

  private String orderField18;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField19")

  private String orderField19;
  /***
   *  订单字段
   */
  @NotBlank(message = "订单字段不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "orderField20")

  private String orderField20;
  /***
   *  工厂ID
   */
  //  @JSONField(label = "factoryId")
  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long factoryId;
  private Long numberIndex;

}


