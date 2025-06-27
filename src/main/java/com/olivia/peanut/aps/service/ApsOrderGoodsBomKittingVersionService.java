package com.olivia.peanut.aps.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.CreateSchedulingKittingVersion;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)表服务接口
 *
 * @author admin
 *
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

  ApsOrderGoodsBomKittingVersionInsertRes createSchedulingKittingVersion(
      CreateSchedulingKittingVersion req);
}

