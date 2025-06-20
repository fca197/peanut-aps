package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.ApsOrderGoodsHistoryDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.ApsOrderGoodsHistoryExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.ApsOrderGoodsHistoryExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.ApsOrderGoodsHistoryQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsHistory.ApsOrderGoodsHistoryQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleHistory.SelectOrder2HistoryReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleHistory.SelectOrder2HistoryRes;
import com.olivia.peanut.aps.model.ApsOrderGoodsHistory;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 历史订单记录(ApsOrderGoodsHistory)表服务接口
 *
 * @author makejava
 * @since 2025-02-20 17:18:46
 */
public interface ApsOrderGoodsHistoryService extends MPJBaseService<ApsOrderGoodsHistory> {

  ApsOrderGoodsHistoryQueryListRes queryList(ApsOrderGoodsHistoryQueryListReq req);

  DynamicsPage<ApsOrderGoodsHistoryExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsHistoryExportQueryPageListReq req);


  void setName(List<? extends ApsOrderGoodsHistoryDto> apsOrderGoodsHistoryDtoList);

  SelectOrder2HistoryRes selectOrder2History(SelectOrder2HistoryReq req);
}

