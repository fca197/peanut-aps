package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMachineWorkstationConverter {

  ApsMachineWorkstationConverter INSTANCE = Mappers.getMapper(ApsMachineWorkstationConverter.class);

  ApsMachineWorkstation insertReq(ApsMachineWorkstationInsertReq req);

  ApsMachineWorkstation updateReq(ApsMachineWorkstationUpdateByIdReq req);

  List<ApsMachineWorkstationDto> queryListRes(List<ApsMachineWorkstation> list);

  List<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageListRes(
      List<ApsMachineWorkstation> list);

  List<ApsMachineWorkstation> importReq(List<ApsMachineWorkstationImportReq> reqList);
}

