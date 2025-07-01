package com.olivia.peanut.aps.api.impl;

import com.olivia.peanut.aps.model.ApsOrderGoodsBomKittingVersionOrderBom;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersionOrderBom.*;
import com.olivia.peanut.aps.service.ApsOrderGoodsBomKittingVersionOrderItemService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.aps.api.ApsOrderGoodsBomKittingVersionOrderBomApi;

import static com.olivia.peanut.aps.converter.ApsOrderGoodsBomKittingVersionOrderBomConverter.*;

import com.olivia.peanut.aps.api.impl.listener.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 齐套检查版本详情(ApsOrderGoodsBomKittingVersionOrderItem)表服务实现类
 *
 * @author admin
 * @since 2025-06-25 20:30:05
 */
@RestController
public class ApsOrderGoodsBomKittingVersionOrderBomApiImpl implements
    ApsOrderGoodsBomKittingVersionOrderBomApi {

  private @Autowired ApsOrderGoodsBomKittingVersionOrderItemService apsOrderGoodsBomKittingVersionOrderItemService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderBomInsertRes insert(
      ApsOrderGoodsBomKittingVersionOrderBomInsertReq req) {
    ApsOrderGoodsBomKittingVersionOrderBom apsOrderGoodsBomKittingVersionOrderBom = INSTANCE.insertReq(
        req);
    this.apsOrderGoodsBomKittingVersionOrderItemService.save(
        apsOrderGoodsBomKittingVersionOrderBom);
    return new ApsOrderGoodsBomKittingVersionOrderBomInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListReq req) {
    apsOrderGoodsBomKittingVersionOrderItemService.removeByIds(req.getIdList());
    return new ApsOrderGoodsBomKittingVersionOrderBomDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderBomQueryListRes queryList(
      ApsOrderGoodsBomKittingVersionOrderBomQueryListReq req) {
    return apsOrderGoodsBomKittingVersionOrderItemService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdRes updateById(
      ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdReq req) {
    apsOrderGoodsBomKittingVersionOrderItemService.updateById(INSTANCE.updateReq(req));
    return new ApsOrderGoodsBomKittingVersionOrderBomUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req) {
    return apsOrderGoodsBomKittingVersionOrderItemService.queryPageList(req);
  }

  public @Override void queryPageListExport(
      ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> page = queryPageList(
        req);
    List<ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsOrderGoodsBomKittingVersionOrderBomExportQueryPageListInfoRes.class,
        list, "齐套检查版本详情");
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderBomImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsBomKittingVersionOrderBomImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsBomKittingVersionOrderItemImportListener(),
        ApsOrderGoodsBomKittingVersionOrderBomImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsBomKittingVersionOrderBom> readList = INSTANCE.importReq(reqList);
    boolean bool = apsOrderGoodsBomKittingVersionOrderItemService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsBomKittingVersionOrderBomImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom> q = new MPJLambdaWrapper<ApsOrderGoodsBomKittingVersionOrderBom>(
        ApsOrderGoodsBomKittingVersionOrderBom.class)
        .selectAll(ApsOrderGoodsBomKittingVersionOrderBom.class)
        .in(ApsOrderGoodsBomKittingVersionOrderBom::getId, req.getIdList());
    List<ApsOrderGoodsBomKittingVersionOrderBom> list = this.apsOrderGoodsBomKittingVersionOrderItemService.list(
        q);
    List<ApsOrderGoodsBomKittingVersionOrderBomDto> dataList = INSTANCE.queryListRes(list);
    this.apsOrderGoodsBomKittingVersionOrderItemService.setName(dataList);
    return new ApsOrderGoodsBomKittingVersionOrderBomQueryByIdListRes().setDataList(dataList);
  }
}
