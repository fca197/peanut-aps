package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsGoods)表实体类
 *
 * @author peanut
 * @since 2024-03-29 16:11:23
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_goods")
public class ApsGoods extends BaseEntity<ApsGoods> {

  /***
   * 工厂ID
   */
  private Long factoryId;
  /***
   * 商品名称
   */
  private String goodsName;
  /***
   * 备注
   */
  private String goodsRemark;

  /***
   * 工艺路径Id
   */
  private Long processPathId;
  /***
   * 制造路径ID
   */
  private Long produceProcessId;

}

