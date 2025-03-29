package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.*;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachine;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailMachineConverter {
  ApsSchedulingDayConfigVersionDetailMachineConverter INSTANCE = Mappers.getMapper(ApsSchedulingDayConfigVersionDetailMachineConverter.class);

  ApsSchedulingDayConfigVersionDetailMachine insertReq(ApsSchedulingDayConfigVersionDetailMachineInsertReq req);

  ApsSchedulingDayConfigVersionDetailMachine updateReq(ApsSchedulingDayConfigVersionDetailMachineUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailMachineDto> queryListRes(List<ApsSchedulingDayConfigVersionDetailMachine> list);

  List<ApsSchedulingDayConfigVersionDetailMachineExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingDayConfigVersionDetailMachine> list);

  List<ApsSchedulingDayConfigVersionDetailMachine> importReq(List<ApsSchedulingDayConfigVersionDetailMachineImportReq> reqList);
}

