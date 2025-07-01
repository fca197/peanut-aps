package com.olivia.peanut.aps.service;

import com.olivia.sdk.model.KVEntity;
import java.util.List;
import java.util.Map;

public interface OrderFieldService {

  Map<Long, Map<String, Object>> orderField(List<Long> orderIdList, List<KVEntity> orderFieldList,
      List<KVEntity> orderUserFieldList, List<KVEntity> saleFieldList, Map<Long,Map<String,Object>> orderExtMap);
}
