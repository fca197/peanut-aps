package com.olivia.peanut.aps.model;


import static org.apache.ibatis.type.JdbcType.ARRAY;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.peanut.aps.enums.ApsSchedulingDayConfigVersionProductType;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.mybatis.type.ListKVTypeHandler;
import com.olivia.sdk.mybatis.type.ListLongTypeHandler;
import com.olivia.sdk.utils.BaseEntity;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排程版本(ApsSchedulingDayConfigVersion)表实体类
 *
 * @author peanut
 * @since 2024-07-19 19:19:55
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName(value = "aps_scheduling_day_config_version", autoResultMap = true)

public class ApsSchedulingDayConfigVersion extends BaseEntity {

  private Long schedulingDayConfigId;
  /***
   *  工厂ID
   */
  private Long factoryId;

  private Long processId;
  /***
   *  排程版本号
   */
  private String schedulingDayVersionNo;
  /***
   *  排程日期
   */
  private LocalDate schedulingDay;
  /***
   *  是否下发第三方
   */
  private Boolean isIssuedThird;

  private String headerList;

  // 生产方式  ， 工艺路径， 制造路径
  private ApsSchedulingDayConfigVersionProductType productType;

  @TableField(typeHandler = ListLongTypeHandler.class, jdbcType = ARRAY)
  private List<Long> goodsIdList;

  @TableField(typeHandler = ListKVTypeHandler.class, jdbcType = ARRAY)
  private List<KVEntity> saleConfigIdList;

  @TableField(typeHandler = ListKVTypeHandler.class, jdbcType = ARRAY)
  private List<KVEntity> orderFieldList;

  @TableField(typeHandler = ListKVTypeHandler.class, jdbcType = ARRAY)
  private List<KVEntity> orderUserFieldList;


  /***
   * 1 创建，2 确认订单，3 排程结束
   */
  private Integer stepIndex;

  /**
   * 查询旧订单
   */
  private Boolean searchOld;


}

