package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsGetUseFieldRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingConstraints.ApsSchedulingConstraintsQueryListRes;
import com.olivia.peanut.aps.model.ApsSchedulingConstraints;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsSchedulingConstraints)表服务接口
 *
 * @author peanut
 * @since 2024-04-13 21:32:13
 */
public interface ApsSchedulingConstraintsService extends MPJBaseService<ApsSchedulingConstraints> {

  ApsSchedulingConstraintsQueryListRes queryList(ApsSchedulingConstraintsQueryListReq req);

  DynamicsPage<ApsSchedulingConstraintsExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingConstraintsExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingConstraintsDto> apsSchedulingConstraintsDtoList);

  ApsSchedulingConstraintsGetUseFieldRes getUseField();
}

