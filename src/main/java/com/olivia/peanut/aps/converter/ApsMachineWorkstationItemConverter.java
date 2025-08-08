package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMachineWorkstationItemConverter {

  ApsMachineWorkstationItemConverter INSTANCE = Mappers.getMapper(ApsMachineWorkstationItemConverter.class);

  ApsMachineWorkstationItem insertReq(ApsMachineWorkstationItemInsertReq req);

  ApsMachineWorkstationItem dto2Entity(ApsMachineWorkstationItemDto req);

  ApsMachineWorkstationItem updateReq(ApsMachineWorkstationItemUpdateByIdReq req);

  List<ApsMachineWorkstationItemDto> queryListRes(List<ApsMachineWorkstationItem> list);

  List<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageListRes(List<ApsMachineWorkstationItem> list);

  List<ApsMachineWorkstationItem> importReq(List<ApsMachineWorkstationItemImportReq> reqList);
}

