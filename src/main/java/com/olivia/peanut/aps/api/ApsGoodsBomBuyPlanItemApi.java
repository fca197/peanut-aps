package com.olivia.peanut.aps.api;

import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemImportRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemInsertReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemInsertRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryListReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemQueryListRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.ApsGoodsBomBuyPlanItemUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.SendMail2supplierReq;
import com.olivia.peanut.aps.api.entity.apsGoodsBomBuyPlanItem.SendMail2supplierRes;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * BOM 购买清单(ApsGoodsBomBuyPlanItem)对外API
 *
 * @author peanut
 * @since 2024-06-05 14:35:30
 */
// @FeignClient(value = "",contextId = "apsGoodsBomBuyPlanItem-api",url = "${ portal..center.endpoint:}")
public interface ApsGoodsBomBuyPlanItemApi {

  /**
   * 保存 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/insert")
  ApsGoodsBomBuyPlanItemInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsGoodsBomBuyPlanItemInsertReq req);

  /**
   * 根据ID 删除 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/deleteByIdList")
  ApsGoodsBomBuyPlanItemDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsGoodsBomBuyPlanItemDeleteByIdListReq req);

  /**
   * 查询 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/queryList")
  ApsGoodsBomBuyPlanItemQueryListRes queryList(
      @RequestBody @Valid ApsGoodsBomBuyPlanItemQueryListReq req);

  /**
   * 根据ID 更新 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/updateById")
  ApsGoodsBomBuyPlanItemUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsGoodsBomBuyPlanItemUpdateByIdReq req);

  /**
   * 分页查询 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/queryPageList")
  DynamicsPage<ApsGoodsBomBuyPlanItemExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsGoodsBomBuyPlanItemExportQueryPageListReq req);

  /**
   * 导出 BOM 购买清单
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid ApsGoodsBomBuyPlanItemExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/importData")
  ApsGoodsBomBuyPlanItemImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsGoodsBomBuyPlanItem/queryByIdList")
  ApsGoodsBomBuyPlanItemQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsGoodsBomBuyPlanItemQueryByIdListReq req);


  @RequestMapping("/apsGoodsBomBuyPlanItem/sendMail2supplier")
  SendMail2supplierRes sendMail2supplier(@RequestBody @Valid SendMail2supplierReq req);
}
