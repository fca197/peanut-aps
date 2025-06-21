package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.mybatis.type.impl.ListLongTypeHandler;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.JSON;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsGoodsForecast)表实体类
 *
 * @author peanut
 * @since 2024-03-30 13:38:53
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName(value = "aps_goods_forecast", autoResultMap = true)
public class ApsGoodsForecast extends BaseEntity {

  private Long goodsId;
  private String forecastNo;
  private String forecastName;
  private String forecastBeginDate;
  private String forecastEndDate;
  private String months;
  private Integer forecastStatus;
  @TableField(typeHandler = ListLongTypeHandler.class)
  private List<Long> saleConfigList;


  public List<String> getMonthList() {
    return JSON.readList(this.getMonths(), String.class);
  }
}

