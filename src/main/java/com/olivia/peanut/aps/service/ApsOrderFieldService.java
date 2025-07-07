package com.olivia.peanut.aps.service;

import com.olivia.sdk.model.KVEntity;
import java.util.List;
import java.util.Map;

public interface ApsOrderFieldService {

  /****
   *  返回订单信息
   * @param orderIdList
   * @param orderUserFieldList
   * @param saleFieldList  返回字段为 sale_pid => id  sale_pid_name => 名称
   * @param orderExtMap
   * @return 订单信息
   */
  Map<Long, Map<String, Object>> orderFieldSetValue(List<Long> orderIdList,
      List<KVEntity> orderUserFieldList, List<KVEntity> saleFieldList,
      Map<Long, Map<String, Object>> orderExtMap);
}
