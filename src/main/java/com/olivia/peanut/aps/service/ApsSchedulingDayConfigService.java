package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigUpdateByIdRes;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfig;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 排程版本表(ApsSchedulingDayConfig)表服务接口
 *
 * @author peanut
 * @since 2024-07-19 19:19:49
 */
public interface ApsSchedulingDayConfigService extends MPJBaseService<ApsSchedulingDayConfig> {

  ApsSchedulingDayConfigQueryListRes queryList(ApsSchedulingDayConfigQueryListReq req);

  DynamicsPage<ApsSchedulingDayConfigExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingDayConfigExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingDayConfigDto> apsSchedulingDayConfigDtoList);

  ApsSchedulingDayConfigInsertRes save(ApsSchedulingDayConfigInsertReq req);

  ApsSchedulingDayConfigUpdateByIdRes updateById(ApsSchedulingDayConfigUpdateByIdReq req);
}

