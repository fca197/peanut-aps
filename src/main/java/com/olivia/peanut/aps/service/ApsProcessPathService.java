package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathDto;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathInsertReq;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathInsertRes;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathQueryListReq;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathQueryListRes;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsProcessPath;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * (ApsProcessPath)表服务接口
 *
 * @author peanut
 * @since 2024-04-01 17:49:18
 */
public interface ApsProcessPathService extends MPJBaseService<ApsProcessPath> {

  ApsProcessPathQueryListRes queryList(ApsProcessPathQueryListReq req);

  DynamicsPage<ApsProcessPathExportQueryPageListInfoRes> queryPageList(
      ApsProcessPathExportQueryPageListReq req);


  void setName(List<? extends ApsProcessPathDto> apsProcessPathDtoList);

  ApsProcessPathInsertRes save(ApsProcessPathInsertReq req);

  void updateById(ApsProcessPathUpdateByIdReq req);
}

