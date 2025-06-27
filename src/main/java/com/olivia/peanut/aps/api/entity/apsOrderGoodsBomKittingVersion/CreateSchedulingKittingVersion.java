package com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class CreateSchedulingKittingVersion {

  @NotNull(message = "排产模板为空")
  private Long schedulingVersionTemplateId;
  @NotNull(message = "排产版本为空")
  private Long schedulingVersionId;
  @NotNull(message = "排产日期为空")
  @Length(min = 1, message = "最低一个排产日期")
  private List<LocalDate> kittingDate;
}
