package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigDto;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigQueryListRes;
import com.olivia.peanut.aps.model.ApsRoomConfig;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsRoomConfig)表服务接口
 *
 * @author peanut
 * @since 2024-04-01 15:27:30
 */
public interface ApsRoomConfigService extends MPJBaseService<ApsRoomConfig> {

  ApsRoomConfigQueryListRes queryList(ApsRoomConfigQueryListReq req);

  DynamicsPage<ApsRoomConfigExportQueryPageListInfoRes> queryPageList(
      ApsRoomConfigExportQueryPageListReq req);


  void setName(List<? extends ApsRoomConfigDto> apsRoomConfigDtoList);
}

