package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.*;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMachineWorkstationConverter {

  ApsMachineWorkstationConverter INSTANCE = Mappers.getMapper(ApsMachineWorkstationConverter.class);

  ApsMachineWorkstation insertReq(ApsMachineWorkstationInsertReq req);

  ApsMachineWorkstation updateReq(ApsMachineWorkstationUpdateByIdReq req);

  List<ApsMachineWorkstationDto> queryListRes(List<ApsMachineWorkstation> list);

  List<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageListRes(List<ApsMachineWorkstation> list);

  List<ApsMachineWorkstation> importReq(List<ApsMachineWorkstationImportReq> reqList);
}

