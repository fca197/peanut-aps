package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathDto;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathExportQueryPageListInfoRes;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathImportReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathInsertReq;
import com.olivia.peanut.aps.api.entity.apsLogisticsPath.ApsLogisticsPathUpdateByIdReq;
import com.olivia.peanut.aps.model.ApsLogisticsPath;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApsLogisticsPathConverter {

  ApsLogisticsPathConverter INSTANCE = Mappers.getMapper(ApsLogisticsPathConverter.class);

  ApsLogisticsPath insertReq(ApsLogisticsPathInsertReq req);

  ApsLogisticsPath updateReq(ApsLogisticsPathUpdateByIdReq req);

  List<ApsLogisticsPathDto> queryListRes(List<ApsLogisticsPath> list);

  List<ApsLogisticsPathExportQueryPageListInfoRes> queryPageListRes(List<ApsLogisticsPath> list);

  List<ApsLogisticsPath> importReq(List<ApsLogisticsPathImportReq> reqList);
}

