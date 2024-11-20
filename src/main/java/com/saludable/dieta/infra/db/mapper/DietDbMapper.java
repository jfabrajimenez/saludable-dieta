package com.saludable.dieta.infra.db.mapper;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.infra.db.springdata.entity.DietEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DietDbMapper {
  DietEntity toEntity(Diet diet);
}
