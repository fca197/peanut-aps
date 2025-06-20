package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.ApsSchedulingDayConfigVersionDetailMachineUseTimeDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.ApsSchedulingDayConfigVersionDetailMachineUseTimeExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.ApsSchedulingDayConfigVersionDetailMachineUseTimeExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.ApsSchedulingDayConfigVersionDetailMachineUseTimeQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.ApsSchedulingDayConfigVersionDetailMachineUseTimeQueryListRes;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachineUseTime;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 排程结果机器使用率(ApsSchedulingDayConfigVersionDetailMachineUseTime)表服务接口
 *
 * @author makejava
 * @since 2024-11-11 15:21:49
 */
public interface ApsSchedulingDayConfigVersionDetailMachineUseTimeService extends
    MPJBaseService<ApsSchedulingDayConfigVersionDetailMachineUseTime> {

  ApsSchedulingDayConfigVersionDetailMachineUseTimeQueryListRes queryList(
      ApsSchedulingDayConfigVersionDetailMachineUseTimeQueryListReq req);

  DynamicsPage<ApsSchedulingDayConfigVersionDetailMachineUseTimeExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingDayConfigVersionDetailMachineUseTimeExportQueryPageListReq req);


  void setName(
      List<? extends ApsSchedulingDayConfigVersionDetailMachineUseTimeDto> apsSchedulingDayConfigVersionDetailMachineUseTimeDtoList);
}

