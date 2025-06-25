package com.olivia.peanut.aps.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import java.util.List;
import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)表服务接口
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
public interface ApsOrderGoodsBomKittingVersionService extends
    MPJBaseService<ApsOrderGoodsBomKittingVersion> {

  ApsOrderGoodsBomKittingVersionQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionQueryListReq req);

  DynamicsPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionExportQueryPageListReq req);


  void setName(
      List<? extends ApsOrderGoodsBomKittingVersionDto> apsOrderGoodsBomKittingVersionDtoList);
}

