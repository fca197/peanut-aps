package com.olivia.peanut.aps.service.impl;

import static com.olivia.peanut.util.SetNamePojoUtils.FACTORY;
import static com.olivia.peanut.util.SetNamePojoUtils.GOODS;
import static com.olivia.peanut.util.SetNamePojoUtils.OP_USER_NAME;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.aps.api.entity.apsGoodsBom.*;
import com.olivia.peanut.aps.mapper.ApsGoodsBomMapper;
import com.olivia.peanut.aps.model.ApsGoodsBom;
import com.olivia.peanut.aps.model.ApsProjectConfig;
import com.olivia.peanut.aps.service.ApsGoodsBomService;
import com.olivia.peanut.aps.service.ApsProjectConfigService;
import com.olivia.peanut.aps.service.ApsWorkshopStationService;
import com.olivia.peanut.aps.utils.bom.BomUtils;
import com.olivia.sdk.comment.ServiceComment;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.service.pojo.NameConfig;
import com.olivia.sdk.service.pojo.SetNamePojo;
import com.olivia.sdk.utils.*;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (ApsGoodsBom)表服务实现类
 *
 * @author peanut
 * @since 2024-04-03 22:28:56
 */
@Service("apsGoodsBomService")
@Transactional
public class ApsGoodsBomServiceImpl extends
    MPJBaseServiceImpl<ApsGoodsBomMapper, ApsGoodsBom> implements ApsGoodsBomService {


  @Resource
  SetNameService setNameService;
  @Resource
  ApsProjectConfigService apsProjectConfigService;

  public @Override ApsGoodsBomQueryListRes queryList(ApsGoodsBomQueryListReq req) {

    MPJLambdaWrapper<ApsGoodsBom> q = getWrapper(req.getData());
    List<ApsGoodsBom> list = this.list(q);

    List<ApsGoodsBomDto> dataList = list.stream().map(t -> $.copy(t, ApsGoodsBomDto.class))
        .collect(Collectors.toList());

    ((ApsGoodsBomServiceImpl) AopContext.currentProxy()).setName(dataList);

    //  this.setName(dataList);
    return new ApsGoodsBomQueryListRes().setDataList(dataList);
  }

  public @Override DynamicsPage<ApsGoodsBomExportQueryPageListInfoRes> queryPageList(
      ApsGoodsBomExportQueryPageListReq req) {

    DynamicsPage<ApsGoodsBom> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<ApsGoodsBom> q = getWrapper(req.getData());
    List<ApsGoodsBomExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<ApsGoodsBom> list = this.page(page, q);
      IPage<ApsGoodsBomExportQueryPageListInfoRes> dataList = list.convert(
          t -> $.copy(t, ApsGoodsBomExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = $.copyList(this.list(q), ApsGoodsBomExportQueryPageListInfoRes.class);
    }

    // 类型转换，  更换枚举 等操作

    List<ApsGoodsBomExportQueryPageListInfoRes> listInfoRes = $.copyList(records,
        ApsGoodsBomExportQueryPageListInfoRes.class);
    // this.setName(listInfoRes);
    ((ApsGoodsBomServiceImpl) AopContext.currentProxy()).setName(listInfoRes);
    return DynamicsPage.init(page, listInfoRes);
  }

  //  @SetUserName
  public @Override void setName(List<? extends ApsGoodsBomDto> apsGoodsBomDtoList) {

    setNameService.setName(apsGoodsBomDtoList, List.of(FACTORY, GOODS,//
        OP_USER_NAME, new SetNamePojo().setNameFieldName("stationName")
            .setServiceName(ApsWorkshopStationService.class).setNameConfigList(List.of(
                new NameConfig().setIdField("bomUseWorkStation")
                    .setNameFieldList(List.of("bomUseWorkStationName"))))));
  }

  @Override
  public CheckBomUseExpressionRes checkBomUseExpression(CheckBomUseExpressionReq req) {
    if (".".equals(req.getBomUseExpression().trim())) {
      return new CheckBomUseExpressionRes().setIsSuccess(Boolean.TRUE);
    }
    Set<String> proectConfigSet = apsProjectConfigService.list(
            new LambdaQueryWrapper<ApsProjectConfig>().select(ApsProjectConfig::getSaleCode)
                .eq(ApsProjectConfig::getIsValue, 1)).stream()
        .map(ApsProjectConfig::getSaleCode).collect(Collectors.toSet());
    boolean checkBomUseExpression = BomUtils.isMatch(
        BomUtils.bomExpression2List(req.getBomUseExpression()), "checkBomUseExpression",
        proectConfigSet);
    return new CheckBomUseExpressionRes().setIsSuccess(checkBomUseExpression);
  }

  // 以下为私有对象封装


  @SuppressWarnings(Str.UN_CHECKED)
  private MPJLambdaWrapper<ApsGoodsBom> getWrapper(ApsGoodsBomDto obj) {
    MPJLambdaWrapper<ApsGoodsBom> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, ApsGoodsBom.class, ApsGoodsBom::getGoodsId,
        ApsGoodsBom::getBomName,
        ApsGoodsBom::getGoodsId,
        ApsGoodsBom::getFactoryId, BaseEntity::getId, ApsGoodsBom::getBomUseWorkStation,
        ApsGoodsBom::getBomCode);

    q.orderByDesc(ApsGoodsBom::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<ApsGoodsBom> page) {

    ServiceComment.header(page, "ApsGoodsBomService#queryPageList");

  }


}

