package com.olivia.peanut.aps.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.ann.FieldExt;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (ApsOrderUser)表实体类
 *
 * @author peanut
 * @since 2024-04-09 13:19:39
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("aps_order_user")
public class ApsOrderUser extends BaseEntity {

  private Long orderId;

  @FieldExt(fieldName = "用户姓名")
  private String userName;

  @FieldExt(fieldName = "用户手机号")
  private String userPhone;
  private Integer userSex;

  @FieldExt(fieldName = "国")
  private String countryCode;
  @FieldExt(fieldName = "省")
  private String provinceCode;
  @FieldExt(fieldName = "市")
  private String cityCode;
  @FieldExt(fieldName = "区")
  private String areaCode;
  private String userAddress;
  private String userRemark;
  private Long factoryId;

}

