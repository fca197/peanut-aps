package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionQueryListRes;
import com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionConverter;
import com.olivia.peanut.aps.mapper.ApsOrderGoodsBomKittingVersionMapper;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.LambdaQueryUtil;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 10:13:08
 */
@Service("apsOrderGoodsBomKittingVersionService")
@Transactional
public class ApsOrderGoodsBomKittingVersionServiceImpl extends
    MPJBaseServiceImpl<ApsOrderGoodsBomKittingVersionMapper, ApsOrderGoodsBomKittingVersion> implements
    ApsOrderGoodsBomKittingVersionService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderGoodsBomKittingVersionQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionQueryListReq req) {

    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersion> list = this.list(q);

    List<ApsOrderGoodsBomKittingVersionDto> dataList = ApsOrderGoodsBomKittingVersionConverter.INSTANCE.queryListRes(
        list);
    ((ApsOrderGoodsBomKittingVersionService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderGoodsBomKittingVersionQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionExportQueryPageListReq req) {

    DynamicsPage<ApsOrderGoodsBomKittingVersion> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderGoodsBomKittingVersion> list = this.page(page, q);
      IPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderGoodsBomKittingVersionConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderGoodsBomKittingVersionService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderGoodsBomKittingVersionDto> list) {

    setNameService.setName(list, SetNamePojoUtils.FACTORY
        //    , SetNamePojoUtils.OP_USER_NAME
    );

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion> getWrapper(
      ApsOrderGoodsBomKittingVersionDto obj) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderGoodsBomKittingVersion.class,
        BaseEntity::getId,
        // 查询条件
        ApsOrderGoodsBomKittingVersion::getKittingVersionNo,
        ApsOrderGoodsBomKittingVersion::getKittingVersionName
        , ApsOrderGoodsBomKittingVersion::getCreateDate //
        , ApsOrderGoodsBomKittingVersion::getFactoryId //
    );

    q.orderByDesc(ApsOrderGoodsBomKittingVersion::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderGoodsBomKittingVersion> page) {

    tableHeaderService.listByBizKey(page, "ApsOrderGoodsBomKittingVersionService#queryPageList");

  }


}

