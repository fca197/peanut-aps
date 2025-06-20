package com.olivia.peanut.aps.api.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsMakeCapacityGoodsApi;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsDto;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsImportReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsImportRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsInsertReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsInsertRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsQueryListReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsQueryListRes;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsMakeCapacityGoods.ApsMakeCapacityGoodsUpdateByIdRes;
import com.olivia.peanut.aps.api.impl.listener.ApsMakeCapacityGoodsImportListener;
import com.olivia.peanut.aps.model.ApsMakeCapacityGoods;
import com.olivia.peanut.aps.service.ApsMakeCapacityGoodsService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsMakeCapacityGoods)表服务实现类
 *
 * @author peanut
 * @since 2024-04-13 12:05:05
 */
@RestController
public class ApsMakeCapacityGoodsApiImpl implements ApsMakeCapacityGoodsApi {

  private @Autowired ApsMakeCapacityGoodsService apsMakeCapacityGoodsService;

  /****
   * insert
   *
   */
  public @Override ApsMakeCapacityGoodsInsertRes insert(ApsMakeCapacityGoodsInsertReq req) {
    return this.apsMakeCapacityGoodsService.save(req);

  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsMakeCapacityGoodsDeleteByIdListRes deleteByIdList(
      ApsMakeCapacityGoodsDeleteByIdListReq req) {
    apsMakeCapacityGoodsService.removeByIds(req.getIdList());
    return new ApsMakeCapacityGoodsDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsMakeCapacityGoodsQueryListRes queryList(
      ApsMakeCapacityGoodsQueryListReq req) {
    return apsMakeCapacityGoodsService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsMakeCapacityGoodsUpdateByIdRes updateById(
      ApsMakeCapacityGoodsUpdateByIdReq req) {
    apsMakeCapacityGoodsService.updateById($.copy(req, ApsMakeCapacityGoods.class));
    return new ApsMakeCapacityGoodsUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsMakeCapacityGoodsExportQueryPageListInfoRes> queryPageList(
      ApsMakeCapacityGoodsExportQueryPageListReq req) {
    return apsMakeCapacityGoodsService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsMakeCapacityGoodsExportQueryPageListReq req) {
    DynamicsPage<ApsMakeCapacityGoodsExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsMakeCapacityGoodsExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsMakeCapacityGoodsExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsMakeCapacityGoodsExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsMakeCapacityGoodsExportQueryPageListInfoRes.class, listInfoRes, "");
  }

  public @Override ApsMakeCapacityGoodsImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsMakeCapacityGoodsImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsMakeCapacityGoodsImportListener(), ApsMakeCapacityGoodsImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsMakeCapacityGoods> readList = $.copyList(reqList, ApsMakeCapacityGoods.class);
    boolean bool = apsMakeCapacityGoodsService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsMakeCapacityGoodsImportRes().setCount(c);
  }

  public @Override ApsMakeCapacityGoodsQueryByIdListRes queryByIdListRes(
      ApsMakeCapacityGoodsQueryByIdListReq req) {
    MPJLambdaWrapper<ApsMakeCapacityGoods> q = new MPJLambdaWrapper<ApsMakeCapacityGoods>(
        ApsMakeCapacityGoods.class)
        .selectAll(ApsMakeCapacityGoods.class).in(ApsMakeCapacityGoods::getId, req.getIdList());
    List<ApsMakeCapacityGoods> list = this.apsMakeCapacityGoodsService.list(q);
    List<ApsMakeCapacityGoodsDto> dataList = $.copyList(list, ApsMakeCapacityGoodsDto.class);
    this.apsMakeCapacityGoodsService.setName(dataList);
    return new ApsMakeCapacityGoodsQueryByIdListRes().setDataList(dataList);
  }
}
