package com.olivia.peanut.aps.service.pojo;

import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathDto;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
import com.olivia.peanut.base.model.ShiftItem;
import com.olivia.sdk.utils.model.WeekInfo;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 */
@Setter
@Getter
@Accessors(chain = true)
public class FactoryConfigRes {

  private Long factoryId;
  private String factoryName;
  private List<WeekInfo> weekList;
  private List<ShiftItem> shiftItemList;
//  private Map<Long, ApsProcessPathDto> pathDtoMap;
  private ApsProcessPathDto defaultApsProcessPathDto;
  private Map<Long,ApsProcessPathDto> processPathDtoMap;
  /***
   * 当天剩余工作时长
   */
  private Long dayWorkLastSecond;
  /***
   * 工作时长
   */
  private Long dayWorkSecond;
  private Map<Long, List<ApsProduceProcessItem>> apsProduceProcessItemMap;

}
