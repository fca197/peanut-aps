package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.model.KVEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)查询对象返回
 *
 * @author admin
 * @since 2025-06-26 17:08:57
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsOrderGoodsBomKittingTemplateDto extends BaseEntityDto {

  /***
   *  模板编号
   */
  @NotBlank(message = "模板编号不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "kittingTemplateNo")

  private String kittingTemplateNo;
  /***
   *  模板名称
   */
  @NotBlank(message = "模板名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "kittingTemplateName")

  private String kittingTemplateName;
  /***
   *  工厂ID
   */
  //  @JSONField(label = "factoryId")
  @NotNull(message = "工厂ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  private Long factoryId;
  private String factoryName;
  /***
   *  销售配置
   */
  //  @JSONField(label = "kittingTemplateSaleConfigList")

  private List<KVEntity> kittingTemplateSaleConfigList;
  /***
   *  订单配置
   */
  //  @JSONField(label = "kittingTemplateOrderConfigList")

  private List<KVEntity> kittingTemplateOrderConfigList;
  /***
   *  订单配置
   */
  //  @JSONField(label = "kittingTemplateOrderUserConfigList")

  private List<KVEntity> kittingTemplateOrderUserConfigList;


}


