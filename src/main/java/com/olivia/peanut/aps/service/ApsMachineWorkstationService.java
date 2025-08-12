package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表服务接口
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
public interface ApsMachineWorkstationService extends MPJBaseService<ApsMachineWorkstation> {

  ApsMachineWorkstationQueryListRes queryList(ApsMachineWorkstationQueryListReq req);

  DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(ApsMachineWorkstationExportQueryPageListReq req);


  void setName(List<? extends ApsMachineWorkstationDto> apsMachineWorkstationDtoList);

  Long save(ApsMachineWorkstationInsertReq req);

  void updateById(ApsMachineWorkstationUpdateByIdReq req);
}

