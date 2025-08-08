package com.olivia.peanut.aps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.*;
import com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderConverter;
import com.olivia.peanut.aps.mapper.ApsOrderGoodsBomKittingVersionOrderMapper;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrder;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderService;
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
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 14:23:49
 */
@Service("apsOrderGoodsBomKittingVersionOrderService")
@Transactional
public class ApsOrderGoodsBomKittingVersionOrderServiceImpl extends
    MPJBaseServiceImpl<ApsOrderGoodsBomKittingVersionOrderMapper, ApsOrderGoodsBomKittingVersionOrder> implements
    ApsOrderGoodsBomKittingVersionOrderService {


  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderGoodsBomKittingVersionOrderQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderQueryListReq req) {

    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrder> list = this.list(q);

    List<ApsOrderGoodsBomKittingVersionOrderDto> dataList = ApsOrderGoodsBomKittingVersionOrderConverter.INSTANCE.queryListRes(
        list);
    ((ApsOrderGoodsBomKittingVersionOrderService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req) {

    DynamicsPage<ApsOrderGoodsBomKittingVersionOrder> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderGoodsBomKittingVersionOrder> list = this.page(page, q);
      IPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderGoodsBomKittingVersionOrderConverter.INSTANCE.queryPageListRes(
          this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderGoodsBomKittingVersionOrderService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderGoodsBomKittingVersionOrderDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder> getWrapper(
      ApsOrderGoodsBomKittingVersionOrderDto obj) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderGoodsBomKittingVersionOrder.class
        // 查询条件
        , ApsOrderGoodsBomKittingVersionOrder::getKittingVersionId //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderId //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderNo //
        , ApsOrderGoodsBomKittingVersionOrder::getKittingRate //
        , ApsOrderGoodsBomKittingVersionOrder::getKittingStatus //
        , ApsOrderGoodsBomKittingVersionOrder::getKittingMissingBom //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField01 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField02 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField03 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField04 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField05 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField06 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField07 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField08 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField09 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField10 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField11 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField12 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField13 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField14 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField15 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField16 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField17 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField18 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField19 //
        , ApsOrderGoodsBomKittingVersionOrder::getOrderField20 //
        , ApsOrderGoodsBomKittingVersionOrder::getFactoryId //
    );
    q.orderByAsc(ApsOrderGoodsBomKittingVersionOrder::getNumberIndex);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderGoodsBomKittingVersionOrder> page) {

    tableHeaderService.listByBizKey(page,
        "ApsOrderGoodsBomKittingVersionOrderService#queryPageList");

  }


}

