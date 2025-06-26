package com.olivia.peanut.aps.service.impl;

import org.springframework.aop.framework.AopContext;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import jakarta.annotation.Resource;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.LambdaQueryUtil;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.olivia.peanut.aps.mapper.ApsOrderGoodsBomKittingVersionOrderItemMapper;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
import com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderItemConverter;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderItemService;
import cn.hutool.core.collection.CollUtil;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 20:30:06
 */
@Service("apsOrderGoodsBomKittingVersionOrderItemService")
@Transactional
public class ApsOrderGoodsBomKittingVersionOrderItemServiceImpl extends
    MPJBaseServiceImpl<ApsOrderGoodsBomKittingVersionOrderItemMapper, ApsOrderGoodsBomKittingVersionOrderItem> implements
    ApsOrderGoodsBomKittingVersionOrderItemService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderGoodsBomKittingVersionOrderItemQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderItemQueryListReq req) {

    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrderItem> list = this.list(q);

    List<ApsOrderGoodsBomKittingVersionOrderItemDto> dataList = ApsOrderGoodsBomKittingVersionOrderItemConverter.INSTANCE.queryListRes(
        list);
    ((ApsOrderGoodsBomKittingVersionOrderItemService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderItemQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req) {

    DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItem> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderGoodsBomKittingVersionOrderItem> list = this.page(page, q);
      IPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderGoodsBomKittingVersionOrderItemConverter.INSTANCE.queryPageListRes(
          this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderGoodsBomKittingVersionOrderItemService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderGoodsBomKittingVersionOrderItemDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem> getWrapper(
      ApsOrderGoodsBomKittingVersionOrderItemDto obj) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderGoodsBomKittingVersionOrderItem.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsOrderGoodsBomKittingVersionOrderItem::getKittingVersionId // 齐套版本id
        , ApsOrderGoodsBomKittingVersionOrderItem::getOrderId // 订单ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getOrderNo // 订单ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getOrderMakeBeginDateTime // 开始制造时间
        , ApsOrderGoodsBomKittingVersionOrderItem::getGoodsId // 商品ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getGoodsName // 商品名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getWorkshopSectionId // 工段Id
        , ApsOrderGoodsBomKittingVersionOrderItem::getWorkshopSectionName // 工段名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getWorkshopStationId // 工位ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getWorkshopStationName // 工位名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getApsRoomId // 车间ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getApsRoomName // 车间名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getBomId // 零件ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getBomName // 零件名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getBomUsage // 单个商品用量
        , ApsOrderGoodsBomKittingVersionOrderItem::getInventoryBeforeCount // 库存使用前数量
        , ApsOrderGoodsBomKittingVersionOrderItem::getInventoryAfterCount // 库存使用后数量
        , ApsOrderGoodsBomKittingVersionOrderItem::getGoodsStatusId // 状态ID
        , ApsOrderGoodsBomKittingVersionOrderItem::getGoodsStatusName // 状态名称
        , ApsOrderGoodsBomKittingVersionOrderItem::getBomUseDateTime // 零件使用时间
        , ApsOrderGoodsBomKittingVersionOrderItem::getCreateDate // 计算日期
        , ApsOrderGoodsBomKittingVersionOrderItem::getFactoryId // 工厂ID
    );

    q.orderByAsc(ApsOrderGoodsBomKittingVersionOrderItem::getIsEnough);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItem> page) {

    tableHeaderService.listByBizKey(page,
        "ApsOrderGoodsBomKittingVersionOrderItemService#queryPageList");

  }


}

