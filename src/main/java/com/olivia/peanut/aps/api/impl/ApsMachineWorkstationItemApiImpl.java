package com.olivia.peanut.aps.api.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
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
import com.olivia.peanut.aps.api.entity.apsMachineWorkstationItem.*;
import com.olivia.peanut.aps.service.ApsMachineWorkstationItemService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsMachineWorkstationItemApi;

import static com.olivia.peanut.aps.converter.ApsMachineWorkstationItemConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * aps 生产机器 工作站机器配置(ApsMachineWorkstationItem)表服务实现类
 *
 * @author admin
 * @since 2025-07-23 13:20:07
 */
@RestController
public class ApsMachineWorkstationItemApiImpl implements ApsMachineWorkstationItemApi {

  private @Autowired ApsMachineWorkstationItemService apsMachineWorkstationItemService;

  /****
   * insert
   *
   */
  public @Override ApsMachineWorkstationItemInsertRes insert(
      ApsMachineWorkstationItemInsertReq req) {
    ApsMachineWorkstationItem apsMachineWorkstationItem = INSTANCE.insertReq(req);
    this.apsMachineWorkstationItemService.save(apsMachineWorkstationItem);
    return new ApsMachineWorkstationItemInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsMachineWorkstationItemDeleteByIdListRes deleteByIdList(
      ApsMachineWorkstationItemDeleteByIdListReq req) {
    apsMachineWorkstationItemService.removeByIds(req.getIdList());
    return new ApsMachineWorkstationItemDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsMachineWorkstationItemQueryListRes queryList(
      ApsMachineWorkstationItemQueryListReq req) {
    return apsMachineWorkstationItemService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsMachineWorkstationItemUpdateByIdRes updateById(
      ApsMachineWorkstationItemUpdateByIdReq req) {
    apsMachineWorkstationItemService.updateById(INSTANCE.updateReq(req));
    return new ApsMachineWorkstationItemUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationItemExportQueryPageListReq req) {
    return apsMachineWorkstationItemService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsMachineWorkstationItemExportQueryPageListReq req) {
    DynamicsPage<ApsMachineWorkstationItemExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsMachineWorkstationItemExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsMachineWorkstationItemExportQueryPageListInfoRes.class, list,
        "aps 生产机器 工作站机器配置");
  }

  public @Override ApsMachineWorkstationItemImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsMachineWorkstationItemImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsMachineWorkstationItemImportListener(), ApsMachineWorkstationItemImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsMachineWorkstationItem> readList = INSTANCE.importReq(reqList);
    boolean bool = apsMachineWorkstationItemService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsMachineWorkstationItemImportRes().setCount(c);
  }

  public @Override ApsMachineWorkstationItemQueryByIdListRes queryByIdListRes(
      ApsMachineWorkstationItemQueryByIdListReq req) {
    MPJLambdaWrapper<ApsMachineWorkstationItem> q = new MPJLambdaWrapper<ApsMachineWorkstationItem>(
        ApsMachineWorkstationItem.class)
        .selectAll(ApsMachineWorkstationItem.class)
        .in(ApsMachineWorkstationItem::getId, req.getIdList());
    List<ApsMachineWorkstationItem> list = this.apsMachineWorkstationItemService.list(q);
    List<ApsMachineWorkstationItemDto> dataList = INSTANCE.queryListRes(list);
    this.apsMachineWorkstationItemService.setName(dataList);
    return new ApsMachineWorkstationItemQueryByIdListRes().setDataList(dataList);
  }
}
