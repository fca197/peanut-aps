package com.olivia.peanut.aps.api.entity.apsSchedulingVersionItemPre;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 排产下发订单预览(ApsSchedulingVersionItemPre)保存返回
 *
 * @author makejava
 * @since 2025-04-06 14:16:40
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class ApsSchedulingVersionItemPreImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

