package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.*;
import com.olivia.peanut.aps.model.ApsSchedulingIssueItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsSchedulingIssueItemConverter {
  ApsSchedulingIssueItemConverter INSTANCE = Mappers.getMapper(ApsSchedulingIssueItemConverter.class);

  ApsSchedulingIssueItem insertReq(ApsSchedulingIssueItemInsertReq req);

  ApsSchedulingIssueItem updateReq(ApsSchedulingIssueItemUpdateByIdReq req);

  List<ApsSchedulingIssueItemDto> queryListRes(List<ApsSchedulingIssueItem> list);

  List<ApsSchedulingIssueItemExportQueryPageListInfoRes> queryPageListRes(List<ApsSchedulingIssueItem> list);

  List<ApsSchedulingIssueItem> importReq(List<ApsSchedulingIssueItemImportReq> reqList);
}

