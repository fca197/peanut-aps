package com.olivia.peanut.aps.api.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrder;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrder.*;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingVersionOrderApi;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 齐套检查订单详情(ApsOrderGoodsBomKittingVersionOrder)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 14:23:48
 */
@RestController
public class ApsOrderGoodsBomKittingVersionOrderApiImpl implements
    ApsOrderGoodsBomKittingVersionOrderApi {

  private @Autowired ApsOrderGoodsBomKittingVersionOrderService apsOrderGoodsBomKittingVersionOrderService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderInsertRes insert(
      ApsOrderGoodsBomKittingVersionOrderInsertReq req) {
    ApsOrderGoodsBomKittingVersionOrder apsOrderGoodsBomKittingVersionOrder = INSTANCE.insertReq(
        req);
    this.apsOrderGoodsBomKittingVersionOrderService.save(apsOrderGoodsBomKittingVersionOrder);
    return new ApsOrderGoodsBomKittingVersionOrderInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsBomKittingVersionOrderDeleteByIdListReq req) {
    apsOrderGoodsBomKittingVersionOrderService.removeByIds(req.getIdList());
    return new ApsOrderGoodsBomKittingVersionOrderDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderQueryListReq req) {
    return apsOrderGoodsBomKittingVersionOrderService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderUpdateByIdRes updateById(
      ApsOrderGoodsBomKittingVersionOrderUpdateByIdReq req) {
    apsOrderGoodsBomKittingVersionOrderService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderGoodsBomKittingVersionOrderUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req) {
    return apsOrderGoodsBomKittingVersionOrderService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsOrderGoodsBomKittingVersionOrderExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderGoodsBomKittingVersionOrderExportQueryPageListInfoRes.class, list,
        "齐套检查订单详情");
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsBomKittingVersionOrderImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsBomKittingVersionOrderImportListener(),
        ApsOrderGoodsBomKittingVersionOrderImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsBomKittingVersionOrder> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderGoodsBomKittingVersionOrderService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsBomKittingVersionOrderImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsBomKittingVersionOrderQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder> q = new MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrder>(
        ApsOrderGoodsBomKittingVersionOrder.class)
        .selectAll(ApsOrderGoodsBomKittingVersionOrder.class)
        .in(ApsOrderGoodsBomKittingVersionOrder::getId, req.getIdList());
    List<ApsOrderGoodsBomKittingVersionOrder> list = this.apsOrderGoodsBomKittingVersionOrderService.list(
        q);
    List<ApsOrderGoodsBomKittingVersionOrderDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderGoodsBomKittingVersionOrderService.setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderQueryByIdListRes().setDataList(dataList);
  }
}
