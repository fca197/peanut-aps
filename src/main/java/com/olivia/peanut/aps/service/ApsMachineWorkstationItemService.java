package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)表服务接口
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
public interface ApsMachineWorkstationItemService extends
    MPJBaseService<ApsMachineWorkstationItem> {

  ApsMachineWorkstationItemQueryListRes queryList(ApsMachineWorkstationItemQueryListReq req);

  DynamicsPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationItemExportQueryPageListReq req);


  void setName(List<? extends ApsMachineWorkstationItemDto> apsMachineWorkstationItemDtoList);
}

