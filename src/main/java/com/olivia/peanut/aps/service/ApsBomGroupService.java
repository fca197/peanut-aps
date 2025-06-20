package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupDto;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupQueryListReq;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupQueryListRes;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsBomGroup.ApsBomGroupUpdateByIdRes;
import com.olivia.peanut.aps.model.ApsBomGroup;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 零件组配置(ApsBomGroup)表服务接口
 *
 * @author peanut
 * @since 2024-06-19 17:41:23
 */
public interface ApsBomGroupService extends MPJBaseService<ApsBomGroup> {

  ApsBomGroupQueryListRes queryList(ApsBomGroupQueryListReq req);

  DynamicsPage<ApsBomGroupExportQueryPageListInfoRes> queryPageList(
      ApsBomGroupExportQueryPageListReq req);


  void setName(List<? extends ApsBomGroupDto> apsBomGroupDtoList);

  ApsBomGroupUpdateByIdRes updateById(ApsBomGroupUpdateByIdReq req);
}

