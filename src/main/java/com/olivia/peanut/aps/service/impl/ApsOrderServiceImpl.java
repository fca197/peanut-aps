package com.olivia.peanut.aps.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigSale2ProjectReq;
import com.olivia.peanut.aps.api.entity.apsGoodsSaleProjectConfig.ApsGoodsSaleProjectConfigSale2ProjectRes;
import com.olivia.peanut.aps.api.entity.apsOrder.*;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineRes.StatusInfo;
import com.olivia.peanut.aps.api.entity.apsOrderGoods.ApsOrderGoodsDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsSaleConfig.ApsOrderGoodsSaleConfigDto;
import com.olivia.peanut.aps.api.entity.apsOrderUser.ApsOrderUserDto;
import com.olivia.peanut.aps.api.entity.apsProcessPath.ApsProcessPathDto;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsProjectConfig.ApsProjectConfigExportQueryPageListReq;
import com.olivia.peanut.aps.mapper.ApsOrderMapper;
import com.olivia.peanut.aps.model.*;
import com.olivia.peanut.aps.service.*;
import com.olivia.peanut.aps.service.impl.po.ApsOrderConfig;
import com.olivia.peanut.aps.service.pojo.FactoryConfigReq;
import com.olivia.peanut.aps.service.pojo.FactoryConfigRes;
import com.olivia.peanut.aps.utils.bom.BomUtils;
import com.olivia.peanut.aps.utils.process.ProcessUtils;
import com.olivia.peanut.aps.utils.process.ProduceStatusUtils;
import com.olivia.peanut.aps.utils.process.entity.*;
import com.olivia.peanut.aps.utils.process.entity.ApsProcessPathInfo.Info;
import com.olivia.peanut.base.model.Factory;
import com.olivia.peanut.base.service.FactoryService;
import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.peanut.portal.api.entity.EChartResDto;
import com.olivia.sdk.ann.SetUserName;
import com.olivia.sdk.comment.ServiceComment;
import com.olivia.sdk.config.PeanutProperties;
import com.olivia.sdk.utils.*;
import com.olivia.sdk.utils.model.UserInfo;
import jakarta.annotation.Resource;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (ApsOrder)表服务实现类
 *
 * @author peanut
 * @since 2024-04-09 13:19:36
 */
@Slf4j
@Service("apsOrderService")
@Transactional
@SuppressWarnings("unchecked")
public class ApsOrderServiceImpl extends MPJBaseServiceImpl<ApsOrderMapper, ApsOrder> implements ApsOrderService {


  final static Cache<Long, List<ApsGoodsSaleItem>> apsGoodsSaleItem_cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(30, TimeUnit.MINUTES).build();
  private static final AtomicLong orderIdGenerator = new AtomicLong(1);
  @Resource
  ApsOrderGoodsService apsOrderGoodsService;
  @Resource
  ApsOrderGoodsProjectConfigService apsOrderGoodsProjectConfigService;
  @Resource
  ApsOrderUserService apsOrderUserService;
  @Resource
  ApsOrderGoodsSaleConfigService apsOrderGoodsSaleConfigService;
  @Resource
  ApsGoodsSaleItemService apsGoodsSaleItemService;
  @Resource
  ApsSaleConfigService apsSaleConfigService;
  @Resource
  ApsProjectConfigService apsProjectConfigService;
  @Resource
  ApsGoodsService apsGoodsService;
  @Resource
  ApsStatusService apsStatusService;
  @Resource
  ApsSchedulingGoodsStatusDateService apsSchedulingGoodsStatusDateService;
  @Resource
  ApsOrderGoodsStatusDateService apsOrderGoodsStatusDateService;
  @Autowired
  ApsFactoryService apsFactoryService;
  @Resource
  PeanutProperties peanutProperties;
  @Resource
  ApsOrderGoodsBomService apsOrderGoodsBomService;
  @Resource
  ApsGoodsBomService apsGoodsBomService;
  @Resource
  FactoryService factoryService;
  @Resource
  ApsGoodsSaleProjectConfigService apsGoodsSaleProjectConfigService;
  @Resource
  ApsOrderFieldService apsOrderFieldService;
  @Resource
  ApsOrderFieldShowTemplateService apsOrderFieldShowTemplateService;

  private static LocalDate getExpFinishDate(List<ApsOrderGoodsStatusDate> updateList, List<ApsOrderGoodsStatusDate> insertList) {
    return Stream.of(updateList, insertList).flatMap(List::stream).map(ApsOrderGoodsStatusDate::getExpectMakeEndTime).filter(Objects::nonNull).max(LocalDate::compareTo)
        .orElse(null);
  }

  private void useProcessPath(Long orderId, Long goodsStatusId, FactoryConfigRes factoryConfig, ApsGoods apsGoods, List<ApsOrderGoodsStatusDate> updateList,
      List<ApsOrderGoodsStatusDate> insertList, boolean isBegin, LocalDate startTime) {
    Map<Long, ApsOrderGoodsStatusDate> statusDateMap = this.apsOrderGoodsStatusDateService.listByOrderIdGoodsId(orderId, apsGoods.getId()).stream()
        .collect(Collectors.toMap(ApsOrderGoodsStatusDate::getGoodsStatusId, Function.identity()));
    ApsProcessPathDto apsProcessPathDto = factoryConfig.getProcessPathDtoMap().get(apsGoods.getProcessPathId());
    ApsProcessPathInfo apsProcessPathInfo = ProcessUtils.schedulePathDate($.copy(apsProcessPathDto, ApsProcessPathVo.class), factoryConfig.getWeekList(),
        factoryConfig.getDayWorkLastSecond(), factoryConfig.getDayWorkSecond(), goodsStatusId, isBegin, Map.of(), startTime);
    List<Info> dataList = apsProcessPathInfo.getDataList();

    Map<Long, String> apsStatusMap = this.apsStatusService.list().stream().collect(StreamUtils.toMapWithNullKeys(BaseEntity::getId, ApsStatus::getStatusName));
    dataList.forEach(t -> {
      ApsOrderGoodsStatusDate apsOrderGoodsStatusDate = statusDateMap.get(t.getStatusId());
      if (Objects.nonNull(apsOrderGoodsStatusDate)) {
        updateList.add(apsOrderGoodsStatusDate.setExpectMakeBeginTime(t.getEndLocalDate()).setExpectMakeEndTime(t.getBeginLocalDate()).setStatusIndex(t.getSortIndex()));
      } else {
        ApsOrderGoodsStatusDate statusDate = new ApsOrderGoodsStatusDate().setOrderId(orderId).setGoodsStatusId(t.getStatusId()).setStatusIndex(t.getSortIndex())
            .setFactoryId(apsGoods.getFactoryId()).setGoodsStatusId(t.getStatusId()).setExpectMakeBeginTime(t.getBeginLocalDate())
            .setExpectMakeEndTime(t.getEndLocalDate()).setGoodsId(apsGoods.getId());
        statusDate.setGoodsStatusName(apsStatusMap.get(t.getStatusId()));
        insertList.add(statusDate);
      }
    });
  }

  public @Override ApsOrderQueryListRes queryList(ApsOrderQueryListReq req) {

    MPJLambdaWrapper<ApsOrder> q = getWrapper(req.getData());
    List<ApsOrder> list = this.list(q);

    List<ApsOrderDto> dataList = list.stream().map(t -> $.copy(t, ApsOrderDto.class)).collect(Collectors.toList());
    //  this.setName(dataList);
    ((ApsOrderServiceImpl) AopContext.currentProxy()).setName(dataList);

    return new ApsOrderQueryListRes().setDataList(dataList);
  }

  public @Override DynamicsPage<ApsOrderExportQueryPageListInfoRes> queryPageList(ApsOrderExportQueryPageListReq req) {

    DynamicsPage<ApsOrder> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsOrder> q = getWrapper(req.getData());
    List<ApsOrderExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsOrder> list = this.page(page, q);
      IPage<ApsOrderExportQueryPageListInfoRes> dataList = list.convert(t -> $.copy(t, ApsOrderExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = $.copyList(this.list(q), ApsOrderExportQueryPageListInfoRes.class);
    }

    // 类型转换，  更换枚举 等操作
    List<ApsOrderExportQueryPageListInfoRes> listInfoRes = $.copyList(records, ApsOrderExportQueryPageListInfoRes.class);

    // this.setName(listInfoRes);
    ((ApsOrderServiceImpl) AopContext.currentProxy()).setName(listInfoRes);

    return DynamicsPage.init(page, listInfoRes);
  }

  @Override
  public ApsOrderInsertRes save(ApsOrderInsertReq req) {
    req.setOrderStatus(ApsOrderStatusEnum.INIT.getCode());
    ApsOrder apsOrder = $.copy(req, ApsOrder.class);
    apsOrder.setOrderNo(IdUtils.getUniqueId());
    apsOrder.setId(IdWorker.getId());
    ApsStatus apsStatus = apsStatusService.getOne(new LambdaQueryWrapper<ApsStatus>().eq(ApsStatus::getOrderStatusId, ApsOrderStatusEnum.INIT.getCode()));
    $.requireNonNullCanIgnoreException(apsStatus, "订单初始化aps状态为空");

    List<ApsOrderGoods> goodsList = $.copyList(req.getGoodsList(), ApsOrderGoods.class);
    goodsList.forEach(t -> t.setOrderId(apsOrder.getId()).setApsStatusId(apsStatus.getId()));

    List<ApsOrderGoodsSaleConfig> saleConfigList = $.copyList(req.getGoodsSaleConfigList(), ApsOrderGoodsSaleConfig.class);
    saleConfigList.forEach(t -> t.setOrderId(apsOrder.getId()).setFactoryId(req.getFactoryId()));
    ApsOrderUser orderUser = $.copy(req.getOrderUser(), ApsOrderUser.class);
    orderUser.setOrderId(apsOrder.getId());
    ApsOrderGoods goods = goodsList.getFirst();

    List<ApsSaleConfig> apsSaleConfigList = apsSaleConfigService.listByIds(saleConfigList.stream().map(ApsOrderGoodsSaleConfig::getConfigId).collect(Collectors.toSet()));

    ApsGoodsSaleProjectConfigSale2ProjectReq sale2ProjectReq = new ApsGoodsSaleProjectConfigSale2ProjectReq();
    sale2ProjectReq.setSaleConfig(apsSaleConfigList.stream().map(ApsSaleConfig::getSaleCode).collect(Collectors.joining(",")));
    sale2ProjectReq.setGoodsId(req.getGoodsList().getFirst().getGoodsId());
    sale2ProjectReq.setBizKey(LocalDate.now()).setConvertCount(1L);
    ApsGoodsSaleProjectConfigSale2ProjectRes sale2projectRes = apsGoodsSaleProjectConfigService.sale2project(sale2ProjectReq);
    ApsGoodsSaleProjectConfigSale2ProjectRes.Info sale2projectResInfo = sale2projectRes.getDataList().getFirst();
    Map<String, Long> projectCodeIdMap = this.apsProjectConfigService.list(
            new LambdaQueryWrapper<ApsProjectConfig>().select(BaseEntity::getId, ApsProjectConfig::getSaleCode)).stream()
        .collect(StreamUtils.toMapWithNullKeys(ApsProjectConfig::getSaleCode, BaseEntity::getId));
    List<ApsOrderGoodsProjectConfig> goodsProjectConfigList = Arrays.stream(sale2projectResInfo.getProjectCode().split(",")).map(
        t -> new ApsOrderGoodsProjectConfig().setOrderId(orderUser.getOrderId()).setConfigId(projectCodeIdMap.get(t)).setFactoryId(goods.getFactoryId())
            .setGoodsId(goods.getId())).toList();
    this.apsOrderGoodsProjectConfigService.saveBatch(goodsProjectConfigList);

    apsOrder.setFactoryId(goods.getFactoryId()).setGoodsId(goods.getGoodsId());
    this.save(apsOrder);
    this.apsOrderGoodsSaleConfigService.saveBatch(saleConfigList);
    this.apsOrderGoodsService.saveBatch(goodsList);
    this.apsOrderUserService.save(orderUser);
    return new ApsOrderInsertRes().setId(apsOrder.getId()).setCount(1);
  }

  @Override
  @Transactional
  @SneakyThrows
  public ApsOrderBatchInsertRes saveBatch(ApsOrderBatchInsertReq req) {

    List<Long> idList = new ArrayList<>();
    List<String> orderNoList = new ArrayList<>();

    List<ApsGoods> goodsList = this.apsGoodsService.list(
        new LambdaQueryWrapper<ApsGoods>().isNull(Objects.equals(req.getIsProcessMake(), 1), ApsGoods::getProduceProcessId)
            .isNull(!Objects.equals(req.getIsProcessMake(), 1), ApsGoods::getProduceProcessId));
    List<ApsOrderGoodsSaleConfig> insertSaleConfigList = new ArrayList<>();
    List<ApsOrderGoods> apsOrderGoodList = new ArrayList<>();
    List<ApsOrder> apsOrderList = new ArrayList<>();
    List<ApsOrderUser> apsOrderUserList = new ArrayList<>();
    ApsStatus apsStatus = apsStatusService.getOne(new LambdaQueryWrapper<ApsStatus>().eq(ApsStatus::getOrderStatusId, ApsOrderStatusEnum.INIT.getCode()));
    $.requireNonNullCanIgnoreException(apsStatus, "订单初始化aps状态为空");
//    Long statusId = Objects.nonNull(apsStatus) ? apsStatus.getId() : null;
//           .stream().collect(Collectors.toMap(ApsGoodsSaleItemDto::getSaleConfigId))
    List<ApsProjectConfigExportQueryPageListInfoRes> projectConfigList = this.apsProjectConfigService.queryPageList(
        new ApsProjectConfigExportQueryPageListReq().setQueryPage(false)).getDataList();
    ArrayList<ApsOrderGoodsProjectConfig> projectConfigArrayList = new ArrayList<>();

    List<ApsOrderGoodsBom> apsOrderGoodsBomList = new ArrayList<>();

    Map<Long, ApsSaleConfig> apsSaleConfigMap = this.apsSaleConfigService.list().stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity()));

    Map<Long, ApsProjectConfig> apsProjectConfigMap = this.apsProjectConfigService.list().stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity()));

    Map<Long, List<ApsGoodsBom>> goodsBomListMap = this.apsGoodsBomService.list().stream().collect(Collectors.groupingBy(ApsGoodsBom::getGoodsId));
    for (int i = 0; i < req.getCreateCount(); i++) {

      long totalPrice = i * RandomUtil.randomLong(1000, 2000);

      LocalDateTime dateTime = LocalDateTime.now().plus(Duration.ofDays(RandomUtil.randomInt(1, 50)));
      ApsOrder apsOrder = new ApsOrder().setOrderRemark("第[" + orderIdGenerator.getAndIncrement() + "]个订单").setOrderNo(IdUtils.getUniqueId())
          .setOrderNoParent("p_" + IdWorker.getId()).setReserveAmount(new BigDecimal(RandomUtil.randomLong(400000, 500000))).setReserveDatetime(LocalDateTime.now())
          .setExpectedMakeFinishDate(dateTime.toLocalDate()).setOrderTotalPrice(new BigDecimal(totalPrice)).setOrderStatus(ApsOrderStatusEnum.INIT);
      apsOrder.setFinishPayedAmount(new BigDecimal(0)).setFinishPayedDatetime(dateTime.plusDays(RandomUtil.randomInt(3, 30)));
//      apsOrder.setDeliveryDate(dateTime.plusDays(RandomUtil.randomInt(30, 60)).toLocalDate());
      apsOrder.setId(IdWorker.getId());
      apsOrder.setOrderStatus(ApsOrderStatusEnum.INIT);

      ApsGoods goods = goodsList.get(RandomUtil.randomInt(0, goodsList.size()));

      apsOrder.setFactoryId(goods.getFactoryId()).setGoodsId(goods.getId());
      apsOrderList.add(apsOrder);

      List<ApsGoodsSaleItem> goodsSaleItems = apsGoodsSaleItem_cache.get(goods.getId(),
          () -> apsGoodsSaleItemService.list(new LambdaQueryWrapper<ApsGoodsSaleItem>().eq(ApsGoodsSaleItem::getGoodsId, goods.getId())).stream()
              .peek(t -> t.setSaleParentId(apsSaleConfigMap.get(t.getSaleConfigId()).getId())).toList());

      List<ApsGoodsSaleItem> apsGoodsSaleItemList = goodsSaleItems.stream().collect(Collectors.groupingBy(ApsGoodsSaleItem::getSaleParentId)).values().stream()
          .map(t -> t.get(RandomUtil.randomInt(0, t.size()))).toList();

      apsGoodsSaleItemList.forEach(apsGoodsSaleItem -> {
        ApsOrderGoodsSaleConfig saleConfig = $.copy(apsGoodsSaleItem, ApsOrderGoodsSaleConfig.class);
        ApsSaleConfig apsSaleConfig = apsSaleConfigMap.get(apsGoodsSaleItem.getSaleConfigId());
        ApsSaleConfig parentApsSaleConfig = apsSaleConfigMap.get(apsSaleConfig.getParentId());
        saleConfig.setOrderId(apsOrder.getId()).setConfigId(apsSaleConfig.getId()).setConfigName(apsSaleConfig.getSaleName())
            .setConfigParentName(parentApsSaleConfig.getSaleName()).setConfigParentId(parentApsSaleConfig.getId()).setId(IdUtils.getId());
        insertSaleConfigList.add(saleConfig);
      });

      ApsGoodsSaleProjectConfigSale2ProjectReq sale2ProjectReq = new ApsGoodsSaleProjectConfigSale2ProjectReq();
      sale2ProjectReq.setSaleConfig(apsGoodsSaleItemList.stream().map(ApsGoodsSaleItem::getSaleConfigId).map(apsSaleConfigMap::get).map(ApsSaleConfig::getSaleCode)
          .collect(Collectors.joining(",")));
      sale2ProjectReq.setGoodsId(goods.getId());
      sale2ProjectReq.setBizKey(LocalDate.now()).setConvertCount(1L);
      ApsGoodsSaleProjectConfigSale2ProjectRes sale2projectRes = apsGoodsSaleProjectConfigService.sale2project(sale2ProjectReq);
      ApsGoodsSaleProjectConfigSale2ProjectRes.Info sale2projectResInfo = sale2projectRes.getDataList().getFirst();
      Map<String, Long> projectCodeIdMap = this.apsProjectConfigService.list(
              new LambdaQueryWrapper<ApsProjectConfig>().select(BaseEntity::getId, ApsProjectConfig::getSaleCode)).stream()
          .collect(StreamUtils.toMapWithNullKeys(ApsProjectConfig::getSaleCode, BaseEntity::getId));
      List<ApsOrderGoodsProjectConfig> goodsProjectConfigList = Arrays.stream(sale2projectResInfo.getProjectCode().split(",")).map(
          t -> new ApsOrderGoodsProjectConfig().setOrderId(apsOrder.getId()).setConfigId(projectCodeIdMap.get(t)).setFactoryId(goods.getFactoryId())
              .setGoodsId(goods.getId())).toList();

      List<ApsGoodsBom> apsGoodsBomList = goodsBomListMap.getOrDefault(goods.getId(), List.of());

      Set<String> projectCodeSet = goodsProjectConfigList.stream().map(t -> apsProjectConfigMap.get(t.getConfigId()).getSaleCode()).collect(Collectors.toSet());

      apsGoodsBomList.forEach(apsGoodsBom -> {
        boolean match = BomUtils.isMatch(BomUtils.bomExpression2List(apsGoodsBom.getBomUseExpression()), "orderCreate", projectCodeSet);
        if (match) {
          ApsOrderGoodsBom orderGoodsBom = $.copy(apsGoodsBom, ApsOrderGoodsBom.class);
          orderGoodsBom.setGoodsId(goods.getId()).setOrderId(apsOrder.getId()).setId(IdWorker.getId());
          apsOrderGoodsBomList.add(orderGoodsBom);
        }
      });

      projectConfigArrayList.addAll(goodsProjectConfigList);

      ApsOrderGoods apsOrderGood = new ApsOrderGoods().setOrderId(apsOrder.getId()).setGoodsId(goods.getId()).setGoodsName(goods.getGoodsName())
          .setGoodsRemark(goods.getGoodsRemark()).setFactoryId(goods.getFactoryId()).setGoodsUnit("").setGoodsUnitPrice(new BigDecimal(RandomUtil.randomInt(100, 999)))
          .setApsStatusId(apsStatus.getId()).setGoodsTotalPrice(new BigDecimal(totalPrice)).setGoodsAmount(new BigDecimal(RandomUtil.randomInt(50000)));
      apsOrderGoodList.add(apsOrderGood);

      UserInfo randomUser = RandomUserUtil.getRandomUser();
      ApsOrderUser orderUser = new ApsOrderUser().setOrderId(apsOrder.getId()).setUserName("用户-" + i).setUserAddress(randomUser.getAddress())
          .setUserPhone(randomUser.getPhone()).setUserSex(randomUser.getSex());
      apsOrderUserList.add(orderUser);
      orderNoList.add(apsOrder.getOrderNo());
      idList.add(apsOrder.getId());
    }
    this.saveBatch(apsOrderList);
    this.apsOrderGoodsService.saveBatch(apsOrderGoodList);
    this.apsOrderGoodsSaleConfigService.saveBatch(insertSaleConfigList);
    this.apsOrderUserService.saveBatch(apsOrderUserList);
    this.apsOrderGoodsProjectConfigService.saveBatch(projectConfigArrayList);
    this.apsOrderGoodsBomService.saveBatch(apsOrderGoodsBomList);

    return new ApsOrderBatchInsertRes().setOrderNoList(orderNoList).setIdList(idList);
  }

  @Override
  public DynamicsPage<ApsOrderTimeLineRes> timeLine(ApsOrderTimeLineReq req) {

    ApsOrder apsOrder = this.getApsOrderByNo(req.getOrderNo());

    LocalDate now = LocalDate.now();
    List<Long> orderIdList = apsOrderGoodsStatusDateService.list(new QueryWrapper<ApsOrderGoodsStatusDate>().select(Str.DISTINCT + "order_id").lambda()
            .eq(Objects.nonNull(apsOrder), ApsOrderGoodsStatusDate::getOrderId, Objects.nonNull(apsOrder) ? apsOrder.getId() : null)
            .and(Boolean.TRUE.equals(req.getIsActualMakeTime()),
                r -> r.ge(ApsOrderGoodsStatusDate::getActualMakeBeginTime, req.getBeginDate()).le(ApsOrderGoodsStatusDate::getActualMakeEndTime, req.getEndDate()))
            .and(!Boolean.TRUE.equals(req.getIsActualMakeTime()),
                r -> r.ge(ApsOrderGoodsStatusDate::getExpectMakeBeginTime, req.getBeginDate()).le(ApsOrderGoodsStatusDate::getExpectMakeEndTime, req.getEndDate()))).stream()
        .map(ApsOrderGoodsStatusDate::getOrderId).toList();

    DynamicsPage<ApsOrderTimeLineRes> page = new DynamicsPage<>();
    page.setHeaderList(Lists.newArrayList()).setTotal(0);
    List<LocalDate> localDateList = DateUtils.getLocalDateBetween(req.getBeginDate(), req.getEndDate());
    localDateList.forEach(t -> page.addHeader(t.format(DatePattern.NORM_DATE_FORMATTER), t.format(DatePattern.NORM_DATE_FORMATTER), 100));
    if (CollUtil.isEmpty(orderIdList)) {
      return page;
    }
    int total = orderIdList.size();

    orderIdList = CollUtil.sub(orderIdList, (req.getPageNum() - 1) * req.getPageSize(), req.getPageNum() * req.getPageSize());
    if (CollUtil.isEmpty(orderIdList)) {
      return page;
    }

    Map<Long, List<ApsOrderGoodsStatusDate>> orderStatusMap = this.apsOrderGoodsStatusDateService.list(
            new LambdaQueryWrapper<ApsOrderGoodsStatusDate>().in(ApsOrderGoodsStatusDate::getOrderId, orderIdList)).stream()
        .collect(Collectors.groupingBy(ApsOrderGoodsStatusDate::getOrderId));
    Map<Long, String> sNameMap = this.apsStatusService.list().stream().collect(Collectors.toMap(BaseEntity::getId, ApsStatus::getStatusName));
    List<ApsOrderTimeLineRes> list = $.copyList(this.listByIds(orderIdList), ApsOrderTimeLineRes.class);
    setName(list);
    if (CollUtil.isNotEmpty(list)) {
      list.forEach(t -> {
        t.setStatusInfoList(orderStatusMap.getOrDefault(t.getId(), List.of()).stream()
            .map(s -> getStatusInfo(s, Boolean.TRUE.equals(req.getIsActualMakeTime()), now).setStatusName(sNameMap.get(s.getGoodsStatusId())))
            .collect(Collectors.toList()));
      });
    }
    page.setTotal(total).setRecords(list);
    return page;
  }

  private StatusInfo getStatusInfo(ApsOrderGoodsStatusDate statusDate, Boolean isActualMakeTime, LocalDate now) {
    StatusInfo statusInfo = new StatusInfo().setStatusId(statusDate.getGoodsStatusId())
        //.setBeginDate(statusDate.getExpectMakeBeginTime())
//        .setEndDate(statusDate.getExpectMakeEndTime())
        .setExpectMakeEndTime(statusDate.getExpectMakeEndTime()).setExpectMakeBeginTime(statusDate.getExpectMakeBeginTime())
        .setActualMakeBeginTime(statusDate.getActualMakeBeginTime()).setActualMakeEndTime(statusDate.getActualMakeEndTime());
    if (Boolean.TRUE.equals(isActualMakeTime)) {
      statusInfo.setBeginDate(statusDate.getActualMakeBeginTime().toLocalDate());
    } else {
      statusInfo.setBeginDate(statusDate.getExpectMakeBeginTime());
    }
    // 是否延期 ,实际实际大于预计时间
    if (Objects.nonNull(statusInfo.getActualMakeBeginTime()) && Objects.nonNull(statusInfo.getExpectMakeBeginTime())) {
      statusInfo.setIsDelay(statusInfo.getActualMakeBeginTime().toLocalDate().isAfter(statusInfo.getExpectMakeBeginTime()));
    }
    if (Objects.nonNull(statusInfo.getExpectMakeBeginTime()) && Objects.isNull(statusInfo.getActualMakeBeginTime())) {
      statusInfo.setIsDelay(now.isAfter(statusInfo.getExpectMakeBeginTime()));
    }
    return statusInfo;
  }

  @Override
  @Transactional
  public ApsOrderUpdateOrderStatusRes updateOrderStatus(ApsOrderUpdateOrderStatusReq req) {
    ApsOrder apsOrder = this.getById(req.getOrderId());
    $.requireNonNullCanIgnoreException(apsOrder, "订单不存在");
    ApsStatus apsStatus = this.apsStatusService.getById(req.getGoodsStatusId());
    $.requireNonNullCanIgnoreException(apsStatus, "状态不存在");
    List<ApsOrderGoods> apsOrderGoods = apsOrderGoodsService.getApsOrderGoodsByOrderId(apsOrder.getId());
    $.requireNonNullCanIgnoreException(apsOrderGoods, "订单商品不存在");
    ApsOrderGoods orderGoods = apsOrderGoods.getFirst();
    ApsGoods apsGoods = apsGoodsService.getById(orderGoods.getGoodsId());

    LocalDate now = LocalDate.now();
    Long factoryId = orderGoods.getFactoryId();
    FactoryConfigReq factoryConfigReq = new FactoryConfigReq().setFactoryId(factoryId).setQueryDefaultProcessPath(Objects.nonNull(apsGoods.getProcessPathId()))
        .setWeekBeginDate(now).setWeekEndDate(now.plusDays(peanutProperties.getOrderStatusUpdateNeedDayCount())).setGetWeek(Boolean.TRUE).setGetShift(Boolean.TRUE)
        .setNowDateTime(LocalDateTime.now());
    if (Objects.nonNull(apsGoods.getProduceProcessId())) {
      factoryConfigReq.setApsProduceProcessIdList(CollUtil.toList(apsGoods.getProduceProcessId()));
    }

    if (Objects.nonNull(apsStatus.getOrderStatusId())) {

      LambdaUpdateWrapper<ApsOrder> lambdaUpdateWrapper = new LambdaUpdateWrapper<ApsOrder>().eq(BaseEntity::getId, apsOrder.getId())
          .set(ApsOrder::getOrderStatus, apsStatus.getOrderStatusId());
      if (Objects.equals(ApsOrderStatusEnum.FINISHED.getCode(), apsStatus.getOrderStatusId())) {
        lambdaUpdateWrapper.set(ApsOrder::getActMakeFinishDate, now);
      }
      this.update(lambdaUpdateWrapper);
    }

    this.apsOrderGoodsService.update(
        new LambdaUpdateWrapper<ApsOrderGoods>().eq(ApsOrderGoods::getOrderId, req.getOrderId()).set(ApsOrderGoods::getApsStatusId, req.getGoodsStatusId()));
    this.apsOrderGoodsStatusDateService.update(new LambdaUpdateWrapper<ApsOrderGoodsStatusDate>().eq(ApsOrderGoodsStatusDate::getOrderId, req.getOrderId())
        .eq(ApsOrderGoodsStatusDate::getGoodsStatusId, req.getGoodsStatusId()).eq(ApsOrderGoodsStatusDate::getGoodsId, orderGoods.getGoodsId())
        .set(Boolean.TRUE.equals(req.getIsBeginTime()), ApsOrderGoodsStatusDate::getActualMakeBeginTime, LocalDateTime.now())
        .set(Boolean.FALSE.equals(req.getIsBeginTime()), ApsOrderGoodsStatusDate::getActualMakeEndTime, LocalDateTime.now()));

    return new ApsOrderUpdateOrderStatusRes();
  }

  private void useMakeProcess(Long orderId, Long goodsStatusId, FactoryConfigRes factoryConfig, ApsGoods apsGoods, List<ApsOrderGoodsStatusDate> updateList,
      List<ApsOrderGoodsStatusDate> insertList, boolean isBegin, LocalDateTime beginLocalDateTime) {

    List<ApsProduceProcessItem> apsProduceProcessItems = factoryConfig.getApsProduceProcessItemMap().get(apsGoods.getProduceProcessId());
    if (CollUtil.isEmpty(apsProduceProcessItems)) {
      log.error("制造路径不存在 id {}", apsGoods.getProduceProcessId());
      return;
    }

    Map<Long, String> apsStatusMap = this.apsStatusService.list().stream().collect(StreamUtils.toMapWithNullKeys(BaseEntity::getId, ApsStatus::getStatusName));
    Map<Long, ApsOrderGoodsStatusDate> statusDateMap = this.apsOrderGoodsStatusDateService.listByOrderIdGoodsId(orderId, apsGoods.getId()).stream()
        .collect(Collectors.toMap(ApsOrderGoodsStatusDate::getGoodsStatusId, Function.identity()));
    ComputeStatusReq computeStatusReq = new ComputeStatusReq();
    computeStatusReq.setBeginLocalDateTime(beginLocalDateTime);
    computeStatusReq.setWeekInfoList(factoryConfig.getWeekList()).setApsProduceProcessItemPojoList($.copyList(apsProduceProcessItems, ApsProduceProcessItemPojo.class))
        .setDayWorkLastSecond(factoryConfig.getDayWorkLastSecond()).setDayWorkSecond(factoryConfig.getDayWorkSecond()).setCurrentGoodsStatusId(goodsStatusId)
        .setIsBegin(isBegin);
    ComputeStatusRes computeStatusRes = ProduceStatusUtils.computeStatusTime(computeStatusReq);
    List<ApsProduceProcessItemPojo> apsProduceProcessItemPojoList = computeStatusRes.getApsProduceProcessItemPojoList();
    if (CollUtil.isEmpty(apsProduceProcessItemPojoList)) {
      return;
    }
    AtomicInteger atomicInteger = new AtomicInteger(0);
    apsProduceProcessItemPojoList.forEach(apsProduceProcessItemPojo -> {
      ApsOrderGoodsStatusDate apsOrderGoodsStatusDate = statusDateMap.get(apsProduceProcessItemPojo.getStatusId());
      if (Objects.isNull(apsOrderGoodsStatusDate)) {
        ApsOrderGoodsStatusDate statusDate = new ApsOrderGoodsStatusDate();
        statusDate.setId(IdWorker.getId());
        statusDate.setOrderId(orderId);
        statusDate.setGoodsId(apsGoods.getId());
        statusDate.setGoodsStatusId(apsProduceProcessItemPojo.getStatusId());
        statusDate.setGoodsStatusName(apsStatusMap.get(apsProduceProcessItemPojo.getStatusId()));
        statusDate.setExpectMakeBeginTime(apsProduceProcessItemPojo.getStatusLocalDate());
        statusDate.setStatusIndex(atomicInteger.incrementAndGet());
        insertList.add(statusDate);
      } else {
        apsOrderGoodsStatusDate.setExpectMakeBeginTime(apsProduceProcessItemPojo.getStatusLocalDate());
        updateList.add(apsOrderGoodsStatusDate);
      }

    });

//    RunUtils.noImpl("该商品暂不支持，敬请期待后续");
  }

  @Override
  public ApsOrderUpdateSchedulingDateRes updateSchedulingDate(ApsOrderUpdateSchedulingDateReq req) {
    if (Objects.isNull(req.getSchedulingDate())) {
      this.update(new LambdaUpdateWrapper<ApsOrder>().set(ApsOrder::getSchedulingDate, null).eq(BaseEntity::getId, req.getId()));
      return null;
    }
    $.assertTrueCanIgnoreException(LocalDate.now().isBefore(req.getSchedulingDate()), "排产日期不能小于今天");
    this.update(new LambdaUpdateWrapper<ApsOrder>().set(ApsOrder::getSchedulingDate, req.getSchedulingDate()).eq(BaseEntity::getId, req.getId()));
    return new ApsOrderUpdateSchedulingDateRes();
  }

  @Override
  public ApsOrder getApsOrderByNo(String orderNo) {
    return StringUtils.isNotBlank(orderNo) ? this.getOne(new LambdaQueryWrapper<ApsOrder>().eq(ApsOrder::getOrderNo, orderNo)) : null;
  }

  @Override
  public OrderCreateByMonthCountRes orderCreateByMonth(OrderCreateByMonthCountReq req) {
    LocalDateTime now = LocalDateTime.now();
//    LocalDateTime endLocalDate = now.plusMonths(1);
    LocalDateTime beginLocalDate = now.minusMonths(12);
    List<ApsOrder> apsOrderList = this.list(
        new QueryWrapper<ApsOrder>().select("create_time total_date ,count(1) row_total  ,goods_id").groupBy("total_date", "goods_id").lambda()
            .between(BaseEntity::getCreateTime, beginLocalDate, now.toLocalDate())
//        .groupBy(BaseEntity::getTotalDate, ApsOrder::getGoodsId)
    );
    OrderCreateByMonthCountRes res = new OrderCreateByMonthCountRes();
    List<LocalDate> localDateBetween = DateUtils.getLocalDateBetween(beginLocalDate.toLocalDate(), now.toLocalDate());
    List<String> dateList = localDateBetween.stream().map(DateUtils::localDate2Month).distinct().sorted().toList();
    res.setXAxis(new EChartResDto.XAxis().setData(dateList));

    // 总数
    Map<String, Long> allCountMap = apsOrderList.stream().collect(Collectors.groupingBy(t -> DateUtils.localDate2Month(t.getTotalDate()),
        Collectors.collectingAndThen(Collectors.<ApsOrder>toList(), l -> l.stream().mapToLong(BaseEntity::getRowTotal).sum())));

    List<EChartResDto.Series> seriesList = new ArrayList<>();
    List<String> monthList = DateUtils.getLocalDateBetween(beginLocalDate.toLocalDate(), now.toLocalDate()).stream().map(DateUtils::localDate2Month).distinct().sorted()
        .toList();
    seriesList.add(new EChartResDto.Series().setData(monthList.stream().map(t -> allCountMap.getOrDefault(t, 0L)).toList()).setName("当月总量"));

    List<ApsGoods> apsGoodsList = this.apsGoodsService.list();

    apsGoodsList.forEach(g -> {
      Map<String, Long> goodsTotalMap = apsOrderList.stream().filter(o -> Objects.equals(o.getGoodsId(), g.getId()))
          .collect(StreamUtils.toMapWithNullKeys(t -> DateUtils.localDate2Month(t.getTotalDate()), BaseEntity::getRowTotal));
      seriesList.add(new EChartResDto.Series().setName(g.getGoodsName()).setData(monthList.stream().map(t -> goodsTotalMap.getOrDefault(t, 0L)).toList()));
    });

    res.setSeries(seriesList);
    res.setYAxis(new EChartResDto.YAxis());
    return res;
  }

  @Override
  public StatusCountRes statusCount(StatusCountReq req) {
//    List<Long> statusIdList = Stream.of(ApsOrderStatusEnum.INIT, ApsOrderStatusEnum.CANCELLED, ApsOrderStatusEnum.FINISHED, ApsOrderStatusEnum.MAKE_OK).map(ApsOrderStatusEnum::getCode).toList();
    List<ApsStatus> apsStatusList = this.apsStatusService.list(new LambdaQueryWrapper<ApsStatus>().orderByAsc(ApsStatus::getSortIndex));
    //.stream().filter(t -> !statusIdList.contains(t.getOrderStatusId())).toList();
    apsStatusList.forEach(t -> {
      if (Objects.nonNull(t.getOrderStatusId())) {
        t.setId(t.getOrderStatusId());
      }
    });
    List<Long> searchStatusIdList = apsStatusList.stream().map(BaseEntity::getId).toList();
    List<ApsOrder> listedObjs = this.list(
        Wrappers.<ApsOrder>query().select("order_status", Str.ROW_TOTAL).lambda().in(ApsOrder::getOrderStatus, searchStatusIdList).groupBy(ApsOrder::getOrderStatus));
    Map<Long, Long> statusTotalMap = listedObjs.stream().collect(StreamUtils.toMapWithNullKeys(ApsOrder::getOrderStatus, BaseEntity::getRowTotal));
//    log.info("searchStatusIdList {} listedObjs {}", searchStatusIdList, JSON.toJSONString(listedObjs));
//    List<ApsStatusDto> apsStatusDtoList = ApsStatusConverter.INSTANCE.queryListRes(apsStatusList);
//    List<StatusCountRes.Info> infoList = listedObjs.stream().map(t -> new StatusCountRes.Info(t.getApsStatusId(), t.getRowTotal())).toList();
    StatusCountRes statusCountRes = new StatusCountRes();
    statusCountRes.setYAxis(new EChartResDto.YAxis()).setXAxis(new EChartResDto.XAxis().setData(apsStatusList.stream().map(ApsStatus::getStatusName).toList()))
        .setSeries(new EChartResDto.Series().setData(apsStatusList.stream().map(t -> statusTotalMap.getOrDefault(t.getId(), 0L)).toList()).setType("line"));
//    return statusCountRes.setApsStatusDtoList(apsStatusDtoList).setDataInfoList(infoList);
    return statusCountRes;
  }

  @Override

  public FinishOrderTotalDayRes finishOrderTotalDay(FinishOrderTotalDayReq req) {
    List<Factory> factoryList = this.factoryService.list();
    LocalDate endDate = LocalDate.now();
    LocalDate beginDate = endDate.minusMonths(1);
    List<ApsOrder> apsOrderList = this.list(
        new QueryWrapper<ApsOrder>().select(Str.ROW_TOTAL, "act_make_finish_date", "factory_id").lambda().groupBy(ApsOrder::getActMakeFinishDate, ApsOrder::getFactoryId)
            .eq(ApsOrder::getOrderStatus, ApsOrderStatusEnum.FINISHED.getCode()).between(ApsOrder::getActMakeFinishDate, beginDate, endDate));
    FinishOrderTotalDayRes res = new FinishOrderTotalDayRes();
    res.setYAxis(new EChartResDto.YAxis());
    List<LocalDate> localDateBetween = DateUtils.getLocalDateBetween(beginDate, endDate);
    List<String> dayList = localDateBetween.stream().map(String::valueOf).toList();
    EChartResDto.XAxis xAxis = new EChartResDto.XAxis().setData(dayList);
    res.setXAxis(xAxis);
    ArrayList<EChartResDto.Series> seriesArrayList = new ArrayList<>();
    factoryList.forEach(f -> {
      Map<LocalDate, Long> dayCountMap = apsOrderList.stream().filter(o -> Objects.equals(o.getFactoryId(), f.getId()))
          .collect(Collectors.toMap(ApsOrder::getActMakeFinishDate, BaseEntity::getRowTotal));
      seriesArrayList.add(new EChartResDto.Series().setData(localDateBetween.stream().map(t -> dayCountMap.getOrDefault(t, 0L)).toList()).setName(f.getFactoryName()));
    });
    res.setSeries(seriesArrayList);
    return res;
  }

  @Override
  public OrderFieldListRes orderFieldList(OrderFieldListReq req) {
    return new OrderFieldListRes().setDataList(FieldUtils.getFieldExtList(ApsOrder.class));
  }


  @Override
  public ApsOrderDeleteAllRes deleteAll(ApsOrderDeleteAllReq req) {
    JdbcTemplate jdbcTemplate = SpringUtil.getBean(JdbcTemplate.class);
    jdbcTemplate.execute(ApsOrderConfig.DELETE_ORDER_ALL);
    return new ApsOrderDeleteAllRes();
  }

  // 以下为私有对象封装

  @SetUserName
  public @Override void setName(List<? extends ApsOrderDto> apsOrderDtoList) {

    if (CollUtil.isEmpty(apsOrderDtoList)) {
      return;
    }
    Set<Long> oidSet = apsOrderDtoList.stream().map(BaseEntityDto::getId).collect(Collectors.toSet());

    Map<Long, String> stautsNameMap = this.apsStatusService.list().stream().collect(Collectors.toMap(BaseEntity::getId, ApsStatus::getStatusName));
    Map<Long, List<ApsOrderGoodsSaleConfig>> saleListMap = this.apsOrderGoodsSaleConfigService.list(
            new LambdaQueryWrapper<ApsOrderGoodsSaleConfig>().in(ApsOrderGoodsSaleConfig::getOrderId, oidSet)).stream()
        .collect(Collectors.groupingBy(ApsOrderGoodsSaleConfig::getOrderId));
//    Map<Long, List<ApsOrderGoodsProjectConfig>> projectListMap = this.apsOrderGoodsProjectConfigService.list(new LambdaQueryWrapper<ApsOrderGoodsProjectConfig>().in(ApsOrderGoodsProjectConfig::getOrderId, oidSet)).stream().collect(Collectors.groupingBy(ApsOrderGoodsProjectConfig::getOrderId));
    Map<Long, List<ApsOrderGoods>> goodsListMap = this.apsOrderGoodsService.list(new LambdaQueryWrapper<ApsOrderGoods>().in(ApsOrderGoods::getOrderId, oidSet)).stream()
        .collect(Collectors.groupingBy(ApsOrderGoods::getOrderId));
    Map<Long, ApsOrderUser> userMap = this.apsOrderUserService.list(new LambdaQueryWrapper<ApsOrderUser>().in(ApsOrderUser::getOrderId, oidSet)).stream()
        .collect(Collectors.toMap(ApsOrderUser::getOrderId, Function.identity()));
    apsOrderDtoList.forEach(t -> {
//      t.setGoodsProjectConfigList($.copyList(projectListMap.get(t.getId()), ApsOrderGoodsProjectConfigDto.class));
      t.setGoodsSaleConfigList($.copyList(saleListMap.get(t.getId()), ApsOrderGoodsSaleConfigDto.class));
      t.setGoodsList($.copyList(goodsListMap.get(t.getId()), ApsOrderGoodsDto.class));
      t.setOrderUser($.copy(userMap.get(t.getId()), ApsOrderUserDto.class));
      t.setOrderStatusName(ApsOrderStatusEnum.getDescByCode(t.getOrderStatus()));
      t.setOrderGoodsStatus(t.getGoodsList().getFirst().getApsStatusId());
      t.setOrderStatusGoodsName(stautsNameMap.get(t.getOrderGoodsStatus()));
    });
  }


  private MPJLambdaWrapper<ApsOrder> getWrapper(ApsOrderDto obj) {
    MPJLambdaWrapper<ApsOrder> q = new MPJLambdaWrapper<>();
    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsOrder.class, ApsOrder::getId, ApsOrder::getOrderStatus, ApsOrder::getFactoryId, ApsOrder::getOrderNo,
        ApsOrder::getOrderNoParent, ApsOrder::getIsWarning);
    q.orderByDesc(ApsOrder::getUrgencyLevel, BaseEntity::getId);
    return q;
  }

  private void setQueryListHeader(DynamicsPage<ApsOrder> page) {
    ServiceComment.header(page, "ApsOrderService#queryPageList");
  }
}