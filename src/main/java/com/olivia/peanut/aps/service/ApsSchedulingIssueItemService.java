package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.ApsSchedulingIssueItemQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.QueryDayCountReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingIssueItem.QueryDayCountRes;
import com.olivia.peanut.aps.model.ApsSchedulingIssueItem;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 排产下发详情(ApsSchedulingIssueItem)表服务接口
 *
 * @author peanut
 * @since 2024-07-20 13:55:55
 */
public interface ApsSchedulingIssueItemService extends MPJBaseService<ApsSchedulingIssueItem> {

  ApsSchedulingIssueItemQueryListRes queryList(ApsSchedulingIssueItemQueryListReq req);

  DynamicsPage<ApsSchedulingIssueItemExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingIssueItemExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingIssueItemDto> apsSchedulingIssueItemDtoList);

  ApsSchedulingIssueItemInsertRes save(ApsSchedulingIssueItemInsertReq req);

  QueryDayCountRes queryDayCount(QueryDayCountReq req);
}

