package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;
import com.olivia.peanut.aps.converter.ApsSchedulingVersionItemPreConverter;
import com.olivia.peanut.aps.mapper.ApsSchedulingVersionItemPreMapper;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import com.olivia.peanut.aps.service.ApsSchedulingVersionItemPreService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.LambdaQueryUtil;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)表服务实现类
 *
 * @author makejava
 * @since 2025-04-06 14:16:41
 */
@Service("apsSchedulingVersionItemPreService")
@Transactional
public class ApsSchedulingVersionItemPreServiceImpl extends MPJBaseServiceImpl<ApsSchedulingVersionItemPreMapper, ApsSchedulingVersionItemPre> implements
    ApsSchedulingVersionItemPreService {


  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsSchedulingVersionItemPreQueryListRes queryList(ApsSchedulingVersionItemPreQueryListReq req) {

    MPJLambdaWrapper<ApsSchedulingVersionItemPre> q = getWrapper(req.getData());
    List<ApsSchedulingVersionItemPre> list = this.list(q);

    List<ApsSchedulingVersionItemPreDto> dataList = ApsSchedulingVersionItemPreConverter.INSTANCE.queryListRes(list);
    ((ApsSchedulingVersionItemPreService) AopContext.currentProxy()).setName(dataList);
    return new ApsSchedulingVersionItemPreQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageList(ApsSchedulingVersionItemPreExportQueryPageListReq req) {

    DynamicsPage<ApsSchedulingVersionItemPre> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsSchedulingVersionItemPre> q = getWrapper(req.getData());
    List<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsSchedulingVersionItemPre> list = this.page(page, q);
      IPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsSchedulingVersionItemPreExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsSchedulingVersionItemPreConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsSchedulingVersionItemPreService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsSchedulingVersionItemPreDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsSchedulingVersionItemPre> getWrapper(ApsSchedulingVersionItemPreDto obj) {
    MPJLambdaWrapper<ApsSchedulingVersionItemPre> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsSchedulingVersionItemPre.class
        // 查询条件
        , ApsSchedulingVersionItemPre::getSchedulingVersionId //
        , ApsSchedulingVersionItemPre::getCurrentDay //
        , ApsSchedulingVersionItemPre::getOrderId //
        , ApsSchedulingVersionItemPre::getGoodsId //
        , ApsSchedulingVersionItemPre::getNumberIndex //
        , ApsSchedulingVersionItemPre::getFactoryId //
        , ApsSchedulingVersionItemPre::getShowField //
        , ApsSchedulingVersionItemPre::getOrderNo //
    );

//    q.orderByDesc(ApsSchedulingVersionItemPre::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsSchedulingVersionItemPre> page) {

    tableHeaderService.listByBizKey(page, "ApsSchedulingVersionItemPreService#queryPageList");

  }


}

