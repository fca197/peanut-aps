package com.olivia.peanut.aps.api.entity.apsOrder;

import com.olivia.sdk.model.KVEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class OrderFieldListRes {

  private List<KVEntity> dataList;
}
