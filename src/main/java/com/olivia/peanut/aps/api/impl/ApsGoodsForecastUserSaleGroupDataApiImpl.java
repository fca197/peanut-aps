package com.olivia.peanut.aps.api.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsGoodsForecastUserSaleGroupData;
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
import com.olivia.peanut.aps.api.entity.apsGoodsForecastUserSaleGroupData.*;
import com.olivia.peanut.aps.service.ApsGoodsForecastUserSaleGroupDataService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsGoodsForecastUserSaleGroupDataApi;

import static com.olivia.peanut.aps.converter.ApsGoodsForecastUserSaleGroupDataConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 预测销售组数据(ApsGoodsForecastUserSaleGroupData)表服务实现类
 *
 * @author admin
 * @since 2025-06-23 13:13:58
 */
@RestController
public class ApsGoodsForecastUserSaleGroupDataApiImpl implements
    ApsGoodsForecastUserSaleGroupDataApi {

  private @Autowired ApsGoodsForecastUserSaleGroupDataService apsGoodsForecastUserSaleGroupDataService;

  /****
   * insert
   *
   */
  public @Override ApsGoodsForecastUserSaleGroupDataInsertRes insert(
      ApsGoodsForecastUserSaleGroupDataInsertReq req) {
    ApsGoodsForecastUserSaleGroupData apsGoodsForecastUserSaleGroupData = INSTANCE.insertReq(req);
    this.apsGoodsForecastUserSaleGroupDataService.save(apsGoodsForecastUserSaleGroupData);
    return new ApsGoodsForecastUserSaleGroupDataInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsGoodsForecastUserSaleGroupDataDeleteByIdListRes deleteByIdList(
      ApsGoodsForecastUserSaleGroupDataDeleteByIdListReq req) {
    apsGoodsForecastUserSaleGroupDataService.removeByIds(req.getIdList());
    return new ApsGoodsForecastUserSaleGroupDataDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsGoodsForecastUserSaleGroupDataQueryListRes queryList(
      ApsGoodsForecastUserSaleGroupDataQueryListReq req) {
    return apsGoodsForecastUserSaleGroupDataService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsGoodsForecastUserSaleGroupDataUpdateByIdRes updateById(
      ApsGoodsForecastUserSaleGroupDataUpdateByIdReq req) {
    apsGoodsForecastUserSaleGroupDataService.updateById(INSTANCE.updateReq(req));
    return new ApsGoodsForecastUserSaleGroupDataUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> queryPageList(
      ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req) {
    return apsGoodsForecastUserSaleGroupDataService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsGoodsForecastUserSaleGroupDataExportQueryPageListReq req) {
    DynamicsPage<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsGoodsForecastUserSaleGroupDataExportQueryPageListInfoRes.class, list,
        "预测销售组数据");
  }

  public @Override ApsGoodsForecastUserSaleGroupDataImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsGoodsForecastUserSaleGroupDataImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsGoodsForecastUserSaleGroupDataImportListener(),
        ApsGoodsForecastUserSaleGroupDataImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsGoodsForecastUserSaleGroupData> readList = INSTANCE.importReq(reqList);
    boolean bool = apsGoodsForecastUserSaleGroupDataService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsGoodsForecastUserSaleGroupDataImportRes().setCount(c);
  }

  public @Override ApsGoodsForecastUserSaleGroupDataQueryByIdListRes queryByIdListRes(
      ApsGoodsForecastUserSaleGroupDataQueryByIdListReq req) {
    MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData> q = new MPJLambdaWrapper<ApsGoodsForecastUserSaleGroupData>(
        ApsGoodsForecastUserSaleGroupData.class)
        .selectAll(ApsGoodsForecastUserSaleGroupData.class)
        .in(ApsGoodsForecastUserSaleGroupData::getId, req.getIdList());
    List<ApsGoodsForecastUserSaleGroupData> list = this.apsGoodsForecastUserSaleGroupDataService.list(
        q);
    List<ApsGoodsForecastUserSaleGroupDataDto> dataList = INSTANCE.queryListRes(list);
    this.apsGoodsForecastUserSaleGroupDataService.setName(dataList);
    return new ApsGoodsForecastUserSaleGroupDataQueryByIdListRes().setDataList(dataList);
  }
}
