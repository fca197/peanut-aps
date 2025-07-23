package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsMachineWorkstationItemConverter {

  ApsMachineWorkstationItemConverter INSTANCE = Mappers.getMapper(
      ApsMachineWorkstationItemConverter.class);

  ApsMachineWorkstationItem insertReq(ApsMachineWorkstationItemInsertReq req);

  ApsMachineWorkstationItem updateReq(ApsMachineWorkstationItemUpdateByIdReq req);

  List<ApsMachineWorkstationItemDto> queryListRes(List<ApsMachineWorkstationItem> list);

  List<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsMachineWorkstationItem> list);

  List<ApsMachineWorkstationItem> importReq(List<ApsMachineWorkstationItemImportReq> reqList);
}

