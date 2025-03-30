package com.olivia.peanut.aps.api.entity.apsOrder;

import com.olivia.peanut.portal.api.entity.EChartResDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class OrderCreateDayCountRes extends EChartResDto {
  private List<Info> dataList;

  @Setter
  @Getter
  @Accessors(chain = true)
  public static class Info {
    private String date;
    private Number count;
  }
}
