package com.saludable.dieta.infra.db.mapper;

import com.saludable.dieta.application.domain.Dish;
import com.saludable.dieta.infra.db.springdata.entity.DishEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishDbMapper {
    DishEntity toEntity(Dish dish);
}
