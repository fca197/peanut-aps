package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;

import java.util.List;

import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)表服务接口
 *
 * @author makejava
 * @since 2025-04-06 14:16:40
 */
public interface ApsSchedulingVersionItemPreService extends MPJBaseService<ApsSchedulingVersionItemPre> {
  ApsSchedulingVersionItemPreQueryListRes queryList(ApsSchedulingVersionItemPreQueryListReq req);

  DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageList(ApsSchedulingVersionItemPreExportQueryPageListReq req);


  void setName(List<? extends ApsSchedulingVersionItemPreDto> apsSchedulingVersionItemPreDtoList);
}

