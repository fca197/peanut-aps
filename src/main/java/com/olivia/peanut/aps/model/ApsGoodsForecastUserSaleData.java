package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 预测数据(ApsGoodsForecastUserSaleData)表实体类
 *
 * @author admin
 * @since 2025-06-22 18:31:33
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_goods_forecast_user_sale_data")
public class ApsGoodsForecastUserSaleData extends BaseEntity {

  /***
   *  预测ID
   */
  private Long forecastId;
  /***
   *  销售组Id
   */
  private Long saleConfigParentId;
  /***
   *  销售配置
   */
  private Long saleConfigId;
  private String saleConfigCode;
  private String saleConfigName;
  private Integer year;
  @TableField("month_01")
  private BigDecimal month01;
  @TableField("month_02")
  private BigDecimal month02;
  @TableField("month_03")
  private BigDecimal month03;
  @TableField("month_04")
  private BigDecimal month04;
  @TableField("month_05")
  private BigDecimal month05;
  @TableField("month_06")
  private BigDecimal month06;
  @TableField("month_07")
  private BigDecimal month07;
  @TableField("month_08")
  private BigDecimal month08;
  @TableField("month_09")
  private BigDecimal month09;
  @TableField("month_10")
  private BigDecimal month10;
  @TableField("month_11")
  private BigDecimal month11;
  @TableField("month_12")
  private BigDecimal month12;
  @TableField("month_result_01")
  private BigDecimal monthResult01;
  @TableField("month_result_02")
  private BigDecimal monthResult02;
  @TableField("month_result_03")
  private BigDecimal monthResult03;
  @TableField("month_result_04")
  private BigDecimal monthResult04;
  @TableField("month_result_05")
  private BigDecimal monthResult05;
  @TableField("month_result_06")
  private BigDecimal monthResult06;
  @TableField("month_result_07")
  private BigDecimal monthResult07;
  @TableField("month_result_08")
  private BigDecimal monthResult08;
  @TableField("month_result_09")
  private BigDecimal monthResult09;
  @TableField("month_result_10")
  private BigDecimal monthResult10;
  @TableField("month_result_11")
  private BigDecimal monthResult11;
  @TableField("month_result_12")
  private BigDecimal monthResult12;

}

