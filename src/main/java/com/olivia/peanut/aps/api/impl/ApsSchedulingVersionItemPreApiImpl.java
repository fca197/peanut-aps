package com.olivia.peanut.aps.api.impl;

import static com.olivia.peanut.aps.converter.ApsSchedulingVersionItemPreConverter.INSTANCE;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsSchedulingVersionItemPreApi;
import com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre.*;
import com.olivia.peanut.aps.api.impl.listener.ApsSchedulingVersionItemPreImportListener;
import com.olivia.peanut.aps.model.ApsSchedulingVersionItemPre;
import com.olivia.peanut.aps.service.ApsSchedulingVersionItemPreService;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)表服务实现类
 *
 * @author makejava
 * @since 2025-04-06 14:16:39
 */
@RestController
public class ApsSchedulingVersionItemPreApiImpl implements ApsSchedulingVersionItemPreApi {

  private @Autowired ApsSchedulingVersionItemPreService apsSchedulingVersionItemPreService;

  /****
   * insert
   *
   */
  public @Override ApsSchedulingVersionItemPreInsertRes insert(
      ApsSchedulingVersionItemPreInsertReq req) {
    ApsSchedulingVersionItemPre apsSchedulingVersionItemPre = INSTANCE.insertReq(req);
    this.apsSchedulingVersionItemPreService.save(apsSchedulingVersionItemPre);
    return new ApsSchedulingVersionItemPreInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsSchedulingVersionItemPreDeleteByIdListRes deleteByIdList(
      ApsSchedulingVersionItemPreDeleteByIdListReq req) {
    apsSchedulingVersionItemPreService.removeByIds(req.getIdList());
    return new ApsSchedulingVersionItemPreDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsSchedulingVersionItemPreQueryListRes queryList(
      ApsSchedulingVersionItemPreQueryListReq req) {
    return apsSchedulingVersionItemPreService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsSchedulingVersionItemPreUpdateByIdRes updateById(
      ApsSchedulingVersionItemPreUpdateByIdReq req) {
    apsSchedulingVersionItemPreService.updateById(INSTANCE.updateReq(req));
    return new ApsSchedulingVersionItemPreUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> queryPageList(
      ApsSchedulingVersionItemPreExportQueryPageListReq req) {
    return apsSchedulingVersionItemPreService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsSchedulingVersionItemPreExportQueryPageListReq req) {
    DynamicsPage<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsSchedulingVersionItemPreExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsSchedulingVersionItemPreExportQueryPageListInfoRes.class, list,
        "排产下发订单预览");
  }

  public @Override ApsSchedulingVersionItemPreImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsSchedulingVersionItemPreImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsSchedulingVersionItemPreImportListener(),
        ApsSchedulingVersionItemPreImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsSchedulingVersionItemPre> readList = INSTANCE.importReq(reqList);
    boolean bool = apsSchedulingVersionItemPreService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsSchedulingVersionItemPreImportRes().setCount(c);
  }

  public @Override ApsSchedulingVersionItemPreQueryByIdListRes queryByIdListRes(
      ApsSchedulingVersionItemPreQueryByIdListReq req) {
    MPJLambdaWrapper<ApsSchedulingVersionItemPre> q = new MPJLambdaWrapper<ApsSchedulingVersionItemPre>(
        ApsSchedulingVersionItemPre.class)
        .selectAll(ApsSchedulingVersionItemPre.class)
        .in(ApsSchedulingVersionItemPre::getId, req.getIdList());
    List<ApsSchedulingVersionItemPre> list = this.apsSchedulingVersionItemPreService.list(q);
    List<ApsSchedulingVersionItemPreDto> dataList = INSTANCE.queryListRes(list);
    this.apsSchedulingVersionItemPreService.setName(dataList);
    return new ApsSchedulingVersionItemPreQueryByIdListRes().setDataList(dataList);
  }
}
