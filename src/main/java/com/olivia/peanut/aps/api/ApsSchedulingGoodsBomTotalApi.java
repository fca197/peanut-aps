package com.olivia.peanut.aps.api;


import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalCreateBomBuyPlanReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalCreateBomBuyPlanRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalImportRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalInsertReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalInsertRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryBomTotalReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryBomTotalRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryListReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalQueryListRes;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsSchedulingGoodsBomTotal.ApsSchedulingGoodsBomTotalUpdateByIdRes;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 订单商品零件汇总表(ApsSchedulingGoodsBomTotal)对外API
 *
 * @author peanut
 * @since 2024-06-02 22:04:07
 */
// @FeignClient(value = "",contextId = "apsSchedulingGoodsBomTotal-api",url = "${ portal..center.endpoint:}")
public interface ApsSchedulingGoodsBomTotalApi {

  /**
   * 保存 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/insert")
  ApsSchedulingGoodsBomTotalInsertRes insert(
      @RequestBody @Validated(InsertCheck.class) ApsSchedulingGoodsBomTotalInsertReq req);

  /**
   * 根据ID 删除 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/deleteByIdList")
  ApsSchedulingGoodsBomTotalDeleteByIdListRes deleteByIdList(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalDeleteByIdListReq req);

  /**
   * 查询 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/queryList")
  ApsSchedulingGoodsBomTotalQueryListRes queryList(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalQueryListReq req);

  /**
   * 根据ID 更新 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/updateById")
  ApsSchedulingGoodsBomTotalUpdateByIdRes updateById(
      @RequestBody @Validated(UpdateCheck.class) ApsSchedulingGoodsBomTotalUpdateByIdReq req);

  /**
   * 分页查询 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/queryPageList")
  DynamicsPage<ApsSchedulingGoodsBomTotalExportQueryPageListInfoRes> queryPageList(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalExportQueryPageListReq req);

  /**
   * 导出 订单商品零件汇总表
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/exportQueryPageList")
  void queryPageListExport(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/importData")
  ApsSchedulingGoodsBomTotalImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/apsSchedulingGoodsBomTotal/queryByIdList")
  ApsSchedulingGoodsBomTotalQueryByIdListRes queryByIdListRes(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalQueryByIdListReq req);

  @PostMapping("/apsSchedulingGoodsBomTotal/queryBomTotal")
  DynamicsPage<ApsSchedulingGoodsBomTotalQueryBomTotalRes> queryBomTotal(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalQueryBomTotalReq req);

  @PostMapping("/apsSchedulingGoodsBomTotal/createBomBuyPlan")
  ApsSchedulingGoodsBomTotalCreateBomBuyPlanRes createBomBuyPlan(
      @RequestBody @Valid ApsSchedulingGoodsBomTotalCreateBomBuyPlanReq req);


}
