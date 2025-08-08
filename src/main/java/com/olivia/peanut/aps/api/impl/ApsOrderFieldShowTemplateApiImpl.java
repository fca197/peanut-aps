package com.olivia.peanut.aps.api.impl;

import static com.olivia.peanut.aps.converter.ApsOrderFieldShowTemplateConverter.INSTANCE;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsOrderFieldShowTemplateApi;
import com.olivia.peanut.aps.api.entity.apsOrderFieldShowTemplate.*;
import com.olivia.peanut.aps.api.impl.listener.ApsOrderFieldShowTemplateImportListener;
import com.olivia.peanut.aps.model.ApsOrderFieldShowTemplate;
import com.olivia.peanut.aps.service.ApsOrderFieldShowTemplateService;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 订单显示模板(ApsOrderFieldShowTemplate)表服务实现类
 *
 * @author admin
 * @since 2025-07-11 17:32:00
 */
@RestController
public class ApsOrderFieldShowTemplateApiImpl implements ApsOrderFieldShowTemplateApi {

  private @Autowired ApsOrderFieldShowTemplateService apsOrderFieldShowTemplateService;

  /****
   * insert
   *
   */
  public @Override ApsOrderFieldShowTemplateInsertRes insert(
      ApsOrderFieldShowTemplateInsertReq req) {
    ApsOrderFieldShowTemplate apsOrderFieldShowTemplate = INSTANCE.insertReq(req);
    this.apsOrderFieldShowTemplateService.save(apsOrderFieldShowTemplate);
    return new ApsOrderFieldShowTemplateInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderFieldShowTemplateDeleteByIdListRes deleteByIdList(
      ApsOrderFieldShowTemplateDeleteByIdListReq req) {
    apsOrderFieldShowTemplateService.removeByIds(req.getIdList());
    return new ApsOrderFieldShowTemplateDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderFieldShowTemplateQueryListRes queryList(
      ApsOrderFieldShowTemplateQueryListReq req) {
    return apsOrderFieldShowTemplateService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderFieldShowTemplateUpdateByIdRes updateById(
      ApsOrderFieldShowTemplateUpdateByIdReq req) {
    apsOrderFieldShowTemplateService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderFieldShowTemplateUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> queryPageList(
      ApsOrderFieldShowTemplateExportQueryPageListReq req) {
    return apsOrderFieldShowTemplateService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsOrderFieldShowTemplateExportQueryPageListReq req) {
    DynamicsPage<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsOrderFieldShowTemplateExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderFieldShowTemplateExportQueryPageListInfoRes.class, list,
        "订单显示模板");
  }

  public @Override ApsOrderFieldShowTemplateImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderFieldShowTemplateImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderFieldShowTemplateImportListener(), ApsOrderFieldShowTemplateImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderFieldShowTemplate> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderFieldShowTemplateService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderFieldShowTemplateImportRes().setCount(c);
  }

  public @Override ApsOrderFieldShowTemplateQueryByIdListRes queryByIdListRes(
      ApsOrderFieldShowTemplateQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderFieldShowTemplate> q = new MPJLambdaWrapper<ApsOrderFieldShowTemplate>(
        ApsOrderFieldShowTemplate.class)
        .selectAll(ApsOrderFieldShowTemplate.class)
        .in(ApsOrderFieldShowTemplate::getId, req.getIdList());
    List<ApsOrderFieldShowTemplate> list = this.apsOrderFieldShowTemplateService.list(q);
    List<ApsOrderFieldShowTemplateDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderFieldShowTemplateService.setName(dataList);
    return new ApsOrderFieldShowTemplateQueryByIdListRes().setDataList(dataList);
  }
}
