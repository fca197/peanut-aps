package com.olivia.peanut.aps.api.impl;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingTemplateConverter.INSTANCE;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingTemplateApi;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingTemplate.*;
import com.olivia.peanut.aps.api.impl.listener.ApsOrderGoodsBomKittingTemplateImportListener;
import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingTemplate;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingTemplateService;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
