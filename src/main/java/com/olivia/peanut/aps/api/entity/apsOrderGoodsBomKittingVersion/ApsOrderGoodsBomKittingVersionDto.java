package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.model.KVEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)查询对象返回
 *
 * @author admin
 * @since 2025-06-25 10:13:09
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingVersionDto extends BaseEntityDto {

  /***
   *  齐套版本编码
   */
  @NotBlank(message = "齐套版本编码不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "kittingVersionNo")

  private String kittingVersionNo;
  /***
   *  齐套版本名称
   */
  @NotBlank(message = "齐套版本名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "kittingVersionName")

  private String kittingVersionName;
  /***
   *  齐套来源
   */
  @NotBlank(message = "齐套来源不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "kittingVersionSource")

  private String kittingVersionSource;


  /***
   *  业务ID
   */
  private Long bizId;
  /***
   *  创建参数
   */
  private String versionCreateParam;
  /***
   *  订单数量
   */
  //  @JSONField(label = "orderCount")
  @NotNull(message = "订单数量不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long orderCount;
  /***
   *  齐套数
   */
  //  @JSONField(label = "kittingSuccessCount")
  @NotNull(message = "齐套数不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long kittingSuccessCount;
  /***
   *  非齐套数
   */
  //  @JSONField(label = "kittingFailCount")
  @NotNull(message = "非齐套数不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long kittingFailCount;
  /***
   *  齐套率
   */
  //  @JSONField(label = "kittingRate")
  @NotNull(message = "齐套率不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private BigDecimal kittingRate;
  /***
   *  齐套状态 已齐套， 部分齐套，未齐套
   */
  //  @JSONField(label = "kittingStatus")
  @NotNull(message = "齐套状态 已齐套， 部分齐套，未齐套不能为空", groups = {InsertCheck.class,
      UpdateCheck.class})

  private String kittingStatus;
  /***
   *  缺失物料前10 [{id: label}]
   */
  @NotBlank(message = "缺失物料前10 [{id: label}]不能为空", groups = {InsertCheck.class,
      UpdateCheck.class})
  //  @JSONField(label = "kittingMissingBom")

  private List<KVEntity> kittingMissingBom;
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
  private String factoryName;
  /***
   *  状态
   */
  //  @JSONField(label = "goodsStatusId")
  @NotNull(message = "状态不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long goodsStatusId;
  /***
   *  使用时间
   */
  //  @JSONField(label = "bomUseDate")
  @NotNull(message = "使用时间不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private LocalDate bomUseDate;

}


