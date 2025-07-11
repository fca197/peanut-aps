package com.olivia.peanut.aps.service.impl;

import static com.olivia.peanut.aps.enums.ApsSchedulingDayConfigVersionProductType.MAKE;
import static com.olivia.peanut.aps.enums.ApsSchedulingDayConfigVersionProductType.PROCESS;
import static com.olivia.sdk.utils.FieldUtils.getFieldValue;
import static com.olivia.sdk.utils.JSON.toJSONString;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderStatusEnum;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfig.ApsSchedulingDayConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigItem.ApsSchedulingDayConfigItemDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionAddOrderTypeEnum;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDetailListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionDto;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionOrderExportReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingDayConfigVersion.CanSchedulingOrderListRes;
import com.olivia.peanut.aps.converter.ApsSchedulingDayConfigVersionConverter;
import com.olivia.peanut.aps.mapper.ApsSchedulingDayConfigVersionMapper;
import com.olivia.peanut.aps.model.ApsGoods;
import com.olivia.peanut.aps.model.ApsOrder;
import com.olivia.peanut.aps.model.ApsOrderGoods;
import com.olivia.peanut.aps.model.ApsOrderGoodsBom;
import com.olivia.peanut.aps.model.ApsOrderGoodsProjectConfig;
import com.olivia.peanut.aps.model.ApsOrderGoodsSaleConfig;
import com.olivia.peanut.aps.model.ApsProduceProcess;
import com.olivia.peanut.aps.model.ApsProduceProcessItem;
import com.olivia.peanut.aps.model.ApsRoom;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfig;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersion;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetail;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachine;
import com.olivia.peanut.aps.model.ApsSchedulingDayConfigVersionDetailMachineUseTime;
import com.olivia.peanut.aps.model.ApsSchedulingIssueItem;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import com.olivia.peanut.aps.model.ApsStatus;
import com.olivia.peanut.aps.service.ApsFactoryService;
import com.olivia.peanut.aps.service.ApsGoodsService;
import com.olivia.peanut.aps.service.ApsOrderFieldService;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomService;
import com.olivia.peanut.aps.service.ApsOrderGoodsProjectConfigService;
import com.olivia.peanut.aps.service.ApsOrderGoodsSaleConfigService;
import com.olivia.peanut.aps.service.ApsOrderService;
import com.olivia.peanut.aps.service.ApsOrderUserService;
import com.olivia.peanut.aps.service.ApsProcessPathService;
import com.olivia.peanut.aps.service.ApsProduceProcessItemService;
import com.olivia.peanut.aps.service.ApsProduceProcessService;
import com.olivia.peanut.aps.service.ApsRoomService;
import com.olivia.peanut.aps.service.ApsSaleConfigService;
import com.olivia.peanut.aps.service.ApsSchedulingDayConfigService;
import com.olivia.peanut.aps.service.ApsSchedulingDayConfigVersionDetailMachineService;
import com.olivia.peanut.aps.service.ApsSchedulingDayConfigVersionDetailMachineUseTimeService;
import com.olivia.peanut.aps.service.ApsSchedulingDayConfigVersionDetailService;
import com.olivia.peanut.aps.service.ApsSchedulingDayConfigVersionService;
import com.olivia.peanut.aps.service.ApsSchedulingVersionItemPreService;
import com.olivia.peanut.aps.service.ApsStatusService;
import com.olivia.peanut.aps.service.pojo.FactoryConfigReq;
import com.olivia.peanut.aps.service.pojo.FactoryConfigRes;
import com.olivia.peanut.aps.utils.process.ProduceProcessUtils;
import com.olivia.peanut.aps.utils.process.entity.ProduceOrder;
import com.olivia.peanut.aps.utils.process.entity.ProduceOrderMachine;
import com.olivia.peanut.aps.utils.process.entity.ProduceProcessComputeOrderRes;
import com.olivia.peanut.aps.utils.process.entity.ProduceProcessComputeReq;
import com.olivia.peanut.aps.utils.process.entity.ProduceProcessComputeRes;
import com.olivia.peanut.aps.utils.scheduling.ApsSchedulingDayUtils;
import com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingDayConfigItemConfigBizTypeEnum;
import com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingDayConfigVersionDetailDto;
import com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingDayOrderRoomReq;
import com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingIssueItemDto;
import com.olivia.peanut.base.model.Factory;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.peanut.base.service.FactoryService;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.ann.RedissonLockAnn;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.mybatis.type.model.MapSub;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.DynamicsPage.Header;
import com.olivia.sdk.utils.EasyExcelUtilExportMultipleData;
import com.olivia.sdk.utils.JSON;
import com.olivia.sdk.utils.PoiExcelUtil;
import com.olivia.sdk.utils.RunUtils;
import com.olivia.sdk.utils.Str;
import com.olivia.sdk.utils.model.AsyncRunAndTry;
import jakarta.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 排程版本(ApsSchedulingDayConfigVersion)表服务实现类
 *
 * @author peanut
 * @since 2024-07-19 19:19:55
 */
@Service("apsSchedulingDayConfigVersionService")
@Transactional
@Slf4j
public class ApsSchedulingDayConfigVersionServiceImpl extends
    MPJBaseServiceImpl<ApsSchedulingDayConfigVersionMapper, ApsSchedulingDayConfigVersion> implements
    ApsSchedulingDayConfigVersionService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100)
      .expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  ApsSchedulingIssueItemServiceImpl apsSchedulingIssueItemService;
  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;

  @Resource
  ApsSchedulingDayConfigService apsSchedulingDayConfigService;

  @Resource
  ApsSchedulingDayConfigVersionDetailService apsSchedulingDayConfigVersionDetailService;
  @Resource
  ApsRoomService apsRoomService;
  @Resource
  ApsStatusService apsStatusService;
  @Resource
  ApsOrderGoodsSaleConfigService apsOrderGoodsSaleConfigService;
  @Resource
  ApsOrderGoodsProjectConfigService apsOrderGoodsProjectConfigService;
  @Resource
  ApsOrderGoodsBomService apsOrderGoodsBomService;

  @Resource
  ApsFactoryService apsFactoryService;


  @Resource
  ApsGoodsService apsGoodsService;

  @Resource
  ApsProduceProcessService apsProduceProcessService;
  @Resource
  ApsProduceProcessItemService apsProduceProcessItemService;

  @Resource
  ApsSchedulingDayConfigVersionDetailMachineService apsSchedulingDayConfigVersionDetailMachineService;

  @Resource
  ApsSchedulingDayConfigVersionDetailMachineUseTimeService apsSchedulingDayConfigVersionDetailMachineUseTimeService;

  @Resource
  ApsSchedulingVersionItemPreService apsSchedulingVersionItemPreService;

  @Resource
  ApsOrderService apsOrderService;

  @Resource
  ApsOrderUserService apsOrderUserService;

  @Resource
  ApsSaleConfigService apsSaleConfigService;
  @Resource
  FactoryService factoryService;

  @Resource
  ApsOrderFieldService apsOrderFieldService;


  private static void itemList2PreList(List<ApsSchedulingIssueItem> itemList, long id,
      AtomicInteger atomicInteger, Boolean bool,
      List<ApsSchedulingVersionItemPre> apsSchedulingVersionItemPreList, LocalDate schedulingDate) {
    itemList.forEach(item -> {
      ApsSchedulingVersionItemPre itemPre = new ApsSchedulingVersionItemPre().setOldScheduleDate(
          item.getCurrentDay());
      itemPre.setSchedulingVersionId(id).setCurrentDay(schedulingDate).setGoodsId(item.getGoodsId())
          .setOrderNo(item.getOrderNo()).setOrderId(item.getOrderId())
          .setNumberIndex(atomicInteger.getAndIncrement()).setFactoryId(item.getFactoryId())
          .setShowField(MapSub.of()).setLegacyOrder(bool);
      apsSchedulingVersionItemPreList.add(itemPre);
    });
  }

  private static void setHeaderFormKvList(List<KVEntity> orderFieldList,
      List<EasyExcelUtilExportMultipleData.SheetHeader> headerList, String key) {
    if (CollUtil.isNotEmpty(orderFieldList)) {
      orderFieldList.forEach(t -> headerList.add(
          new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName(key + t.getValue())
              .setShowName(t.getLabel())));
    }
  }

  @Override
  @Transactional
  @RedissonLockAnn(lockPrefix = "sc:day", lockBizKeyFlag = "v", keyExpression = "#req.factoryId")
  public ApsSchedulingDayConfigVersionInsertRes save(ApsSchedulingDayConfigVersionInsertReq req) {

    ApsSchedulingDayConfigVersion dayConfigVersion = ApsSchedulingDayConfigVersionConverter.INSTANCE.insertReq(
        req);
    long id = IdWorker.getId();
    dayConfigVersion.setId(id);

    List<ApsGoods> apsGoodsList = this.apsGoodsService.list(new LambdaQueryWrapper<ApsGoods>() //
        .in(CollUtil.isNotEmpty(req.getGoodsIdList()), ApsGoods::getId, req.getGoodsIdList())
//        .in(BaseEntity::getId, issueItemList.stream().map(ApsSchedulingIssueItem::getGoodsId).collect(Collectors.toSet())) //
        .isNotNull(MAKE.equals(req.getProductType()), ApsGoods::getProduceProcessId)//
        .isNotNull(PROCESS.equals(req.getProductType()), ApsGoods::getProcessPathId));

    $.requireNonNullCanIgnoreException(apsGoodsList, "没有合适的商品进行排程");

    List<Long> apsGoodsIdList = apsGoodsList.stream().map(BaseEntity::getId).toList();

    List<ApsSchedulingIssueItem> itemList = new ArrayList<>();
    if (Boolean.TRUE.equals(req.getSearchOld())) {
      itemList.addAll(apsSchedulingIssueItemService.list(
          new MPJLambdaWrapper<ApsSchedulingIssueItem>().selectAll(ApsSchedulingIssueItem.class)
              .innerJoin(ApsOrder.class, ApsOrder::getOrderNo, ApsSchedulingIssueItem::getOrderNo)
              .innerJoin(ApsOrderGoods.class, ApsOrderGoods::getOrderId, ApsOrder::getId)
              .in(ApsOrderGoods::getGoodsId, apsGoodsIdList)
              //  订单状态下单即可排产
              .eq(ApsOrder::getOrderStatus, ApsOrderStatusEnum.INIT.getCode())
              .lt(ApsSchedulingIssueItem::getCurrentDay, req.getSchedulingDay())));
      log.info("遗留订单 {} itemList :{}", req.getSchedulingDay(), itemList.size());
    }
    List<ApsSchedulingIssueItem> issueItemList = apsSchedulingIssueItemService.list(
        new MPJLambdaWrapper<ApsSchedulingIssueItem>().selectAll(ApsSchedulingIssueItem.class)
            .eq(ApsSchedulingIssueItem::getCurrentDay, req.getSchedulingDay())
            .eq(ApsSchedulingIssueItem::getFactoryId, req.getFactoryId())
            .innerJoin(ApsOrderGoods.class, ApsOrderGoods::getOrderId, ApsOrderGoods::getOrderId)
            .in(ApsOrderGoods::getGoodsId, apsGoodsIdList));
    log.info("当天订单 {} issueItemList :{}", req.getSchedulingDay(), issueItemList.size());

    $.assertTrueCanIgnoreException(
        CollUtil.isNotEmpty(issueItemList) && CollUtil.isNotEmpty(itemList),
        "当天排产订单不能为空");

    List<ApsSchedulingVersionItemPre> apsSchedulingVersionItemPreList = new ArrayList<>();
    LocalDate nowLocalDate = LocalDate.now();
    AtomicInteger atomicInteger = new AtomicInteger(1);
    itemList2PreList(itemList, id, atomicInteger, Boolean.TRUE, apsSchedulingVersionItemPreList,
        nowLocalDate);
    itemList2PreList(issueItemList, id, atomicInteger, Boolean.FALSE,
        apsSchedulingVersionItemPreList, nowLocalDate);

    issueItemList.clear();
    itemList.clear();

    List<Long> orderIdList = apsSchedulingVersionItemPreList.stream()
        .map(ApsSchedulingVersionItemPre::getOrderId).toList();
    setOrderFieldValue(dayConfigVersion, orderIdList, apsSchedulingVersionItemPreList);
    setFactoryGoodsName(apsGoodsList, apsSchedulingVersionItemPreList);
    this.apsSchedulingVersionItemPreService.saveBatch(apsSchedulingVersionItemPreList);
    this.save(dayConfigVersion.setStepIndex(1));
    return new ApsSchedulingDayConfigVersionInsertRes().setId(dayConfigVersion.getId());
  }

  private void setOrderFieldValue(ApsSchedulingDayConfigVersion dayConfigVersion,
      List<Long> orderIdList,
      List<ApsSchedulingVersionItemPre> apsSchedulingVersionItemPreList) {
//
//    List<KVEntity> orderFieldList = dayConfigVersion.getOrderFieldList();
//    List<KVEntity> orderUserFieldList = dayConfigVersion.getOrderUserFieldList();
//    List<KVEntity> saleConfigIdList = dayConfigVersion.getSaleConfigIdList();
//
//    Map<Long, Map<String, Object>> orderedFieldMap = this.apsOrderFieldService.orderFieldSetValue(
//        orderIdList, orderUserFieldList, saleConfigIdList, Map.of());
//
//    apsSchedulingVersionItemPreList.forEach(item -> {
//      Map<String, Object> orderMap = orderedFieldMap.get(item.getOrderId());
//      if (CollUtil.isEmpty(orderMap)) {
//        return;
//      }
//      item.setShowField(MapSub.of());
//      Optional.ofNullable(orderFieldList).filter(CollUtil::isNotEmpty).ifPresent(
//          list -> list.forEach(
//              kv -> item.getShowField().put(kv.getValue(), orderMap.get(kv.getValue()))));
//      Optional.ofNullable(orderUserFieldList).filter(CollUtil::isNotEmpty).ifPresent(
//          list -> list.forEach(
//              kv -> item.getShowField().put(kv.getValue(), orderMap.get(kv.getValue()))));
//      Optional.ofNullable(saleConfigIdList).filter(CollUtil::isNotEmpty).ifPresent(
//          list -> list.forEach(kv -> item.getShowField().put("sale_" + kv.getValue() + "_name",
//              orderMap.get("sale_" + kv.getValue() + "_name"))));
//    });
  }

  private void setFactoryGoodsName(List<ApsGoods> apsGoodsList,
      List<ApsSchedulingVersionItemPre> apsSchedulingVersionItemPreList) {
    Map<Long, String> goodsNameMap = apsGoodsList.stream()
        .collect(Collectors.toMap(BaseEntity::getId, ApsGoods::getGoodsName));
    Map<Long, String> factoryNameMap = this.factoryService.list().stream()
        .collect(Collectors.toMap(Factory::getId, Factory::getFactoryName));
    apsSchedulingVersionItemPreList.forEach(t -> {
      t.setGoodsName(goodsNameMap.get(t.getGoodsId()))
          .setFactoryName(factoryNameMap.get(t.getFactoryId()));
    });
  }


  private <T extends BaseEntity> void processFieldList(List<KVEntity> fieldList,
      List<ApsSchedulingVersionItemPre> itemPreList, List<T> entityList, Class<T> entityClass,
      Function<T, Long> function, String key) {
    Map<Long, T> entityMap = entityList.stream()
        .collect(Collectors.toMap(function, Function.identity()));
    itemPreList.forEach(item -> {
      T entity = entityMap.get(item.getOrderId());
      if (Objects.isNull(entity)) {
        log.warn("{} 不存在 {}", entityClass.getSimpleName(), toJSONString(item));
        return;
      }
      fieldList.forEach(
          kv -> item.getShowField().put(key + kv.getValue(), getFieldValue(entity, kv.getValue())));
    });
  }

  @Override
  public ApsSchedulingDayConfigVersionAddOrderRes addOrder(
      ApsSchedulingDayConfigVersionAddOrderReq req) {
    List<Long> orderIdList = new ArrayList<>();
    List<ApsOrder> apsOrderList = new ArrayList<>();
    List<String> orderNoTmpList = req.getValueList().lines().toList();
    if (ApsSchedulingDayConfigVersionAddOrderTypeEnum.orderNo.equals(req.getType())) {
      apsOrderList.addAll(this.apsOrderService.list(
          new LambdaQueryWrapper<ApsOrder>().in(ApsOrder::getOrderNo, orderNoTmpList)));
      orderIdList.addAll(apsOrderList.stream().map(BaseEntity::getId).toList());
    } else if (ApsSchedulingDayConfigVersionAddOrderTypeEnum.orderNoParent.equals(req.getType())) {
      List<ApsOrder> orderList = this.apsOrderService.list(
          new LambdaQueryWrapper<ApsOrder>().in(ApsOrder::getOrderNoParent, orderNoTmpList));
      apsOrderList.addAll(orderList);
      orderIdList.addAll(orderList.stream().map(BaseEntity::getId).toList());
    }
    $.requireNonNullCanIgnoreException(orderNoTmpList, "订单为空，请检查录入的订单是否存在");

    long c = orderIdList.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()))
        .values().stream().filter(t -> t > 1).count();

    log.warn("重复订单数 {}", c);
    $.assertTrueCanIgnoreException(c == 0, "新录入订单存在重复");
    $.requireNonNullCanIgnoreException(orderIdList, "订单不存在");
    c = this.apsSchedulingVersionItemPreService.count(
        new LambdaQueryWrapper<ApsSchedulingVersionItemPre>().eq(
                ApsSchedulingVersionItemPre::getSchedulingVersionId, req.getSchedulingVersionId())
            .in(ApsSchedulingVersionItemPre::getOrderId, orderIdList));
    $.assertTrueCanIgnoreException(c == 0, "新旧订单存在重复");

    ApsSchedulingDayConfigVersion version = this.baseMapper.selectById(
        req.getSchedulingVersionId());

    List<ApsSchedulingVersionItemPre> apsSchedulingVersionItemPreList = new ArrayList<>();
    setOrderFieldValue(version, orderIdList, apsSchedulingVersionItemPreList);
    setFactoryGoodsName(apsGoodsService.list(), apsSchedulingVersionItemPreList);
    this.apsSchedulingVersionItemPreService.saveBatch(apsSchedulingVersionItemPreList);
    return new ApsSchedulingDayConfigVersionAddOrderRes();
  }

  @Override
  public void apsSchedulingDayConfigVersionOrderExport(
      ApsSchedulingDayConfigVersionOrderExportReq req) {
    ApsSchedulingDayConfigVersion version = this.getById(req.getSchedulingVersionId());
    $.requireNonNullCanIgnoreException(version, "排程版本为空");
    List<ApsSchedulingVersionItemPre> versionItemPreList = apsSchedulingVersionItemPreService.list(
        new LambdaQueryWrapper<ApsSchedulingVersionItemPre>().eq(
            ApsSchedulingVersionItemPre::getSchedulingVersionId, req.getSchedulingVersionId()));
    EasyExcelUtilExportMultipleData exportMultipleData = new EasyExcelUtilExportMultipleData().setFileName(
        "排程订单-" + version.getSchedulingDayVersionNo());
    List<EasyExcelUtilExportMultipleData.SheetHeader> headerList = new ArrayList<>();
    headerList.add(new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName("currentDay")
        .setShowName("排程日期"));
    headerList.add(new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName("orderNo")
        .setShowName("订单号"));
    headerList.add(new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName("factoryName")
        .setShowName("工厂名称"));
    headerList.add(new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName("goodsName")
        .setShowName("商品名称"));
    headerList.add(new EasyExcelUtilExportMultipleData.SheetHeader().setFieldName("oldScheduleDate")
        .setShowName("上次排程"));

    setHeaderFormKvList(version.getOrderFieldList(), headerList, "order_");
    setHeaderFormKvList(version.getOrderUserFieldList(), headerList, "orderUser_");
    setHeaderFormKvList(version.getSaleConfigIdList(), headerList, "sale_");

    List<Map<String, Object>> mapList = new ArrayList<>(versionItemPreList.size());
    while (CollUtil.isNotEmpty(versionItemPreList)) {
      ApsSchedulingVersionItemPre itemPre = versionItemPreList.removeFirst();
      Map<String, Object> mapTmp = BeanUtil.beanToMap(itemPre);
      mapTmp.putAll(itemPre.getShowField());
      mapList.add(mapTmp);
    }

    exportMultipleData.setSheetDataList(List.of(
        new EasyExcelUtilExportMultipleData.SheetData().setSheetName("订单列表")
            .setHeaderList(headerList).setDataList(mapList)));
    PoiExcelUtil.exportMultipleData(exportMultipleData);
  }

  public void schedulingOrderList(ApsSchedulingDayConfigVersionDto req) {
//    ApsSchedulingDayConfigVersion  version=ApsSchedulingDayConfigVersionConverter.INSTANCE.dto2Model(req);
    ApsSchedulingDayConfigVersion version = this.getById(req.getId());
    List<ApsSchedulingVersionItemPre> itemPreList = this.apsSchedulingVersionItemPreService.list(
        new LambdaQueryWrapper<ApsSchedulingVersionItemPre>().eq(
            ApsSchedulingVersionItemPre::getSchedulingVersionId, req.getId()));
    List<ApsSchedulingIssueItem> issueItemList = new ArrayList<>();
    while (CollUtil.isNotEmpty(itemPreList)) {
      ApsSchedulingVersionItemPre itemPre = itemPreList.removeFirst();
      ApsSchedulingIssueItem item = new ApsSchedulingIssueItem();
      item.setOrderNo(itemPre.getOrderNo()).setOrderId(itemPre.getOrderId())
          .setSchedulingVersionId(itemPre.getSchedulingVersionId())
          .setCurrentDay(itemPre.getCurrentDay()).setGoodsId(itemPre.getGoodsId());
      issueItemList.add(item);
    }

    if (MAKE.equals(version.getProductType())) {
      List<ApsGoods> apsGoodsList = this.apsGoodsService.list();
      insertMake(version, apsGoodsList, issueItemList);
    } else {
      insertProcess(version, issueItemList);
    }
    this.update(new LambdaUpdateWrapper<ApsSchedulingDayConfigVersion>().set(
        ApsSchedulingDayConfigVersion::getStepIndex, 2).eq(BaseEntity::getId, req.getId()));
  }

  private void insertMake(ApsSchedulingDayConfigVersion dayConfigVersion,
      List<ApsGoods> apsGoodsList, List<ApsSchedulingIssueItem> itemList) {
    // 制造路径
    List<ApsProduceProcess> apsProduceProcesses = apsProduceProcessService.listByIds(
        apsGoodsList.stream().map(ApsGoods::getProduceProcessId).collect(Collectors.toSet()));
    Map<Long, List<ApsProduceProcessItem>> apsProduceProcessItemMap = apsProduceProcessItemService.list(
            new LambdaQueryWrapper<ApsProduceProcessItem>().in(
                ApsProduceProcessItem::getProduceProcessId,
                apsProduceProcesses.stream().map(BaseEntity::getId).collect(Collectors.toSet())))
        .stream().collect(Collectors.groupingBy(ApsProduceProcessItem::getProduceProcessId));
    Map<Long, ApsGoods> apsGoodsMap = apsGoodsList.stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));
    List<ProduceOrder> produceOrderList = itemList.stream().map(t -> {
      List<ApsProduceProcessItem> apsProduceProcessItems = apsProduceProcessItemMap.get(
          apsGoodsMap.get(t.getGoodsId()).getProduceProcessId());
      return new ProduceOrder().setOrderId(t.getOrderId()).setOrderMachineList(
          apsProduceProcessItems.stream().map(
              t2 -> new ProduceOrderMachine().setMachineId(t2.getMachineId())
                  .setUseTime(t2.getMachineUseTimeSecond())).toList());
    }).toList();
    // 制造路径计算
    ProduceProcessComputeRes computeRes = ProduceProcessUtils.compute(
        new ProduceProcessComputeReq().setProduceStartTime(LocalDateTime.now())
            .setProduceOrderList(produceOrderList));
    List<ProduceProcessComputeOrderRes> processComputeOrderRes = computeRes.getProcessComputeOrderRes();
    List<ApsSchedulingDayConfigVersionDetailMachine> detailMachineList = processComputeOrderRes.stream()
        .map(t -> $.copy(t, ApsSchedulingDayConfigVersionDetailMachine.class)
            .setSchedulingDayId(dayConfigVersion.getId())
            .setBeginDateTime(t.getBeginLocalDateTime()).setEndDateTime(t.getEndLocalDateTime()))
        .toList();
    detailMachineList.forEach(t -> t.setSchedulingDayId(dayConfigVersion.getId()));

    List<ApsSchedulingDayConfigVersionDetailMachineUseTime> machineUseTimeList = computeRes.getProcessComputeOrderRes()
        .stream().collect(Collectors.groupingBy(ProduceProcessComputeOrderRes::getMachineId))
        .entrySet().stream().map(
            t -> new ApsSchedulingDayConfigVersionDetailMachineUseTime().setSchedulingDayId(
                    dayConfigVersion.getId()).setMachineId(t.getKey())
                .setMakeProduceCount(t.getValue().size()).setUseTime(
                    t.getValue().stream().mapToLong(ProduceProcessComputeOrderRes::getUseTime)
                        .sum())).toList();
    machineUseTimeList.forEach(t -> t.setUseUsageRate(
        ObjectUtils.allNotNull(t.getUseTime(), computeRes.getMaxUseSecond())
            && ObjectUtils.notEqual(computeRes.getMaxUseSecond(), 0) && ObjectUtils.notEqual(
            t.getUseTime(), 0) ? new BigDecimal(t.getUseTime()).divide(
                new BigDecimal(computeRes.getMaxUseSecond()), 8, RoundingMode.HALF_DOWN)
            .multiply(new BigDecimal(100)) : new BigDecimal(0)));
    apsSchedulingDayConfigVersionDetailMachineUseTimeService.saveBatch(machineUseTimeList);
    apsSchedulingDayConfigVersionDetailMachineService.saveBatch(detailMachineList);
//    this.updateById(dayConfigVersion);
  }

  private void insertProcess(ApsSchedulingDayConfigVersion dayConfigVersion,
      List<ApsSchedulingIssueItem> issueItemList) {
    ApsSchedulingDayConfig apsSchedulingDayConfig = this.apsSchedulingDayConfigService.getById(
        dayConfigVersion.getSchedulingDayConfigId());
    ApsSchedulingDayConfigDto dayConfigDto = new ApsSchedulingDayConfigDto();
    dayConfigDto.setId(dayConfigVersion.getSchedulingDayConfigId());
    DynamicsPage<ApsSchedulingDayConfigExportQueryPageListInfoRes> apsSchedulingDayConfigExportQueryPageListInfoResDynamicsPage = apsSchedulingDayConfigService.queryPageList(
        new ApsSchedulingDayConfigExportQueryPageListReq().setQueryPage(false)
            .setData(dayConfigDto));
    $.requireNonNullCanIgnoreException(apsSchedulingDayConfigExportQueryPageListInfoResDynamicsPage,
        "排程配置不能为空");
    $.requireNonNullCanIgnoreException(
        apsSchedulingDayConfigExportQueryPageListInfoResDynamicsPage.getDataList(),
        "排程配置不能为空");
    ApsSchedulingDayConfigExportQueryPageListInfoRes apsSchedulingDayConfigDto = apsSchedulingDayConfigExportQueryPageListInfoResDynamicsPage.getDataList()
        .getFirst();

    $.requireNonNullCanIgnoreException(issueItemList, "当天排产订单不能为空");

    log.info("apsSchedulingDayConfigDto getConfigBizType: {}",
        apsSchedulingDayConfigDto.getSchedulingDayConfigItemDtoList().stream()
            .map(ApsSchedulingDayConfigItemDto::getConfigBizType).collect(Collectors.toSet()));

    List<Long> orderIdList = issueItemList.stream().map(ApsSchedulingIssueItem::getOrderId)
        .toList();
    Map<Long, List<ApsOrderGoodsSaleConfig>> orderSaleMap = apsOrderGoodsSaleConfigService.list(
            new LambdaQueryWrapper<ApsOrderGoodsSaleConfig>().in(ApsOrderGoodsSaleConfig::getOrderId,
                orderIdList)).stream()
        .collect(Collectors.groupingBy(ApsOrderGoodsSaleConfig::getOrderId));
    Map<Long, List<ApsOrderGoodsProjectConfig>> orderProjectMap = this.apsOrderGoodsProjectConfigService.list(
            new LambdaQueryWrapper<ApsOrderGoodsProjectConfig>().in(
                ApsOrderGoodsProjectConfig::getOrderId, orderSaleMap.keySet())).stream()
        .collect(Collectors.groupingBy(ApsOrderGoodsProjectConfig::getOrderId));
    Map<Long, List<ApsOrderGoodsBom>> orderBomMap = this.apsOrderGoodsBomService.list(
            new LambdaQueryWrapper<ApsOrderGoodsBom>().in(ApsOrderGoodsBom::getOrderId, orderIdList))
        .stream().collect(Collectors.groupingBy(ApsOrderGoodsBom::getOrderId));
    issueItemList.forEach(order -> {
      order.setSaleConfigIdList(orderSaleMap.getOrDefault(order.getOrderId(), List.of()).stream()
          .map(ApsOrderGoodsSaleConfig::getConfigId).toList());
      order.setProjectConfigIdList(
          orderProjectMap.getOrDefault(order.getOrderId(), List.of()).stream()
              .map(ApsOrderGoodsProjectConfig::getConfigId).toList());
      order.setBomIdList(orderBomMap.getOrDefault(order.getOrderId(), List.of()).stream()
          .map(ApsOrderGoodsBom::getBomId).toList());
    });

    Map<String, List<ApsSchedulingDayConfigVersionDetailDto>> orderRoomResMap = ApsSchedulingDayUtils.orderRoomStatusMap(
        new ApsSchedulingDayOrderRoomReq().setIssueItemList(
                $.copyList(issueItemList, ApsSchedulingIssueItemDto.class))
            .setSchedulingDayId(dayConfigVersion.getId()).setSchedulingDayConfigDto(
                $.copy(apsSchedulingDayConfigDto,
                    com.olivia.peanut.aps.utils.scheduling.model.ApsSchedulingDayConfigDto.class)));
//    apsSchedulingDayConfigDto.getSchedulingDayConfigItemDtoList()

    List<List<Long>> headerIdList = apsSchedulingDayConfigDto.getSchedulingDayConfigItemDtoList()
        .stream().map(t -> List.of(t.getRoomId(), t.getStatusId())).toList();
    dayConfigVersion.setHeaderList(toJSONString(headerIdList));
    dayConfigVersion.setProcessId(apsSchedulingDayConfig.getProcessId());

    List<ApsSchedulingDayConfigVersionDetailDto> versionDetails = new ArrayList<>();

    List<ApsSchedulingDayConfigVersionDetailDto> tmpList = new ArrayList<>();

    FactoryConfigRes factoryConfig = apsFactoryService.getFactoryConfig(
        new FactoryConfigReq().setFactoryId(dayConfigVersion.getFactoryId())
            .setQueryDefaultProcessPath(Boolean.TRUE)
            .setGetPathId(apsSchedulingDayConfig.getProcessId()));
    List<List<Long>> headerList = new ArrayList<>();

    factoryConfig.getDefaultApsProcessPathDto().getPathRoomList().forEach(room -> {
      room.getApsRoomConfigList().forEach(roomStatus -> {
        headerList.add(List.of(roomStatus.getRoomId(), roomStatus.getStatusId()));
        String key = roomStatus.getRoomId() + "-" + roomStatus.getStatusId();
        List<ApsSchedulingDayConfigVersionDetailDto> detailDtoList = orderRoomResMap.get(key);
        if (CollUtil.isNotEmpty(detailDtoList)) {
          tmpList.clear();
          tmpList.addAll(detailDtoList);
        }
        tmpList.forEach(t -> {
          t.setRoomId(roomStatus.getRoomId()).setStatusId(roomStatus.getStatusId());
          versionDetails.add($.copy(t, ApsSchedulingDayConfigVersionDetailDto.class));
        });
      });
    });
    tmpList.clear();

    versionDetails.forEach(t -> t.setSchedulingDayId(dayConfigVersion.getId()));
    dayConfigVersion.setHeaderList(toJSONString(headerList));
    this.apsSchedulingDayConfigVersionDetailService.saveBatch(
        $.copyList(versionDetails, ApsSchedulingDayConfigVersionDetail.class));
    this.updateById(dayConfigVersion);
  }

  public @Override ApsSchedulingDayConfigVersionQueryListRes queryList(
      ApsSchedulingDayConfigVersionQueryListReq req) {

    MPJLambdaWrapper<ApsSchedulingDayConfigVersion> q = getWrapper(req.getData());
    List<ApsSchedulingDayConfigVersion> list = this.list(q);

    List<ApsSchedulingDayConfigVersionDto> dataList = list.stream()
        .map(t -> $.copy(t, ApsSchedulingDayConfigVersionDto.class)).collect(Collectors.toList());
    ((ApsSchedulingDayConfigVersionService) AopContext.currentProxy()).setName(dataList);
    return new ApsSchedulingDayConfigVersionQueryListRes().setDataList(dataList);
  }

  public @Override DynamicsPage<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingDayConfigVersionExportQueryPageListReq req) {

    DynamicsPage<ApsSchedulingDayConfigVersion> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsSchedulingDayConfigVersion> q = getWrapper(req.getData());
    List<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsSchedulingDayConfigVersion> list = this.page(page, q);
      IPage<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsSchedulingDayConfigVersionExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = $.copyList(this.list(q),
          ApsSchedulingDayConfigVersionExportQueryPageListInfoRes.class);
    }

    // 类型转换，  更换枚举 等操作

    List<ApsSchedulingDayConfigVersionExportQueryPageListInfoRes> listInfoRes = $.copyList(records,
        ApsSchedulingDayConfigVersionExportQueryPageListInfoRes.class);
    ((ApsSchedulingDayConfigVersionService) AopContext.currentProxy()).setName(listInfoRes);

    return DynamicsPage.init(page, listInfoRes);
  }

  @SneakyThrows
  @Override
  public ApsSchedulingDayConfigVersionDetailListRes detailList(
      ApsSchedulingDayConfigVersionDetailListReq req) {
    ApsSchedulingDayConfigVersion configVersion = this.getById(req.getId());
    $.requireNonNullCanIgnoreException(configVersion, "排程版本不能为空");
    List<ApsSchedulingDayConfigVersionDetail> dayConfigVersionDetailList = this.apsSchedulingDayConfigVersionDetailService.list(
        new LambdaQueryWrapper<ApsSchedulingDayConfigVersionDetail>().eq(
            ApsSchedulingDayConfigVersionDetail::getSchedulingDayId, req.getId()));
    ApsSchedulingDayConfigVersionDetailListRes res = new ApsSchedulingDayConfigVersionDetailListRes();
    if (CollUtil.isEmpty(dayConfigVersionDetailList)) {
      return res;
    }

    Map<String, List<ApsSchedulingDayConfigVersionDetail>> versionDetailMap = dayConfigVersionDetailList.stream()
        .collect(Collectors.groupingBy(t -> t.getRoomId() + "-" + t.getStatusId(),
            Collectors.collectingAndThen(Collectors.<ApsSchedulingDayConfigVersionDetail>toList(),
                t -> {
                  t.sort(Comparator.comparing(
                      ApsSchedulingDayConfigVersionDetail::getSchedulingDayId));
                  return t;
                })));

    String headerListStr = configVersion.getHeaderList();
    Map<String, List<Map<String, Object>>> retMap = new HashMap<>();
    versionDetailMap.forEach((k, v) -> {
      List<Map<String, Object>> mapList = v.stream().map(t -> {
        Map<String, Object> tt = BeanUtil.beanToMap(t, false, true);
        tt.put("isMatch", Str.booleanToStr(t.getIsMatch()));
        tt.put("loopEnough", Str.booleanToStr(t.getLoopEnough()));
        tt.put("configBizType",
            ApsSchedulingDayConfigItemConfigBizTypeEnum.valueOf(t.getConfigBizType()).getDesc());
        return tt;
      }).toList();
      retMap.put(k, mapList);
    });
    res.setVersionDetailMap(retMap);
    List<Header> headerList = new ArrayList<>();
    if (StringUtils.isNoneBlank(headerListStr)) {

      List<List<Long>> roomDtoList = JSON.readValue(headerListStr, new TypeReference<>() {
      });

      Map<Long, String> statusNameMap = this.apsStatusService.list().stream()
          .collect(Collectors.toMap(BaseEntity::getId, ApsStatus::getStatusName));
      Map<Long, String> roomNameMap = this.apsRoomService.list().stream()
          .collect(Collectors.toMap(BaseEntity::getId, ApsRoom::getRoomName));
      roomDtoList.forEach(rl -> {
        Header header = new Header().setFieldName(rl.getFirst() + "-" + rl.get(1))
            .setShowName(roomNameMap.get(rl.getFirst()) + "/" + statusNameMap.get(rl.get(1)))
            .setWidth(400).setSortValue("");
        headerList.add(header);
      });

      res.setHeaderList(headerList);
    }
    res.setScheduledDate(configVersion.getSchedulingDay());

    return res;
  }

  @Override
  public ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes updateOrderSortIndex(
      ApsSchedulingDayConfigVersionUpdateOrderSortIndexReq req) {

    List<ApsSchedulingDayConfigVersionDetail> detailList = req.getOrderList().stream().map(t -> {
      ApsSchedulingDayConfigVersionDetail baseEntity = new ApsSchedulingDayConfigVersionDetail();
      baseEntity.setId(t.getId());
      baseEntity.setSortIndex(t.getSortIndex());
      return baseEntity;
    }).toList();
    boolean b = this.apsSchedulingDayConfigVersionDetailService.updateBatchById(detailList);
    return new ApsSchedulingDayConfigVersionUpdateOrderSortIndexRes().setSc(b);
  }

  @Override
  public CanSchedulingOrderListRes canSchedulingOrderList(CanSchedulingOrderListReq req) {
    return null;
  }
  // 以下为私有对象封装

  public @Override void setName(
      List<? extends ApsSchedulingDayConfigVersionDto> apsSchedulingDayConfigVersionDtoList) {

    setNameService.setName(apsSchedulingDayConfigVersionDtoList, SetNamePojoUtils.FACTORY,
        SetNamePojoUtils.OP_USER_NAME,
        SetNamePojoUtils.getSetNamePojo(ApsProcessPathService.class, "processPathName", "processId",
            "processName"));

  }


  private MPJLambdaWrapper<ApsSchedulingDayConfigVersion> getWrapper(
      ApsSchedulingDayConfigVersionDto obj) {
    MPJLambdaWrapper<ApsSchedulingDayConfigVersion> q = new MPJLambdaWrapper<>();

    if (Objects.nonNull(obj)) {
      q.eq(Objects.nonNull(obj.getFactoryId()), ApsSchedulingDayConfigVersion::getFactoryId,
              obj.getFactoryId()).eq(StringUtils.isNoneBlank(obj.getSchedulingDayVersionNo()),
              ApsSchedulingDayConfigVersion::getSchedulingDayVersionNo, obj.getSchedulingDayVersionNo())
          .eq(Objects.nonNull(obj.getSchedulingDay()),
              ApsSchedulingDayConfigVersion::getSchedulingDay, obj.getSchedulingDay())
          .eq(Objects.nonNull(obj.getIsIssuedThird()),
              ApsSchedulingDayConfigVersion::getIsIssuedThird, obj.getIsIssuedThird())

      ;
    }
    q.orderByDesc(ApsSchedulingDayConfigVersion::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsSchedulingDayConfigVersion> page) {

    tableHeaderService.listByBizKey(page, "ApsSchedulingDayConfigVersionService#queryPageList");

  }


}

