package com.olivia.peanut.aps.api.entity.workshopStation;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 工位信息(WorkshopStation)查询对象入参
 *
 * @author makejava
 * @since 2024-03-11 10:55:24
 */
@Accessors(chain = true)
@Getter
@Setter

public class WorkshopStationQueryByIdListReq {

  private List<Long> idList;


}

