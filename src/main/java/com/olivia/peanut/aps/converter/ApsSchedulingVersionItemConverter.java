package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItem.ApsSchedulingVersionItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingVersionItemConverter {

  ApsSchedulingVersionItemConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingVersionItemConverter.class);

  ApsSchedulingVersionItem insertReq(ApsSchedulingVersionItemInsertReq req);

  ApsSchedulingVersionItem updateReq(ApsSchedulingVersionItemUpdateByIdReq req);

  List<ApsSchedulingVersionItemDto> queryListRes(List<ApsSchedulingVersionItem> list);

  List<ApsSchedulingVersionItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingVersionItem> list);

  List<ApsSchedulingVersionItem> importReq(List<ApsSchedulingVersionItemImportReq> reqList);
}

