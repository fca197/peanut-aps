package com.olivia.peanut.aps.api.entity.apsBomSupplier;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 供应商表(ApsBomSupplier)查询对象返回
 *
 * @author makejava
 * @since 2024-12-15 14:39:45
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsBomSupplierQueryListRes {

  /***
   * 返回对象列表
   */
  private List<ApsBomSupplierDto> dataList;


}

