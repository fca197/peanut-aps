package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionFinishReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionFinishRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsResultReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseConstraintsResultRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityResultReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersion.ApsSchedulingVersionUseMakeCapacityResultRes;
import com.olivia.peanut.aps.model.ApsSchedulingVersion;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsSchedulingVersion)表服务接口
 *
 * @author peanut
 * @since 2024-04-13 21:32:14
 */
public interface ApsSchedulingVersionService extends MPJBaseService<ApsSchedulingVersion> {

  ApsSchedulingVersionQueryListRes queryList(ApsSchedulingVersionQueryListReq req);

  DynamicsPage<ApsSchedulingVersionExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingVersionExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingVersionDto> apsSchedulingVersionDtoList);

  ApsSchedulingVersionUseConstraintsRes useConstraints(ApsSchedulingVersionUseConstraintsReq req);

  ApsSchedulingVersionUseMakeCapacityRes useMakeCapacity(
      ApsSchedulingVersionUseMakeCapacityReq req);

  DynamicsPage<ApsSchedulingVersionUseConstraintsResultRes> useConstraintsResult(
      ApsSchedulingVersionUseConstraintsResultReq req);

  DynamicsPage<ApsSchedulingVersionUseMakeCapacityResultRes> useMakeCapacityResult(
      ApsSchedulingVersionUseMakeCapacityResultReq req);

  ApsSchedulingVersionFinishRes finish(ApsSchedulingVersionFinishReq req);
}

