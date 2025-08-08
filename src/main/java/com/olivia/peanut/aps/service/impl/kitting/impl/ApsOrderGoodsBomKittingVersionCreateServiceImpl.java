package com.olivia.peanut.aps.service.impl.kitting.impl;

import static com.olivia.peanut.aps.con.ApsStr.ORDER_NO;
import static java.math.RoundingMode.DOWN;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.CreateSchedulingKittingVersion;
import com.olivia.peanut.aps.con.ApsStr;
import com.olivia.peanut.aps.model.*;
import com.olivia.peanut.aps.service.*;
import com.olivia.peanut.aps.service.impl.kitting.ApsOrderGoodsBomKittingVersionCreateService;
import com.olivia.sdk.model.KVEntity;
import com.olivia.sdk.utils.*;
import jakarta.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApsOrderGoodsBomKittingVersionCreateServiceImpl implements
    ApsOrderGoodsBomKittingVersionCreateService {


  private static final BigDecimal multiplicand_100 = new BigDecimal(100);
  private static final RoundingMode ROUNDING_MODE = DOWN;
  @Resource
  ApsOrderGoodsBomKittingVersionOrderService apsOrderGoodsBomKittingVersionOrderService;
  @Resource
  ApsOrderGoodsBomKittingVersionOrderItemService apsOrderGoodsBomKittingVersionOrderItemService;
  @Resource
  ApsSchedulingVersionCapacityService apsSchedulingVersionCapacityService;
  @Resource
  ApsOrderGoodsBomKittingTemplateService apsOrderGoodsBomKittingTemplateService;
  @Resource
  ApsGoodsService apsGoodsService;
  @Resource
  ApsBomService apsBomService;
  @Resource
  ApsGoodsBomService apsGoodsBomService;
  @Resource
  ApsOrderGoodsBomService apsOrderGoodsBomService;
  @Resource
  ApsOrderGoodsBomKittingVersionService apsOrderGoodsBomKittingVersionService;
  @Resource
  ApsOrderFieldService apsOrderFieldService;

  private static void setOrderValue(AtomicInteger fieldIndex,
      ApsOrderGoodsBomKittingVersionOrder versionOrder, Map<String, Object> t, String tc) {
    int index = fieldIndex.getAndIncrement();
    if (index > ApsOrderGoodsBomKittingVersionOrder.FIELD_COUNT) {
      return;
    }
    Field field = FieldUtils.getField(ApsOrderGoodsBomKittingVersionOrder.class,
        "orderField" + String.format("%02d", index));
    ReflectUtil.setFieldValue(versionOrder, field, t.get(tc));
  }

  @Override
  @SuppressWarnings("unchecked")
  public ApsOrderGoodsBomKittingVersionInsertRes createSchedulingKittingVersion(
      CreateSchedulingKittingVersion req) {

    ApsOrderGoodsBomKittingTemplate bomKittingTemplate = apsOrderGoodsBomKittingTemplateService.getById(
        req.getSchedulingVersionTemplateId());
    $.requireNonNullCanIgnoreException(bomKittingTemplate, "排产版本模板为空");

    List<LocalDate> kittingDateList = req.getKittingDate();
    Collections.sort(kittingDateList);
    List<ApsSchedulingVersionCapacity> schedulingVersionCapacityList = this.apsSchedulingVersionCapacityService.list(
        new LambdaQueryWrapper<ApsSchedulingVersionCapacity>().select(
                ApsSchedulingVersionCapacity::getGoodsId, ApsSchedulingVersionCapacity::getOrderId,
                ApsSchedulingVersionCapacity::getFactoryId, ApsSchedulingVersionCapacity::getCurrentDay,
                ApsSchedulingVersionCapacity::getNumberIndex)
            .eq(ApsSchedulingVersionCapacity::getSchedulingVersionId, req.getSchedulingVersionId())
            .in(ApsSchedulingVersionCapacity::getCurrentDay, kittingDateList)
            .orderByAsc(ApsSchedulingVersionCapacity::getCurrentDay,
                ApsSchedulingVersionCapacity::getNumberIndex));

    $.requireNonNullCanIgnoreException(schedulingVersionCapacityList, "排产版本获取订单为空");
    List<Long> goodIsList = schedulingVersionCapacityList.stream()
        .map(ApsSchedulingVersionCapacity::getGoodsId).distinct().toList();

    List<Long> orderIdList = schedulingVersionCapacityList.stream()
        .map(ApsSchedulingVersionCapacity::getOrderId).toList();
    Map<Long, Map<String, Object>> orderExtMap = schedulingVersionCapacityList.stream().collect(
        Collectors.toMap(ApsSchedulingVersionCapacity::getOrderId,
            t -> BeanUtil.beanToMap(t, false, true)));
    List<KVEntity> kittingTemplateOrderConfigList = bomKittingTemplate.getKittingTemplateOrderConfigList();
    List<KVEntity> kittingTemplateOrderUserConfigList = bomKittingTemplate.getKittingTemplateOrderUserConfigList();
    List<KVEntity> kittingTemplateSaleConfigList = bomKittingTemplate.getKittingTemplateSaleConfigList();
    Map<Long, Map<String, Object>> allOrderFieldMap = apsOrderFieldService.orderFieldSetValue(
        orderIdList,
        kittingTemplateOrderUserConfigList, kittingTemplateSaleConfigList, orderExtMap);

    Map<Long, ApsGoods> apsGoodsMap = apsGoodsService.listByIds(goodIsList).stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));
    List<ApsOrderGoodsBomKittingVersionOrderBom> apsOrderGoodsBomKittingVersionOrderBomList = Collections.synchronizedList(
        new ArrayList<>());
    List<ApsOrderGoodsBomKittingVersionOrder> apsOrderGoodsBomKittingVersionOrderList = Collections.synchronizedList(
        new ArrayList<>());

    Map<Long, BigDecimal> lackApsBomMap = new HashMap<>();

    ApsOrderGoodsBomKittingVersion apsOrderGoodsBomKittingVersion = new ApsOrderGoodsBomKittingVersion();
    apsOrderGoodsBomKittingVersion.setApsOrderGoodsBomKittingTemplateId(
        req.getSchedulingVersionTemplateId()).setId(IdUtils.getId());

    apsOrderGoodsBomKittingVersion.setTemplateHeaderList(new ArrayList<>());
    Optional.ofNullable(kittingTemplateOrderConfigList)
        .ifPresent(t -> apsOrderGoodsBomKittingVersion.getTemplateHeaderList().addAll(t));
    Optional.ofNullable(kittingTemplateOrderUserConfigList)
        .ifPresent(t -> apsOrderGoodsBomKittingVersion.getTemplateHeaderList().addAll(t));
    Optional.ofNullable(kittingTemplateSaleConfigList)
        .ifPresent(t -> apsOrderGoodsBomKittingVersion.getTemplateHeaderList().addAll(t));

    String nextVersionNo = getNextVersionNo();
    apsOrderGoodsBomKittingVersion.setKittingVersionNo("scheduling-" + nextVersionNo)
        .setKittingVersionName("排产[" + req.getSchedulingVersionId() + "]齐套")
        .setCreateDate(LocalDate.now());
    apsOrderGoodsBomKittingVersion.setBizId(req.getSchedulingVersionId())
        .setVersionCreateParam(JSON.toJSONString(req)).setKittingVersionSource("排产");

    // 遍历订单 扣除库存
    Map<Long, Map<Long, List<ApsGoodsBom>>> apsBomListMap = this.apsGoodsBomService.list(
            new LambdaQueryWrapper<ApsGoodsBom>().in(ApsGoodsBom::getGoodsId, goodIsList)).stream()
        .collect(Collectors.groupingBy(ApsGoodsBom::getGoodsId,
            Collectors.groupingBy(ApsGoodsBom::getBomId)));

    // 获取所有内层Map的键集合（第二个Long集合）
    Set<Long> bomIdSet = apsBomListMap.values().stream()
        .flatMap(innerMap -> innerMap.keySet().stream()).collect(Collectors.toSet());

    Map<Long, List<ApsOrderGoodsBom>> orderApsGoodsBomMap = this.apsOrderGoodsBomService.list(
            new LambdaQueryWrapper<ApsOrderGoodsBom>().in(ApsOrderGoodsBom::getOrderId, orderIdList))
        .stream().collect(Collectors.groupingBy(ApsOrderGoodsBom::getOrderId));

    Map<Long, ApsBom> apsBomMap = this.apsBomService.listByIds(bomIdSet).stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));

    orderIdList.forEach((orderId) -> {
      Map<String, Object> orderFieldsMap = allOrderFieldMap.get(orderId);
      if (CollUtil.isEmpty(orderFieldsMap)) {
        return;
      }
      List<ApsOrderGoodsBomKittingVersionOrderBom> apsOrderGoodsBomKittingVersionOrderBomListTmp = new ArrayList<>();

      Map<Long, BigDecimal> bomIdAndUseMap = orderApsGoodsBomMap.getOrDefault(orderId, List.of())
          .stream().collect(Collectors.groupingBy(ApsOrderGoodsBom::getBomId,
              Collectors.collectingAndThen(Collectors.toList(),
                  list -> list.stream().map(ApsOrderGoodsBom::getBomUsage)
                      .reduce(BigDecimal.ZERO, BigDecimal::add))));
      bomIdAndUseMap.forEach((k, v) -> {
        ApsBom apsBom = apsBomMap.get(k);
        ApsOrderGoodsBomKittingVersionOrderBom versionOrderItem = new ApsOrderGoodsBomKittingVersionOrderBom();
        BigDecimal lastCount = apsBom.getBomInventory().subtract(v);
        versionOrderItem.setBomId(k).setFactoryId((Long) orderFieldsMap.get(ApsStr.FACTORY_ID))
            .setOrderId((Long) orderFieldsMap.get(ApsStr.ORDER_ID))
            .setOrderNo((String) orderFieldsMap.get(ORDER_NO)).setGoodsName(
                apsGoodsMap.get((Long) orderFieldsMap.get(ApsStr.GOODS_ID)).getGoodsName())
            .setBomUsage(v).setInventoryBeforeCount(apsBom.getBomInventory())
            .setInventoryAfterCount(lastCount);
        versionOrderItem.setKittingVersionId(apsOrderGoodsBomKittingVersion.getId())
            .setId(IdUtils.getId());

        versionOrderItem.setIsEnough(
            versionOrderItem.getInventoryAfterCount().compareTo(BigDecimal.ZERO) >= 0);
        apsOrderGoodsBomKittingVersionOrderBomListTmp.add(versionOrderItem);
        apsBom.setBomInventory(versionOrderItem.getInventoryAfterCount());
        versionOrderItem.setBomName(apsBom.getBomName());
        // 如果库存 <= 0   缺少数量 = 使用量
        if (BigDecimal.ZERO.compareTo(v) <= 0) {
          versionOrderItem.setLackQuantity(v);
        } else {
          // 如果 库存 - 使用量 > 0 , 缺失数 =0
          if (lastCount.compareTo(BigDecimal.ZERO) >= 0) {
            versionOrderItem.setLackQuantity(BigDecimal.ZERO);
          } else {
            versionOrderItem.setLackQuantity(lastCount.abs());
          }
        }


      });

      apsOrderGoodsBomKittingVersionOrderBomList.addAll(
          apsOrderGoodsBomKittingVersionOrderBomListTmp);

      Map<Long, BigDecimal> lackApsBomMapTmp = apsOrderGoodsBomKittingVersionOrderBomListTmp.stream()
          .filter(tt -> !Boolean.TRUE.equals(tt.getIsEnough())).collect(
              Collectors.groupingBy(ApsOrderGoodsBomKittingVersionOrderBom::getBomId,
                  Collectors.collectingAndThen(Collectors.toList(),
                      r -> r.stream()
                          .map(ApsOrderGoodsBomKittingVersionOrderBom::getLackQuantity)
                          .reduce(BigDecimal.ZERO, BigDecimal::add))));
      ApsOrderGoodsBomKittingVersionOrder versionOrder = new ApsOrderGoodsBomKittingVersionOrder();

      if (CollUtil.isNotEmpty(lackApsBomMapTmp)) {
        lackApsBomMapTmp.forEach((kk, vv) -> {
          lackApsBomMap.merge(kk, vv, BigDecimal::add);
        });

        List<KVEntity> lackList = lackApsBomMapTmp.entrySet().stream()
            // 扁平化处理，将每个外部键与其内部映射的值组合
//            .flatMap(outerEntry -> outerEntry.getValue().values().stream()
            .map(((k) -> new KeyValue(k.getKey(), k.getValue())))
            // 按值降序排序
            .sorted(Comparator.comparing(KeyValue::value).reversed())
            // 取前10个
            .map((e) -> new KVEntity().setLabel(apsBomMap.get(e.key()).getBomName())
                .setValue(e.value().toString())).toList();
        versionOrder.setKittingMissingBom(lackList).setKittingStatus("未齐套");
        versionOrder.setKittingRate(
            new BigDecimal(bomIdAndUseMap.size() - lackApsBomMapTmp.size()).multiply(
                    multiplicand_100)
                .divide(new BigDecimal(bomIdAndUseMap.size()), 5,
                    ROUNDING_MODE));
      } else {
        versionOrder.setKittingStatus("齐套");
        versionOrder.setKittingRate(multiplicand_100);
      }
      versionOrder.setOrderId((Long) orderFieldsMap.get(ApsStr.ORDER_ID))
          .setKittingVersionId(apsOrderGoodsBomKittingVersion.getId())
          .setFactoryId((Long) orderFieldsMap.get(ApsStr.FACTORY_ID))
          .setOrderNo((String) orderFieldsMap.get(ORDER_NO));
      versionOrder.setNumberIndex((Long) orderFieldsMap.get("numberIndex"));
      AtomicInteger fieldIndex = new AtomicInteger(1);

      if (CollUtil.isNotEmpty(kittingTemplateOrderConfigList)) {
        kittingTemplateOrderConfigList.forEach(
            tc -> setOrderValue(fieldIndex, versionOrder, orderFieldsMap, tc.getValue()));
      }
      if (CollUtil.isNotEmpty(kittingTemplateOrderUserConfigList)) {
        kittingTemplateOrderUserConfigList.forEach(
            tc -> setOrderValue(fieldIndex, versionOrder, orderFieldsMap, tc.getValue()));
      }

      if (CollUtil.isNotEmpty(kittingTemplateSaleConfigList)) {
        kittingTemplateSaleConfigList.forEach(
            tc -> setOrderValue(fieldIndex, versionOrder, orderFieldsMap,
                "sale_" + tc.getValue() + "_name"));
      }
      versionOrder.setNumberIndex((Long) orderFieldsMap.get("numberIndex"));
      apsOrderGoodsBomKittingVersionOrderList.add(versionOrder);
    });

    long orderCount = allOrderFieldMap.size();
    apsOrderGoodsBomKittingVersion.setOrderCount(orderCount);
    if (CollUtil.isNotEmpty(lackApsBomMap)) {
      List<KVEntity> lockList = lackApsBomMap.entrySet().stream().sorted(
          Entry.<Long, BigDecimal>comparingByValue(Comparator.reverseOrder())
              .thenComparing(Entry::getKey)).map(
          (e) -> new KVEntity().setLabel(apsBomMap.get(e.getKey()).getBomName())
              .setValue(e.getValue().toString())).toList();
      apsOrderGoodsBomKittingVersion.setKittingMissingBom(lockList).setKittingStatus("未齐套");
      long failCount = apsOrderGoodsBomKittingVersionOrderList.stream()
          .filter(t -> t.getKittingRate().compareTo(multiplicand_100) < 0).count();
      apsOrderGoodsBomKittingVersion.setKittingSuccessCount(orderCount - failCount)
          .setKittingFailCount(failCount).setKittingRate(
              new BigDecimal(orderCount - failCount).multiply(multiplicand_100)
                  .divide(new BigDecimal(orderCount), 5,
                      ROUNDING_MODE));
    } else {
      apsOrderGoodsBomKittingVersion.setKittingStatus("齐套").setKittingRate(multiplicand_100);
      apsOrderGoodsBomKittingVersion.setKittingSuccessCount(orderCount).setKittingFailCount(0L);
    }

    this.apsOrderGoodsBomKittingVersionOrderItemService.saveBatch(
        apsOrderGoodsBomKittingVersionOrderBomList);
    this.apsOrderGoodsBomKittingVersionOrderService.saveBatch(
        apsOrderGoodsBomKittingVersionOrderList);
    apsOrderGoodsBomKittingVersionService.save(apsOrderGoodsBomKittingVersion);

    return null;
  }

  private String getNextVersionNo() {
    ApsOrderGoodsBomKittingVersion apsOrderGoodsBomKittingVersion = this.apsOrderGoodsBomKittingVersionService
        .getOne(new LambdaQueryWrapper<ApsOrderGoodsBomKittingVersion>().eq(
                ApsOrderGoodsBomKittingVersion::getCreateDate, LocalDate.now())
            .orderByDesc(ApsOrderGoodsBomKittingVersion::getKittingVersionNo).last(Str.LIMIT_1));
    if (Objects.isNull(apsOrderGoodsBomKittingVersion)) {
      return LocalDate.now() + "-0001";
    }
    return LocalDate.now() + "-" + StringUtils.right("000" + (
        Integer.parseInt(StringUtils.right(apsOrderGoodsBomKittingVersion.getKittingVersionNo(), 4))
            + 1), 4);
  }

//  private ApsOrderGoodsBomKittingVersionService apsOrderGoodsBomKittingVersionService() {
//    return SpringUtil.getBean(ApsOrderGoodsBomKittingVersionService.class);
//  }

  // 记录类用于存储键值对
  private record KeyValue(Long key, BigDecimal value) {

  }
}
