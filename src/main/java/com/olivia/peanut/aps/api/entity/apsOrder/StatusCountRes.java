package com.olivia.peanut.aps.api.entity.apsOrder;

import com.olivia.peanut.aps.api.entity.apsStatus.ApsStatusDto;
import com.olivia.peanut.portal.api.entity.EChartResDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class StatusCountRes extends EChartResDto {


  private List<ApsStatusDto> apsStatusDtoList;
  private List<Info> dataInfoList;

  @Getter
  @Accessors(chain = true)
  @AllArgsConstructor
  public static class Info {

    private Long apsStatusId;
    private Long total;
  }


}
