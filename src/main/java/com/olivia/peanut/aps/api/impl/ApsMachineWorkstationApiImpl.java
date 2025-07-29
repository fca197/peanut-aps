package com.olivia.peanut.aps.api.impl;

import static com.olivia.peanut.aps.converter.ApsMachineWorkstationConverter.INSTANCE;

import cn.hutool.core.collection.CollUtil;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.ApsMachineWorkstationApi;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationDeleteByIdListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationDeleteByIdListRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationDto;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationExportQueryPageListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationImportReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationImportRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationInsertReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationInsertRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationQueryByIdListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationQueryByIdListRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationQueryListReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationQueryListRes;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationUpdateByIdReq;
import com.olivia.peanut.aps.api.entity.apsMachineWorkstation.ApsMachineWorkstationUpdateByIdRes;
import com.olivia.peanut.aps.api.impl.listener.ApsMachineWorkstationImportListener;
import com.olivia.peanut.aps.converter.ApsMachineWorkstationItemConverter;
import com.olivia.peanut.aps.model.ApsMachineWorkstation;
import com.olivia.peanut.aps.model.ApsMachineWorkstationItem;
import com.olivia.peanut.aps.service.ApsMachineWorkstationItemService;
import com.olivia.peanut.aps.service.ApsMachineWorkstationService;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * aps 生产机器 工作站(ApsMachineWorkstation)表服务实现类
 *
 * @author admin
 * @since 2025-07-23 13:20:05
 */
@RestController
public class ApsMachineWorkstationApiImpl implements ApsMachineWorkstationApi {

  private @Resource ApsMachineWorkstationService apsMachineWorkstationService;
  private @Resource ApsMachineWorkstationItemService apsMachineWorkstationItemService;


  /****
   * insert
   *
   */
  public @Override ApsMachineWorkstationInsertRes insert(ApsMachineWorkstationInsertReq req) {
    Long id = this.apsMachineWorkstationService.save(req);
    return new ApsMachineWorkstationInsertRes().setId(id).setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override ApsMachineWorkstationDeleteByIdListRes deleteByIdList(
      ApsMachineWorkstationDeleteByIdListReq req) {
    apsMachineWorkstationService.removeByIds(req.getIdList());
    return new ApsMachineWorkstationDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override ApsMachineWorkstationQueryListRes queryList(
      ApsMachineWorkstationQueryListReq req) {
    return apsMachineWorkstationService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override ApsMachineWorkstationUpdateByIdRes updateById(
      ApsMachineWorkstationUpdateByIdReq req) {
    apsMachineWorkstationService.updateById(req);
    return new ApsMachineWorkstationUpdateByIdRes();

  }

  public @Override DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> queryPageList(
      ApsMachineWorkstationExportQueryPageListReq req) {
    return apsMachineWorkstationService.queryPageList(req);
  }

  public @Override void queryPageListExport(ApsMachineWorkstationExportQueryPageListReq req) {
    DynamicsPage<ApsMachineWorkstationExportQueryPageListInfoRes> page = queryPageList(req);
    List<ApsMachineWorkstationExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(ApsMachineWorkstationExportQueryPageListInfoRes.class, list,
        "aps 生产机器 工作站");
  }

  public @Override ApsMachineWorkstationImportRes importData(
      @RequestParam("file") MultipartFile file) {
    List<ApsMachineWorkstationImportReq> reqList = PoiExcelUtil.readData(file,
        new ApsMachineWorkstationImportListener(), ApsMachineWorkstationImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<ApsMachineWorkstation> readList = INSTANCE.importReq(reqList);
    boolean bool = apsMachineWorkstationService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new ApsMachineWorkstationImportRes().setCount(c);
  }

  public @Override ApsMachineWorkstationQueryByIdListRes queryByIdListRes(
      ApsMachineWorkstationQueryByIdListReq req) {
    MPJLambdaWrapper<ApsMachineWorkstation> q = new MPJLambdaWrapper<ApsMachineWorkstation>(
        ApsMachineWorkstation.class)
        .selectAll(ApsMachineWorkstation.class).in(ApsMachineWorkstation::getId, req.getIdList());
    List<ApsMachineWorkstation> list = this.apsMachineWorkstationService.list(q);
    Map<Long, List<ApsMachineWorkstationItem>> apsMachineMap = this.apsMachineWorkstationItemService.lambdaQuery()
        .in(ApsMachineWorkstationItem::getMachineWorkstationId, req.getIdList())
        .list().stream()
        .collect(Collectors.groupingBy(ApsMachineWorkstationItem::getMachineWorkstationId));
    List<ApsMachineWorkstationDto> dataList = INSTANCE.queryListRes(list);
    if (CollUtil.isNotEmpty(dataList)) {
      dataList.forEach(item -> {
        List<ApsMachineWorkstationItem> workstationItemList = apsMachineMap.getOrDefault(
            item.getId(),
            List.of());

        item.setMachineWorkstationItemDtoList(
            ApsMachineWorkstationItemConverter.INSTANCE.queryListRes(workstationItemList));
      });
    }
    this.apsMachineWorkstationService.setName(dataList);
    return new ApsMachineWorkstationQueryByIdListRes().setDataList(dataList);
  }
}
