package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.ApsSchedulingDayConfigVersionDetailMachineDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.ApsSchedulingDayConfigVersionDetailMachineExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.ApsSchedulingDayConfigVersionDetailMachineImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.ApsSchedulingDayConfigVersionDetailMachineInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersionDetailMachine.ApsSchedulingDayConfigVersionDetailMachineUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachine;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingDayConfigVersionDetailMachineConverter {

  ApsSchedulingDayConfigVersionDetailMachineConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingDayConfigVersionDetailMachineConverter.class);

  ApsSchedulingDayConfigVersionDetailMachine insertReq(
      ApsSchedulingDayConfigVersionDetailMachineInsertReq req);

  ApsSchedulingDayConfigVersionDetailMachine updateReq(
      ApsSchedulingDayConfigVersionDetailMachineUpdateByIdReq req);

  List<ApsSchedulingDayConfigVersionDetailMachineDto> queryListRes(
      List<ApsSchedulingDayConfigVersionDetailMachine> list);

  List<ApsSchedulingDayConfigVersionDetailMachineExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingDayConfigVersionDetailMachine> list);

  List<ApsSchedulingDayConfigVersionDetailMachine> importReq(
      List<ApsSchedulingDayConfigVersionDetailMachineImportReq> reqList);
}

