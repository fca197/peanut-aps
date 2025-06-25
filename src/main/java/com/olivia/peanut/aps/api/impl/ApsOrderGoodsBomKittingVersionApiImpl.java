package com.olivia.peanut.aps.api.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersion;
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
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.*;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingVersionApi;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 齐套检查版本(ApsOrderGoodsBomKittingVersion)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 10:13:07
 */
@RestController
public class ApsOrderGoodsBomKittingVersionApiImpl implements ApsOrderGoodsBomKittingVersionApi {

  private @Autowired ApsOrderGoodsBomKittingVersionService apsOrderGoodsBomKittingVersionService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionInsertRes insert(
      ApsOrderGoodsBomKittingVersionInsertReq req) {
    ApsOrderGoodsBomKittingVersion apsOrderGoodsBomKittingVersion = INSTANCE.insertReq(req);
    this.apsOrderGoodsBomKittingVersionService.save(apsOrderGoodsBomKittingVersion);
    return new ApsOrderGoodsBomKittingVersionInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsBomKittingVersionDeleteByIdListReq req) {
    apsOrderGoodsBomKittingVersionService.removeByIds(req.getIdList());
    return new ApsOrderGoodsBomKittingVersionDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionQueryListReq req) {
    return apsOrderGoodsBomKittingVersionService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionUpdateByIdRes updateById(
      ApsOrderGoodsBomKittingVersionUpdateByIdReq req) {
    apsOrderGoodsBomKittingVersionService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderGoodsBomKittingVersionUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionExportQueryPageListReq req) {
    return apsOrderGoodsBomKittingVersionService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsOrderGoodsBomKittingVersionExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderGoodsBomKittingVersionExportQueryPageListInfoRes.class, list,
        "齐套检查版本");
  }

  public @Override ApsOrderGoodsBomKittingVersionImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsBomKittingVersionImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsBomKittingVersionImportListener(),
        ApsOrderGoodsBomKittingVersionImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsBomKittingVersion> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderGoodsBomKittingVersionService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsBomKittingVersionImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsBomKittingVersionQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsBomKittingVersionQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion> q = new MPJLambdaWrapper<ApsOrderGoodsBomKittingVersion>(
        ApsOrderGoodsBomKittingVersion.class)
        .selectAll(ApsOrderGoodsBomKittingVersion.class)
        .in(ApsOrderGoodsBomKittingVersion::getId, req.getIdList());
    List<ApsOrderGoodsBomKittingVersion> list = this.apsOrderGoodsBomKittingVersionService.list(q);
    List<ApsOrderGoodsBomKittingVersionDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderGoodsBomKittingVersionService.setName(dataList);
    return new ApsOrderGoodsBomKittingVersionQueryByIdListRes().setDataList(dataList);
  }
}
