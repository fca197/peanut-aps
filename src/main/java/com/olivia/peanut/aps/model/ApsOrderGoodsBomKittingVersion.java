package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.mybatis.type.impl.ListKVTypeHandler;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)表实体类
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName(value = "aps_order_goods_bom_kitting_version", autoResultMap = true)
public class ApsOrderGoodsBomKittingVersion extends BaseEntity {

  @TableField("aps_order_goods_bom_kitting_template_id")
  private Long apsOrderGoodsBomKittingTemplateId;
  /***
   *  齐套版本编码
   */
  @TableField("kitting_version_no")
  private String kittingVersionNo;
  /***
   *  齐套版本名称
   */
  @TableField("kitting_version_name")
  private String kittingVersionName;
  /***
   *  齐套来源
   */
  @TableField("kitting_version_source")
  private String kittingVersionSource;

  /***
   *  业务ID
   */
  @TableField("biz_id")
  private Long bizId;
  /***
   *  创建参数
   */
  @TableField("version_create_param")
  private String versionCreateParam;
  /***
   *  订单数量
   */
  @TableField("order_count")
  private Long orderCount;
  /***
   *  齐套数
   */
  @TableField("kitting_success_count")
  private Long kittingSuccessCount;
  /***
   *  非齐套数
   */
  @TableField("kitting_fail_count")
  private Long kittingFailCount;
  /***
   *  齐套率
   */
  @TableField("kitting_rate")
  private BigDecimal kittingRate;
  /***
   *  齐套状态 已齐套， 部分齐套，未齐套
   */
  @TableField("kitting_status")
  private String kittingStatus;
  /***
   *  缺失物料前10 [{id: label}]
   */
  @TableField(value = "kitting_missing_bom", typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> kittingMissingBom;
  /***
   *  计算日期
   */
  @TableField("create_date")
  private LocalDate createDate;
  /***
   *  工厂ID
   */
  @TableField("factory_id")
  private Long factoryId;
  /***
   *  状态
   */
  @TableField("goods_status_id")
  private Long goodsStatusId;
  /***
   *  使用时间
   */
  @TableField("bom_use_date")
  private LocalDate bomUseDate;


  @TableField(value = "template_header_list" ,typeHandler = ListKVTypeHandler.class)
  private List<KVEntity> templateHeaderList;

}

