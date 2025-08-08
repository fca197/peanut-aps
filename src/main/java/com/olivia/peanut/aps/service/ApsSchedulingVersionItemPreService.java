package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)表服务接口
 *
 * @author makejava
 * @since 2025-04-06 14:16:40
 */
public interface ApsSchedulingVersionItemPreService extends MPJBaseService<ApsSchedulingVersionItemPre> {

  ApsSchedulingVersionItemPreQueryListRes queryList(ApsSchedulingVersionItemPreQueryListReq req);

  DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingVersionItemPreExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingVersionItemPreDto> apsSchedulingVersionItemPreDtoList);
}

