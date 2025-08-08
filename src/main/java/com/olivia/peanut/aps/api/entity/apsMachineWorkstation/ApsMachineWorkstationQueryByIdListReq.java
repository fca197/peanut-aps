package com.olivia.peanut.aps.api.entity.apsMachineWorkstation;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)查询对象入参
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsMachineWorkstationQueryByIdListReq {

  private List<Long> idList;

}

