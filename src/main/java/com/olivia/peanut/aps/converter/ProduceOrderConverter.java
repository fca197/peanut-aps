package com.olivia.peanut.aps.converter;

import com.olivia.peanut.aps.utils.process.entity.ProduceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ProduceOrderConverter {

  public static final ProduceOrderConverter INSTANCE = Mappers.getMapper(ProduceOrderConverter.class);


}
