package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMachine.ApsMachineDto;
import com.olivia.peanut.aps.api.entity.apsMachine.ApsMachineExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMachine.ApsMachineImportReq;
import com.olivia.peanut.aps.api.entity.apsMachine.ApsMachineInsertReq;
import com.olivia.peanut.aps.api.entity.apsMachine.ApsMachineUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsMachine;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMachineConverter {

  ApsMachineConverter INSTANCE = Mappers.getMapper(ApsMachineConverter.class);

  ApsMachine insertReq(ApsMachineInsertReq req);

  ApsMachine updateReq(ApsMachineUpdateByIdReq req);

  List<ApsMachineDto> queryListRes(List<ApsMachine> list);

  List<ApsMachineExportQueryPageListInfoRes> queryPageListRes(List<ApsMachine> list);

  List<ApsMachine> importReq(List<ApsMachineImportReq> reqList);
}

