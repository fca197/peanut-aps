package com.olivia.peanut.aps.api.impl;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsOrderGoodsStatusDateApi;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateImportReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateImportRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsStatusDate.ApsOrderGoodsStatusDateUpdateByIdRes;
import com.olivia.peanut.aps.api.impl.listener.ApsOrderGoodsStatusDateImportListener;
import com.olivia.peanut.aps.model.ApsOrderGoodsStatusDate;
import com.olivia.peanut.aps.service.ApsOrderGoodsStatusDateService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 订单商品状态表(ApsOrderGoodsStatusDate)表服务实现类
 *
 * @author peanut
 * @since 2024-06-14 10:26:58
 */
@RestController
public class ApsOrderGoodsStatusDateApiImpl implements ApsOrderGoodsStatusDateApi {

  private @Autowired ApsOrderGoodsStatusDateService apsOrderGoodsStatusDateService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsStatusDateInsertRes insert(ApsOrderGoodsStatusDateInsertReq req) {
    this.apsOrderGoodsStatusDateService.save($.copy(req, ApsOrderGoodsStatusDate.class));
    return new ApsOrderGoodsStatusDateInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsStatusDateDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsStatusDateDeleteByIdListReq req) {
    apsOrderGoodsStatusDateService.removeByIds(req.getIdList());
    return new ApsOrderGoodsStatusDateDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsStatusDateQueryListRes queryList(
      ApsOrderGoodsStatusDateQueryListReq req) {
    return apsOrderGoodsStatusDateService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsStatusDateUpdateByIdRes updateById(
      ApsOrderGoodsStatusDateUpdateByIdReq req) {
    apsOrderGoodsStatusDateService.updateById($.copy(req, ApsOrderGoodsStatusDate.class));
    return new ApsOrderGoodsStatusDateUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsStatusDateExportQueryPageListReq req) {
    return apsOrderGoodsStatusDateService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsOrderGoodsStatusDateExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsStatusDateExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsOrderGoodsStatusDateExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsOrderGoodsStatusDateExportQueryPageListInfoRes.class, listInfoRes,
        "订单商品状态表");
  }

  public @Override ApsOrderGoodsStatusDateImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsStatusDateImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsStatusDateImportListener(), ApsOrderGoodsStatusDateImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsStatusDate> readList = $.copyList(reqList, ApsOrderGoodsStatusDate.class);
    boolean bool = apsOrderGoodsStatusDateService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsStatusDateImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsStatusDateQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsStatusDateQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsStatusDate> q = new MPJLambdaWrapper<ApsOrderGoodsStatusDate>(
        ApsOrderGoodsStatusDate.class)
        .selectAll(ApsOrderGoodsStatusDate.class)
        .in(ApsOrderGoodsStatusDate::getId, req.getIdList());
    List<ApsOrderGoodsStatusDate> list = this.apsOrderGoodsStatusDateService.list(q);
    List<ApsOrderGoodsStatusDateDto> dataList = $.copyList(list, ApsOrderGoodsStatusDateDto.class);
    this.apsOrderGoodsStatusDateService.setName(dataList);
    return new ApsOrderGoodsStatusDateQueryByIdListRes().setDataList(dataList);
  }
}
