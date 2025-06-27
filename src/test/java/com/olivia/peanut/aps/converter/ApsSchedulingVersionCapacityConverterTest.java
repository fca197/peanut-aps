package com.olivia.peanut.aps.converter;


import com.olivia.peanut.aps.model.ApsSchedulingVersionCapacity;
import com.olivia.sdk.utils.JSON;
import java.time.LocalDate;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ApsSchedulingVersionCapacityConverterTest {

  @Test
  public void convert() {
    ApsSchedulingVersionCapacity capacity = new ApsSchedulingVersionCapacity();
    capacity.setSchedulingVersionId(-1L);
    capacity.setCurrentDay(LocalDate.MIN);
    capacity.setFactoryId(-2L);
    capacity.setGoodsId(-3L);
    capacity.setOrderNo("orderNo");
    Map<String, Object> stringObjectMap = ApsSchedulingVersionCapacityConverter.INSTANCE.entity2Map(
        capacity);
    log.debug("map: {}", JSON.toJSONString(stringObjectMap));
  }
}