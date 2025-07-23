package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表服务接口
 *
 * @author admin
 * @since 2025-07-23 13:20:06
 */
public interface ApsMachineWorkstationService extends MPJBaseService<ApsMachineWorkstation> {

  ApsMachineWorkstationQueryListRes queryList(ApsMachineWorkstationQueryListReq req);

  DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationExportQueryPageListReq req);


  void setName(List<? extends ApsMachineWorkstationDto> apsMachineWorkstationDtoList);
}

