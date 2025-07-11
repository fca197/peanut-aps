package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemImportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsSchedulingIssueItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingIssueItemConverter {

  ApsSchedulingIssueItemConverter INSTANCE = Mappers.getMapper(
      ApsSchedulingIssueItemConverter.class);

  ApsSchedulingIssueItem insertReq(ApsSchedulingIssueItemInsertReq req);

  ApsSchedulingIssueItem updateReq(ApsSchedulingIssueItemUpdateByIdReq req);

  List<ApsSchedulingIssueItemDto> queryListRes(List<ApsSchedulingIssueItem> list);

  List<ApsSchedulingIssueItemExportQueryPageListInfoRes> queryPageListRes(
      List<ApsSchedulingIssueItem> list);

  List<ApsSchedulingIssueItem> importReq(List<ApsSchedulingIssueItemImportReq> reqList);
}

