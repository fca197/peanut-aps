package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachineUseTime.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachineUseTime;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailMachineUseTimeConverter {
  ApsSchedulingDayConfigVersionDetailMachineUseTimeConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigVersionDetailMachineUseTimeConverter.class);

  ApsSchedulingDayConfigVersionDetailMachineUseTime insertReq(ApsSchedulingDayConfigVersionDetailMachineUseTimeInsertReq req);

  ApsSchedulingDayConfigVersionDetailMachineUseTime updateReq(ApsSchedulingDayConfigVersionDetailMachineUseTimeUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailMachineUseTimeDto> queryListRes(List<ApsSchedulingDayConfigVersionDetailMachineUseTime> list);

  List<ApsSchedulingDayConfigVersionDetailMachineUseTimeExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigVersionDetailMachineUseTime> list);

  List<ApsSchedulingDayConfigVersionDetailMachineUseTime> importReq(List<ApsSchedulingDayConfigVersionDetailMachineUseTimeImportReq> reqList);
}

