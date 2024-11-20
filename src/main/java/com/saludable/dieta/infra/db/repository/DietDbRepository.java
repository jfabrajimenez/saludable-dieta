package com.saludable.dieta.infra.db.repository;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.application.domain.Dish;
import com.saludable.dieta.application.domain.Meal;
import com.saludable.dieta.application.repository.DietRepository;
import com.saludable.dieta.infra.db.mapper.DietDbMapper;
import com.saludable.dieta.infra.db.mapper.DishDbMapper;
import com.saludable.dieta.infra.db.mapper.MealDbMapper;
import com.saludable.dieta.infra.db.springdata.entity.DietEntity;
import com.saludable.dieta.infra.db.springdata.entity.DishEntity;
import com.saludable.dieta.infra.db.springdata.entity.MealEntity;
import com.saludable.dieta.infra.db.springdata.repository.SpringDataDietRepository;
import com.saludable.dieta.infra.db.springdata.repository.SpringDataDishRepository;
import com.saludable.dieta.infra.db.springdata.repository.SpringDataMealRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class DietDbRepository implements DietRepository {
  private final SpringDataDietRepository dietRepository;
  private final SpringDataDishRepository dishRepository;
  private final SpringDataMealRepository mealRepository;
  private final DietDbMapper dietDbMapper;
  private final DishDbMapper dishDbMapper;
  private final MealDbMapper mealDbMapper;

  @Transactional
  @Override
  public void save(Diet diet) {
    DietEntity dietEntity = dietDbMapper.toEntity(diet);
    DietEntity savedDiet = dietRepository.save(dietEntity);

    diet.meals().forEach(meal -> saveMeal(meal, savedDiet));
  }

  private void saveMeal(Meal meal, DietEntity diet) {
    DishEntity savedDish = findOrSaveDish(meal.dish());

    MealEntity mealToSave = mealDbMapper.toSaveEntity(meal, diet, savedDish);
    mealRepository.save(mealToSave);
  }

  private DishEntity findOrSaveDish(Dish dish) {
    Optional<DishEntity> possibleDish = dishRepository.findByName(dish.name());
    return possibleDish.orElseGet(() -> saveDish(dish));
  }

  private DishEntity saveDish(Dish dish) {
    DishEntity dishToSave = dishDbMapper.toEntity(dish);
    return dishRepository.save(dishToSave);
  }
}
