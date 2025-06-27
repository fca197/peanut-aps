package com.olivia.peanut.aps.service.impl.kitting;

import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.ApsOrderGoodsBomKittingVersionInsertRes;
import com.olivia.peanut.aps.api.entity.apsOrderGoodsBomKittingVersion.CreateSchedulingKittingVersion;

public interface ApsOrderGoodsBomKittingVersionCreateService {


  ApsOrderGoodsBomKittingVersionInsertRes createSchedulingKittingVersion(
      CreateSchedulingKittingVersion req);
}
