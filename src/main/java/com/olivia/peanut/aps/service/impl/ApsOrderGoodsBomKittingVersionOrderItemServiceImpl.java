package com.olivia.peanut.aps.service.impl;

import com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderBomConverter;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderBom;
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
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.olivia.peanut.aps.mapper.ApsOrderGoodsBomKittingVersionOrderItemMapper;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderItemService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.*;
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
    MPJBaseServiceImpl<ApsOrderGoodsBomKittingVersionOrderItemMapper, ApsOrderGoodsBomKittingVersionOrderBom> implements
    ApsOrderGoodsBomKittingVersionOrderItemService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override ApsOrderGoodsBomKittingVersionOrderBomQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderBomQueryListReq req) {

    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrderBom> list = this.list(q);

    List<ApsOrderGoodsBomKittingVersionOrderBomDto> dataList = ApsOrderGoodsBomKittingVersionOrderBomConverter.INSTANCE.queryListRes(
        list);
    ((ApsOrderGoodsBomKittingVersionOrderItemService) AopContext.currentProxy()).setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderBomQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req) {

    DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBom> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom> q = getWrapper(req.getData());
    List<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrderGoodsBomKittingVersionOrderBom> list = this.page(page, q);
      IPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = ApsOrderGoodsBomKittingVersionOrderBomConverter.INSTANCE.queryPageListRes(
          this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((ApsOrderGoodsBomKittingVersionOrderItemService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends ApsOrderGoodsBomKittingVersionOrderBomDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom> getWrapper(
      ApsOrderGoodsBomKittingVersionOrderBomDto obj) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrderGoodsBomKittingVersionOrderBom.class
        // 查询条件
        , BaseEntity::getId // id
        , ApsOrderGoodsBomKittingVersionOrderBom::getKittingVersionId // 齐套版本id
        , ApsOrderGoodsBomKittingVersionOrderBom::getOrderId // 订单ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getOrderNo // 订单ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getOrderMakeBeginDateTime // 开始制造时间
        , ApsOrderGoodsBomKittingVersionOrderBom::getGoodsId // 商品ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getGoodsName // 商品名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getWorkshopSectionId // 工段Id
        , ApsOrderGoodsBomKittingVersionOrderBom::getWorkshopSectionName // 工段名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getWorkshopStationId // 工位ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getWorkshopStationName // 工位名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getApsRoomId // 车间ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getApsRoomName // 车间名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getBomId // 零件ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getBomName // 零件名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getBomUsage // 单个商品用量
        , ApsOrderGoodsBomKittingVersionOrderBom::getInventoryBeforeCount // 库存使用前数量
        , ApsOrderGoodsBomKittingVersionOrderBom::getInventoryAfterCount // 库存使用后数量
        , ApsOrderGoodsBomKittingVersionOrderBom::getGoodsStatusId // 状态ID
        , ApsOrderGoodsBomKittingVersionOrderBom::getGoodsStatusName // 状态名称
        , ApsOrderGoodsBomKittingVersionOrderBom::getBomUseDateTime // 零件使用时间
        , ApsOrderGoodsBomKittingVersionOrderBom::getCreateDate // 计算日期
        , ApsOrderGoodsBomKittingVersionOrderBom::getFactoryId // 工厂ID
    );
    q.orderByAsc(ApsOrderGoodsBomKittingVersionOrderBom::getIsEnough);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBom> page) {

    tableHeaderService.listByBizKey(page,
        "ApsOrderGoodsBomKittingVersionOrderItemService#queryPageList");

  }


}

