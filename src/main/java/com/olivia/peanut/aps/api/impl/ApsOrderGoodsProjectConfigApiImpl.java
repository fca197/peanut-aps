package com.olivia.peanut.aps.api.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsOrderGoodsProjectConfigApi;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigDto;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigImportReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigImportRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsProjectConfig.ApsOrderGoodsProjectConfigUpdateByIdRes;
import com.olivia.peanut.aps.api.impl.listener.ApsOrderGoodsProjectConfigImportListener;
import com.olivia.peanut.aps.model.ApsOrderGoodsProjectConfig;
import com.olivia.peanut.aps.service.ApsOrderGoodsProjectConfigService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsOrderGoodsProjectConfig)表服务实现类
 *
 * @author peanut
 * @since 2024-04-09 13:19:37
 */
@RestController
public class ApsOrderGoodsProjectConfigApiImpl implements ApsOrderGoodsProjectConfigApi {

  private @Autowired ApsOrderGoodsProjectConfigService apsOrderGoodsProjectConfigService;

  /****
   * insert
   *
   */
  public @Override ApsOrderGoodsProjectConfigInsertRes insert(
      ApsOrderGoodsProjectConfigInsertReq req) {
    this.apsOrderGoodsProjectConfigService.save($.copy(req, ApsOrderGoodsProjectConfig.class));
    return new ApsOrderGoodsProjectConfigInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderGoodsProjectConfigDeleteByIdListRes deleteByIdList(
      ApsOrderGoodsProjectConfigDeleteByIdListReq req) {
    apsOrderGoodsProjectConfigService.removeByIds(req.getIdList());
    return new ApsOrderGoodsProjectConfigDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderGoodsProjectConfigQueryListRes queryList(
      ApsOrderGoodsProjectConfigQueryListReq req) {
    return apsOrderGoodsProjectConfigService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderGoodsProjectConfigUpdateByIdRes updateById(
      ApsOrderGoodsProjectConfigUpdateByIdReq req) {
    apsOrderGoodsProjectConfigService.updateById($.copy(req, ApsOrderGoodsProjectConfig.class));
    return new ApsOrderGoodsProjectConfigUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> queryPageList(
      ApsOrderGoodsProjectConfigExportQueryPageListReq req) {
    return apsOrderGoodsProjectConfigService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsOrderGoodsProjectConfigExportQueryPageListReq req) {
    DynamicsPage<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsProjectConfigExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsOrderGoodsProjectConfigExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsOrderGoodsProjectConfigExportQueryPageListInfoRes.class, listInfoRes,
        "");
  }

  public @Override ApsOrderGoodsProjectConfigImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsOrderGoodsProjectConfigImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsOrderGoodsProjectConfigImportListener(), ApsOrderGoodsProjectConfigImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrderGoodsProjectConfig> readList = $.copyList(reqList,
        ApsOrderGoodsProjectConfig.class);
    boolean bool = apsOrderGoodsProjectConfigService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderGoodsProjectConfigImportRes().setCount(c);
  }

  public @Override ApsOrderGoodsProjectConfigQueryByIdListRes queryByIdListRes(
      ApsOrderGoodsProjectConfigQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrderGoodsProjectConfig> q = new MPJLambdaWrapper<ApsOrderGoodsProjectConfig>(
        ApsOrderGoodsProjectConfig.class)
        .selectAll(ApsOrderGoodsProjectConfig.class)
        .in(ApsOrderGoodsProjectConfig::getId, req.getIdList());
    List<ApsOrderGoodsProjectConfig> list = this.apsOrderGoodsProjectConfigService.list(q);
    List<ApsOrderGoodsProjectConfigDto> dataList = $.copyList(list,
        ApsOrderGoodsProjectConfigDto.class);
    this.apsOrderGoodsProjectConfigService.setName(dataList);
    return new ApsOrderGoodsProjectConfigQueryByIdListRes().setDataList(dataList);
  }
}
