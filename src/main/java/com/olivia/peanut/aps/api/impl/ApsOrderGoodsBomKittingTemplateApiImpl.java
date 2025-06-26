package com.olivia.peanut.aps.api.impl;

import java.time.LocalDateTime;

import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
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
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingTemplateService;
import com.olivia.peanut.aps.model.*;
import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingTemplateApi;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingTemplateConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 齐套模板(ApsOrderGoodsBomKittingTemplate)表服务实现类
 *
 * @author admin
 * @since 2025-06-26 17:08:55
 */
@RestController
public class ApsOrderGoodsBomKittingTemplateApiImpl implements ApsOrderGoodsBomKittingTemplateApi {

  private @Autowired ApsOrderGoodsBomKittingTemplateService apsOrderGoodsBomKittingTemplateService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsBomKittingTemplateInsertRes insert(
      ApsOrderGoodsBomKittingTemplateInsertReq req) {
    ApsOrderGoodsBomKittingTemplate apsOrderGoodsBomKittingTemplate = INSTANCE.insertReq(req);
    this.apsOrderGoodsBomKittingTemplateService.save(apsOrderGoodsBomKittingTemplate);
    return new ApsOrderGoodsBomKittingTemplateInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsBomKittingTemplateDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsBomKittingTemplateDeleteByIdListReq req) {
    apsOrderGoodsBomKittingTemplateService.removeByIds(req.getIdList());
    return new ApsOrderGoodsBomKittingTemplateDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsBomKittingTemplateQueryListRes queryList(
      ApsOrderGoodsBomKittingTemplateQueryListReq req) {
    return apsOrderGoodsBomKittingTemplateService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsBomKittingTemplateUpdateByIdRes updateById(
      ApsOrderGoodsBomKittingTemplateUpdateByIdReq req) {
    apsOrderGoodsBomKittingTemplateService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderGoodsBomKittingTemplateUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req) {
    return apsOrderGoodsBomKittingTemplateService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsOrderGoodsBomKittingTemplateExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderGoodsBomKittingTemplateExportQueryPageListInfoRes.class, list,
        "齐套模板");
  }

  public @Override ApsOrderGoodsBomKittingTemplateImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsBomKittingTemplateImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsBomKittingTemplateImportListener(),
        ApsOrderGoodsBomKittingTemplateImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsBomKittingTemplate> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderGoodsBomKittingTemplateService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsBomKittingTemplateImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsBomKittingTemplateQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsBomKittingTemplateQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate> q = new MPJLambdaWrapper<ApsOrderGoodsBomKittingTemplate>(
        ApsOrderGoodsBomKittingTemplate.class)
        .selectAll(ApsOrderGoodsBomKittingTemplate.class)
        .in(ApsOrderGoodsBomKittingTemplate::getId, req.getIdList());
    List<ApsOrderGoodsBomKittingTemplate> list = this.apsOrderGoodsBomKittingTemplateService.list(
        q);
    List<ApsOrderGoodsBomKittingTemplateDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderGoodsBomKittingTemplateService.setName(dataList);
    return new ApsOrderGoodsBomKittingTemplateQueryByIdListRes().setDataList(dataList);
  }
}
