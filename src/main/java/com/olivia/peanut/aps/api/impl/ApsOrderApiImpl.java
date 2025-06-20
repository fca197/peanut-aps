package com.olivia.peanut.aps.api.impl;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsOrderApi;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderBatchInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderDto;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderImportReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderImportRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderQueryListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderStatusEnum;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderTimeLineRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateByIdRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateOrderStatusReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateOrderStatusRes;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateSchedulingDateReq;
import com.olivia.peanut.aps.api.entity.apsOrder.ApsOrderUpdateSchedulingDateRes;
import com.olivia.peanut.aps.api.entity.apsOrder.FinishOrderTotalDayReq;
import com.olivia.peanut.aps.api.entity.apsOrder.FinishOrderTotalDayRes;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderCreateByMonthCountReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderCreateByMonthCountRes;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderFieldListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderFieldListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderStatusListReq;
import com.olivia.peanut.aps.api.entity.apsOrder.OrderStatusListRes;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountReq;
import com.olivia.peanut.aps.api.entity.apsOrder.StatusCountRes;
import com.olivia.peanut.aps.api.impl.listener.ApsOrderImportListener;
import com.olivia.peanut.aps.model.ApsOrder;
import com.olivia.peanut.aps.service.ApsOrderService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * (ApsOrder)表服务实现类
 *
 * @author peanut
 * @since 2024-04-09 13:19:35
 */
@RestController
public class ApsOrderApiImpl implements ApsOrderApi {

  private @Autowired ApsOrderService apsOrderService;

  /****
   * insert
   *
   */
  public @Override ApsOrderInsertRes insert(ApsOrderInsertReq req) {
    return this.apsOrderService.save(req);
//    return new ApsOrderInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsOrderDeleteByIdListRes deleteByIdList(ApsOrderDeleteByIdListReq req) {
    apsOrderService.removeByIds(req.getIdList());
    return new ApsOrderDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsOrderQueryListRes queryList(ApsOrderQueryListReq req) {
    return apsOrderService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsOrderUpdateByIdRes updateById(ApsOrderUpdateByIdReq req) {
    apsOrderService.updateById($.copy(req, ApsOrder.class));
    return new ApsOrderUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsOrderExportQueryPageListInfoRes> queryPageList(
      ApsOrderExportQueryPageListReq req) {
    return apsOrderService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsOrderExportQueryPageListReq req) {
    DynamicsPage<ApsOrderExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsOrderExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    List<ApsOrderExportQueryPageListInfoRes> listInfoRes = $.copyList(list,
        ApsOrderExportQueryPageListInfoRes.class);
    PoiExcelUtil.export(ApsOrderExportQueryPageListInfoRes.class, listInfoRes, "");
  }

  public @Override ApsOrderImportRes importData(@RequestParam("file") MultipartFile file) {
    List<ApsOrderImportReq> reqList = PoiExcelUtil.readData(file, new ApsOrderImportListener(),
        ApsOrderImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsOrder> readList = $.copyList(reqList, ApsOrder.class);
    boolean bool = apsOrderService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsOrderImportRes().setCount(c);
  }

  public @Override ApsOrderQueryByIdListRes queryByIdListRes(ApsOrderQueryByIdListReq req) {
    MPJLambdaWrapper<ApsOrder> q = new MPJLambdaWrapper<ApsOrder>(ApsOrder.class)
        .selectAll(ApsOrder.class).in(ApsOrder::getId, req.getIdList());
    List<ApsOrder> list = this.apsOrderService.list(q);
    List<ApsOrderDto> dataList = $.copyList(list, ApsOrderDto.class);
    this.apsOrderService.setName(dataList);
    return new ApsOrderQueryByIdListRes().setDataList(dataList);
  }

  @Override
  public DynamicsPage<ApsOrderTimeLineRes> timeLine(ApsOrderTimeLineReq req) {
    return this.apsOrderService.timeLine(req);
  }

  @Override
  public ApsOrderBatchInsertRes batchInsert(ApsOrderBatchInsertReq req) {
    return apsOrderService.saveBatch(req);
  }

  @Override
  public ApsOrderUpdateOrderStatusRes updateOrderStatus(ApsOrderUpdateOrderStatusReq req) {
    return this.apsOrderService.updateOrderStatus(req);
  }

  @Override
  public ApsOrderUpdateSchedulingDateRes updateSchedulingDate(ApsOrderUpdateSchedulingDateReq req) {
    return this.apsOrderService.updateSchedulingDate(req);
  }

  @Override
  public OrderCreateByMonthCountRes orderCreateByMonth(OrderCreateByMonthCountReq req) {
    return this.apsOrderService.orderCreateByMonth(req);
  }

  @Override
  public OrderStatusListRes orderStatusList(OrderStatusListReq req) {
    return new OrderStatusListRes().setDataList(Arrays.stream(ApsOrderStatusEnum.values())
        .map(t -> new OrderStatusListRes.Info().setCode(t.getCode()).setDesc(t.getDesc()))
        .toList());
  }

  @Override
  public StatusCountRes statusCount(StatusCountReq req) {
    return this.apsOrderService.statusCount(req);
  }

  @Override
  public FinishOrderTotalDayRes finishOrderTotalDay(FinishOrderTotalDayReq req) {
    return this.apsOrderService.finishOrderTotalDay(req);
  }

  @Override
  public OrderFieldListRes orderFieldList(OrderFieldListReq req) {
    return this.apsOrderService.orderFieldList(req);
  }
}
