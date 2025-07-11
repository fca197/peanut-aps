package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.ApsGoodsForecastUserGoodsDataDto;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.ApsGoodsForecastUserGoodsDataExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.ApsGoodsForecastUserGoodsDataQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserGoodsData.ApsGoodsForecastUserGoodsDataQueryListRes;
import com.olivia.peanut.aps.mapper.ApsGoodsForecastUserGoodsDataMapper;
import com.olivia.peanut.aps.model.ApsGoodsForecastUserGoodsData;
import com.olivia.peanut.aps.service.ApsGoodsForecastUserGoodsDataService;
import com.olivia.sdk.ann.SetUserName;
import com.olivia.sdk.comment.ServiceComment;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (ApsGoodsForecastUserGoodsData)表服务实现类
 *
 * @author peanut
 * @since 2024-03-30 18:29:07
 */
@Service("apsGoodsForecastUserGoodsDataService")
@Transactional
public class ApsGoodsForecastUserGoodsDataServiceImpl extends
    MPJBaseServiceImpl<ApsGoodsForecastUserGoodsDataMapper, ApsGoodsForecastUserGoodsData> implements
    ApsGoodsForecastUserGoodsDataService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();


  public @Override ApsGoodsForecastUserGoodsDataQueryListRes queryList(
      ApsGoodsForecastUserGoodsDataQueryListReq req) {

    MPJLambdaWrapper<ApsGoodsForecastUserGoodsData> q = getWrapper(req.getData());
    List<ApsGoodsForecastUserGoodsData> list = this.list(q);

    List<ApsGoodsForecastUserGoodsDataDto> dataList = list.stream()
        .map(t -> $.copy(t, ApsGoodsForecastUserGoodsDataDto.class)).collect(Collectors.toList());

    return new ApsGoodsForecastUserGoodsDataQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastUserGoodsDataExportQueryPageListReq req) {

    DynamicsPage<ApsGoodsForecastUserGoodsData> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsGoodsForecastUserGoodsData> q = getWrapper(req.getData());
    List<ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsGoodsForecastUserGoodsData> list = this.page(page, q);
      IPage<ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = $.copyList(this.list(q),
          ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes.class);
    }

    // 类型转换，  更换枚举 等操作

    List<ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes> listInfoRes = $.copyList(records,
        ApsGoodsForecastUserGoodsDataExportQueryPageListInfoRes.class);

    return DynamicsPage.init(page, listInfoRes);
  }


  @SetUserName
  public @Override void setName(
      List<? extends ApsGoodsForecastUserGoodsDataDto> apsGoodsForecastUserGoodsDataDtoList) {

  }

  // 以下为私有对象封装


  private MPJLambdaWrapper<ApsGoodsForecastUserGoodsData> getWrapper(
      ApsGoodsForecastUserGoodsDataDto obj) {
    MPJLambdaWrapper<ApsGoodsForecastUserGoodsData> q = new MPJLambdaWrapper<>();

    if (Objects.nonNull(obj)) {
      q
          .eq(Objects.nonNull(obj.getForecastId()), ApsGoodsForecastUserGoodsData::getForecastId,
              obj.getForecastId())
          .eq(Objects.nonNull(obj.getYear()), ApsGoodsForecastUserGoodsData::getYear, obj.getYear())

      ;
    }
    q.orderByDesc(ApsGoodsForecastUserGoodsData::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsGoodsForecastUserGoodsData> page) {

    ServiceComment.header(page, "ApsGoodsForecastUserGoodsDataService#queryPageList");

  }


}

