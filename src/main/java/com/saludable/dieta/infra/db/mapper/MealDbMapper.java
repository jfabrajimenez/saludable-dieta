package com.saludable.dieta.infra.db.mapper;

import com.saludable.dieta.application.domain.Meal;
import com.saludable.dieta.infra.db.springdata.entity.DietEntity;
import com.saludable.dieta.infra.db.springdata.entity.DishEntity;
import com.saludable.dieta.infra.db.springdata.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MealDbMapper {
  @Mapping(target = "id", expression = "java(null)")
  @Mapping(target = "name", source = "meal.name")
  @Mapping(target = "diet", source = "diet")
  @Mapping(target = "dish", source = "dish")
  MealEntity toSaveEntity(Meal meal, DietEntity diet, DishEntity dish);
}
