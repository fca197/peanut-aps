package com.olivia.peanut.aps.api.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsGoodsBomApi;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomDto;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomImportReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomImportRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.ApsGoodsBomUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.CheckBomUseExpressionReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.CheckBomUseExpressionRes;
import com.olivia.peanut.aps.api.impl.listener.ApsGoodsBomImportListener;
import com.olivia.peanut.aps.model.ApsGoodsBom;
import com.olivia.peanut.aps.service.ApsGoodsBomService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsGoodsBom)表服务实现类
 *
 * @author peanut
 * @since 2024-04-03 22:28:55
 */
@RestController
public class ApsGoodsBomApiImpl implements ApsGoodsBomApi {

  private @Autowired ApsGoodsBomService apsGoodsBomService;

  /****
   * insert
   *
   */
  public @Override ApsGoodsBomInsertRes insert(ApsGoodsBomInsertReq req) {

    checkStationHasBom(req);

    this.apsGoodsBomService.save($.copy(req, ApsGoodsBom.class));
    return new ApsGoodsBomInsertRes().setCount(1);
  }

  private void checkStationHasBom(ApsGoodsBomDto req) {
    long count = this.apsGoodsBomService.count(
        new LambdaQueryWrapper<ApsGoodsBom>().eq(ApsGoodsBom::getBomId, req.getBomId())
            .eq(ApsGoodsBom::getBomUseWorkStation, req.getBomUseWorkStation()));
    $.assertTrueCanIgnoreException(count > 0, "该工位已存在当前零件");
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsGoodsBomDeleteByIdListRes deleteByIdList(ApsGoodsBomDeleteByIdListReq req) {
    apsGoodsBomService.removeByIds(req.getIdList());
    return new ApsGoodsBomDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsGoodsBomQueryListRes queryList(ApsGoodsBomQueryListReq req) {
    return apsGoodsBomService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsGoodsBomUpdateByIdRes updateById(ApsGoodsBomUpdateByIdReq req) {
    checkStationHasBom(req);
    apsGoodsBomService.updateById($.copy(req, ApsGoodsBom.class));
    return new ApsGoodsBomUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsGoodsBomExportQueryPageListInfoRes> queryPageList(
      ApsGoodsBomExportQueryPageListReq req) {
    return apsGoodsBomService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsGoodsBomExportQueryPageListReq req) {
    DynamicsPage<ApsGoodsBomExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsGoodsBomExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsGoodsBomExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsGoodsBomExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsGoodsBomExportQueryPageListInfoRes.class, listInfoRes, "");
  }

  public @Override ApsGoodsBomImportRes importData(@RequestParam("file") MultipartFile file) {
    List<ApsGoodsBomImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsGoodsBomImportListener(), ApsGoodsBomImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsGoodsBom> readList = $.copyList(reqList, ApsGoodsBom.class);
    boolean bool = apsGoodsBomService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsGoodsBomImportRes().setCount(c);
  }

  public @Override ApsGoodsBomQueryByIdListRes queryByIdListRes(ApsGoodsBomQueryByIdListReq req) {
    MPJLambdaWrapper<ApsGoodsBom> q = new MPJLambdaWrapper<ApsGoodsBom>(
        ApsGoodsBom.class).selectAll(ApsGoodsBom.class).in(ApsGoodsBom::getId, req.getIdList());
    List<ApsGoodsBom> list = this.apsGoodsBomService.list(q);
    List<ApsGoodsBomDto> dataList = $.copyList(list, ApsGoodsBomDto.class);
    return new ApsGoodsBomQueryByIdListRes().setDataList(dataList);
  }

  @Override
  public CheckBomUseExpressionRes checkBomUseExpression(CheckBomUseExpressionReq req) {
    return this.apsGoodsBomService.checkBomUseExpression(req);
  }
}
