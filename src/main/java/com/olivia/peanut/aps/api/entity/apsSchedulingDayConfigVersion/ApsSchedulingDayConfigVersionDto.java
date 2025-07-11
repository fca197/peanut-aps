package com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion;

import com.olivia.peanut.aps.enums.ApsSchedulingDayConfigVersionProductType;
import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.utils.Str;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 排程版本(ApsSchedulingDayConfigVersion)查询对象返回
 *
 * @author peanut
 * @since 2024-07-19 19:19:56
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingDayConfigVersionDto extends BaseEntityDto {

  @NotNull(message = "排程配置不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long schedulingDayConfigId;
  /***
   *  工厂ID
   */
  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long factoryId;
  private String factoryName;

  //  @NotNull(message = "工序ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long processId;
  private String processName;
  /***
   *  排程版本号
   */
  @NotBlank(message = "排程版本号不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private String schedulingDayVersionNo;
  /***
   *  排程日期
   */
  @NotNull(message = "排程日期不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private LocalDate schedulingDay;
  /***
   *  是否默认
   */
//  @NotNull(message = "是否下发不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Boolean isIssuedThird;


  // 生产方式  ， 工艺路径， 制造路径
  @NotNull(message = "生产方式不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private ApsSchedulingDayConfigVersionProductType productType;


  private List<Long> goodsIdList;


  private List<KVEntity> saleConfigIdList;

  private List<KVEntity> orderFieldList;

  private List<KVEntity> orderUserFieldList;

  private Integer stepIndex;


  /**
   * 查询旧订单
   */
  private Boolean searchOld;

  public String getIsIssuedThirdStr() {

    return Str.booleanToStr(isIssuedThird);
//    return Boolean.TRUE.equals(isIssuedThird) ? "是" : "否";
  }


}


