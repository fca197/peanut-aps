package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathDto;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathInsertReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathInsertRes;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathQueryListReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathQueryListRes;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathUpdateByIdRes;
import com.olivia.peanut.aps.model.ApsLogisticsPath;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 物流路径表(ApsLogisticsPath)表服务接口
 *
 * @author peanut
 * @since 2024-07-18 13:27:36
 */
public interface ApsLogisticsPathService extends MPJBaseService<ApsLogisticsPath> {

  ApsLogisticsPathQueryListRes queryList(ApsLogisticsPathQueryListReq req);

  DynamicsPage<ApsLogisticsPathExportQueryPageListInfoRes> queryPageList(
      ApsLogisticsPathExportQueryPageListReq req);


  void setName(List<? extends ApsLogisticsPathDto> apsLogisticsPathDtoList);

  ApsLogisticsPathInsertRes save(ApsLogisticsPathInsertReq req);

  ApsLogisticsPathUpdateByIdRes updateById(ApsLogisticsPathUpdateByIdReq req);
}

