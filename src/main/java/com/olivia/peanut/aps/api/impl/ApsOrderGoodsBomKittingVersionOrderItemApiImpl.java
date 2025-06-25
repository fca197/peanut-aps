package com.olivia.peanut.aps.api.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderItem;
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
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderItem.*;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderItemService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingVersionOrderItemApi;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderItemConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 20:30:05
 */
@RestController
public class ApsOrderGoodsBomKittingVersionOrderItemApiImpl implements
    ApsOrderGoodsBomKittingVersionOrderItemApi {

  private @Autowired ApsOrderGoodsBomKittingVersionOrderItemService apsOrderGoodsBomKittingVersionOrderItemService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderItemInsertRes insert(
      ApsOrderGoodsBomKittingVersionOrderItemInsertReq req) {
    ApsOrderGoodsBomKittingVersionOrderItem apsOrderGoodsBomKittingVersionOrderItem = INSTANCE.insertReq(
        req);
    this.apsOrderGoodsBomKittingVersionOrderItemService.save(
        apsOrderGoodsBomKittingVersionOrderItem);
    return new ApsOrderGoodsBomKittingVersionOrderItemInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderItemDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsBomKittingVersionOrderItemDeleteByIdListReq req) {
    apsOrderGoodsBomKittingVersionOrderItemService.removeByIds(req.getIdList());
    return new ApsOrderGoodsBomKittingVersionOrderItemDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderItemQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderItemQueryListReq req) {
    return apsOrderGoodsBomKittingVersionOrderItemService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdRes updateById(
      ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdReq req) {
    apsOrderGoodsBomKittingVersionOrderItemService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderGoodsBomKittingVersionOrderItemUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req) {
    return apsOrderGoodsBomKittingVersionOrderItemService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderGoodsBomKittingVersionOrderItemExportQueryPageListInfoRes.class,
        list, "齐套检查版本详情");
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderItemImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsBomKittingVersionOrderItemImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsBomKittingVersionOrderItemImportListener(),
        ApsOrderGoodsBomKittingVersionOrderItemImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsBomKittingVersionOrderItem> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderGoodsBomKittingVersionOrderItemService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsBomKittingVersionOrderItemImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderItemQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsBomKittingVersionOrderItemQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem> q = new MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderItem>(
        ApsOrderGoodsBomKittingVersionOrderItem.class)
        .selectAll(ApsOrderGoodsBomKittingVersionOrderItem.class)
        .in(ApsOrderGoodsBomKittingVersionOrderItem::getId, req.getIdList());
    List<ApsOrderGoodsBomKittingVersionOrderItem> list = this.apsOrderGoodsBomKittingVersionOrderItemService.list(
        q);
    List<ApsOrderGoodsBomKittingVersionOrderItemDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderGoodsBomKittingVersionOrderItemService.setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderItemQueryByIdListRes().setDataList(dataList);
  }
}
