package com.olivia.peanut.aps.service.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 */
@Setter
@Getter
@Accessors(chain = true)
public class FactoryConfigReq {


  private Long factoryId;
  private String factoryName;
  private Boolean getWeek;
  private LocalDate weekBeginDate;
  private LocalDate weekEndDate;
  private Boolean getShift;
  private Long getPathId;
  private Boolean getPathDefault;
  private List<Long> apsProduceProcessIdList;
  private List<Long> processPathIdList;

  private LocalDateTime nowDateTime;
}
