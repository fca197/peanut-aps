package com.olivia.peanut.aps.service.impl;

import static java.lang.Boolean.TRUE;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsProcessPath.*;
import com.olivia.peanut.aps.api.entity.apsRoomConfig.ApsRoomConfigDto;
import com.olivia.peanut.aps.converter.*;
import com.olivia.peanut.aps.mapper.ApsProcessPathMapper;
import com.olivia.peanut.aps.model.*;
import com.olivia.peanut.aps.service.*;
import com.olivia.peanut.base.model.Factory;
import com.olivia.peanut.base.service.FactoryService;
import com.olivia.sdk.ann.SetUserName;
import com.olivia.sdk.comment.ServiceComment;
import com.olivia.sdk.utils.*;
import jakarta.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (ApsProcessPath)表服务实现类
 *
 * @author peanut
 * @since 2024-04-01 17:49:18
 */
@Service("apsProcessPathService")
@Transactional
public class ApsProcessPathServiceImpl extends MPJBaseServiceImpl<ApsProcessPathMapper, ApsProcessPath> implements ApsProcessPathService {


  @Resource
  ApsProcessPathRoomService apsProcessPathRoomService;
  @Resource
  FactoryService factoryService;
  @Resource
  ApsRoomConfigService apsRoomConfigService;
  @Resource
  ApsRoomService apsRoomService;

  public @Override ApsProcessPathQueryListRes queryList(ApsProcessPathQueryListReq req) {

    MPJLambdaWrapper<ApsProcessPath> q = getWrapper(req.getData());
    List<ApsProcessPath> list = this.list(q);

    List<ApsProcessPathDto> dataList = list.stream().map(t -> $.copy(t, ApsProcessPathDto.class)).collect(Collectors.toList());
//    setName(dataList);
    ((ApsProcessPathServiceImpl) AopContext.currentProxy()).setName(dataList);

    return new ApsProcessPathQueryListRes().setDataList(dataList);
  }

  public @Override DynamicsPage<ApsProcessPathExportQueryPageListInfoRes> queryPageList(ApsProcessPathExportQueryPageListReq req) {

    DynamicsPage<ApsProcessPath> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsProcessPath> q = getWrapper(req.getData());
    List<ApsProcessPathExportQueryPageListInfoRes> records;
    if (TRUE.equals(req.getQueryPage())) {
      IPage<ApsProcessPath> list = this.page(page, q);
      IPage<ApsProcessPathExportQueryPageListInfoRes> dataList = list.convert(t -> $.copy(t, ApsProcessPathExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = $.copyList(this.list(q), ApsProcessPathExportQueryPageListInfoRes.class);
    }

    // 类型转换，  更换枚举 等操作

    List<ApsProcessPathExportQueryPageListInfoRes> listInfoRes = $.copyList(records, ApsProcessPathExportQueryPageListInfoRes.class);
//    setName(listInfoRes);
    ((ApsProcessPathServiceImpl) AopContext.currentProxy()).setName(listInfoRes);

    return DynamicsPage.init(page, listInfoRes);
  }

  @Override
  @Transactional
  public ApsProcessPathInsertRes copyApsProcessPath(ApsProcessPathCopyReq req) {

    ApsProcessPath apsProcessPath = this.getOptById(req.getId()).orElseThrow(() -> new RuntimeException("工艺路径不存在，请刷新后重试"));
    List<ApsProcessPathRoom> apsProcessPathRoomList = this.apsProcessPathRoomService.list(
        new LambdaQueryWrapper<ApsProcessPathRoom>().eq(ApsProcessPathRoom::getProcessPathId, req.getId()));

    List<Long> roomIdList = apsProcessPathRoomList.stream().map(ApsProcessPathRoom::getRoomId).collect(Collectors.toList());
    Map<Long, ApsRoom> apsRoomMap = this.apsRoomService.list(new LambdaQueryWrapper<ApsRoom>().in(BaseEntity::getId, roomIdList)).stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));

    Map<Long, List<ApsRoomConfig>> roomConfigMap = this.apsRoomConfigService.list(new LambdaQueryWrapper<ApsRoomConfig>().in(ApsRoomConfig::getRoomId, roomIdList))
        .stream().collect(Collectors.groupingBy(ApsRoomConfig::getRoomId));
    ApsProcessPath apsProcessPathTmp = $.copy(apsProcessPath, ApsProcessPath.class).setProcessPathName(apsProcessPath.getProcessPathName() + "_新");
    BaseEntityUtils.clearAllInfo(apsProcessPathTmp);
    apsProcessPathTmp.setIsDefault(false).setId(IdWorker.getId());
    List<ApsProcessPathRoom> apsProcessPathRoomInsertList = new ArrayList<>(apsProcessPathRoomList.size());
    List<ApsRoom> apsRoomInsertList = new ArrayList<>();
    List<ApsRoomConfig> apsRoomConfigInsertList = new ArrayList<>();
    apsProcessPathRoomList.forEach(apsProcessPathRoom -> {
      Long oldRoomId = apsProcessPathRoom.getRoomId();
      long newRoomId = IdWorker.getId();
      apsProcessPathRoom.setRoomId(newRoomId);
      apsProcessPathRoomInsertList.add(new ApsProcessPathRoom().setRoomId(newRoomId).setProcessPathId(apsProcessPathTmp.getId()));
      ApsRoom apsRoom = apsRoomMap.get(oldRoomId);
      ApsRoom copyApsRoom = ApsRoomConverter.INSTANCE.copyApsRoom(apsRoom).setRoomName(apsRoom.getRoomName() + "_新");
      copyApsRoom.setId(newRoomId);
      BaseEntityUtils.clearAllInfo(copyApsRoom);
      apsRoomInsertList.add(copyApsRoom);
      List<ApsRoomConfig> apsRoomConfigList = roomConfigMap.get(oldRoomId);
      for (ApsRoomConfig apsRoomConfig : apsRoomConfigList) {
        ApsRoomConfig newApsRoomConfig = ApsRoomConfigConverter.INSTANCE.copyApsRoomConfig(apsRoomConfig);
        newApsRoomConfig.setRoomId(newRoomId).setId(IdWorker.getId());
        BaseEntityUtils.clearAllInfo(newApsRoomConfig);
        apsRoomConfigInsertList.add(newApsRoomConfig);
      }

    });
    this.save(apsProcessPathTmp);
    this.apsProcessPathRoomService.saveBatch(apsProcessPathRoomInsertList);
    this.apsRoomService.saveBatch(apsRoomInsertList);
    this.apsRoomConfigService.saveBatch(apsRoomConfigInsertList);

    return null;
  }

  @SetUserName
  public @Override void setName(List<? extends ApsProcessPathDto> apsProcessPathDtoList) {
    if (CollUtil.isEmpty(apsProcessPathDtoList)) {
      return;
    }
    Map<Long, String> factoryMap = factoryService.listByIds(apsProcessPathDtoList.stream().map(ApsProcessPathDto::getFactoryId).collect(Collectors.toList())).stream()
        .collect(Collectors.toMap(Factory::getId, Factory::getFactoryName));

    List<Runnable> runnableList = new ArrayList<>();
    List<Runnable> runnableSubList = new ArrayList<>();

    apsProcessPathDtoList.forEach(t -> {
      runnableList.add(() -> {
        List<ApsProcessPathRoom> pathRoomList = this.apsProcessPathRoomService.list(
            new LambdaQueryWrapper<ApsProcessPathRoom>().eq(ApsProcessPathRoom::getProcessPathId, t.getId()));
        t.setPathRoomList(ApsProcessPathRoomConverter.INSTANCE.queryListRes(pathRoomList));
        t.setFactoryName(factoryMap.get(t.getFactoryId()));
        t.getPathRoomList().forEach(tr -> {
          runnableSubList.add(() -> {
            List<ApsRoomConfig> roomConfigList = apsRoomConfigService.list(new LambdaQueryWrapper<ApsRoomConfig>().eq(ApsRoomConfig::getRoomId, tr.getRoomId()));
            if (CollUtil.isNotEmpty(roomConfigList)) {
              Map<Long, String> idNameMap = this.apsRoomService.listByIds(roomConfigList.stream().map(ApsRoomConfig::getRoomId).toList()).stream()
                  .collect(Collectors.toMap(BaseEntity::getId, ApsRoom::getRoomName));
              List<ApsRoomConfigDto> apsRoomConfigList = ApsRoomConfigConverter.INSTANCE.queryListRes(roomConfigList);
              apsRoomConfigList.forEach(ar -> ar.setRoomName(idNameMap.get(ar.getRoomId())));
              tr.setApsRoomConfigList(apsRoomConfigList);
            } else {
              tr.setApsRoomConfigList(List.of());
            }
          });
        });
      });
    });
    RunUtils.run("apsProcessPathService ", runnableList);
    RunUtils.run("apsProcessPathService SUB", runnableSubList);
  }

  @Override
  @Transactional
  public ApsProcessPathInsertRes save(ApsProcessPathInsertReq req) {
    if (TRUE.equals(req.getIsDefault())) {
      List<ApsProcessPath> pathList = this.list(
          new LambdaQueryWrapper<ApsProcessPath>().eq(ApsProcessPath::getFactoryId, req.getFactoryId()).eq(ApsProcessPath::getIsDefault, TRUE));
      $.assertTrueCanIgnoreException(CollUtil.isEmpty(pathList), "该工厂已存在默认工艺路径");
    }
    ApsProcessPath path = ApsProcessPathConverter.INSTANCE.insertReq(req);
    path.setId(IdWorker.getId());
    this.save(path);
    List<ApsProcessPathRoom> roomList = ApsProcessPathRoomConverter.INSTANCE.dto2entity(req.getPathRoomList());
    roomList.forEach(t -> t.setProcessPathId(path.getId()));
    this.apsProcessPathRoomService.saveBatch(roomList);
    return new ApsProcessPathInsertRes().setCount(1).setId(path.getId());
  }

  @Override
  @Transactional
  public void updateById(ApsProcessPathUpdateByIdReq req) {
    ApsProcessPath processPath = ApsProcessPathConverter.INSTANCE.updateReq(req);
    this.updateById(processPath);
    this.apsProcessPathRoomService.remove(new LambdaQueryWrapper<ApsProcessPathRoom>().eq(ApsProcessPathRoom::getProcessPathId, req.getId()));
    List<ApsProcessPathRoom> roomList = $.copyList(req.getPathRoomList(), ApsProcessPathRoom.class);
    roomList.forEach(t -> t.setProcessPathId(req.getId()).setId(IdWorker.getId()));
    this.apsProcessPathRoomService.saveBatch(roomList);

  }

  @Override
  @Transactional
  public boolean removeByIds(Collection<?> list) {
    super.removeByIds(list);
    this.apsProcessPathRoomService.remove(new LambdaQueryWrapper<ApsProcessPathRoom>().in(ApsProcessPathRoom::getProcessPathId, list));
    return true;
  }

  // 以下为私有对象封装


  private MPJLambdaWrapper<ApsProcessPath> getWrapper(ApsProcessPathDto obj) {
    MPJLambdaWrapper<ApsProcessPath> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsProcessPath.class, ApsProcessPath::getId, ApsProcessPath::getProcessPathCode, ApsProcessPath::getProcessPathName,
        ApsProcessPath::getProcessPathRemark, ApsProcessPath::getIsDefault, ApsProcessPath::getFactoryId);

    q.orderByDesc(ApsProcessPath::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsProcessPath> page) {

    ServiceComment.header(page, "ApsProcessPathService#queryPageList");

  }

}

