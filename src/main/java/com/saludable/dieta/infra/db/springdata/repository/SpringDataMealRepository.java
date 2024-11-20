package com.saludable.dieta.infra.db.springdata.repository;

import com.saludable.dieta.infra.db.springdata.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMealRepository extends JpaRepository<MealEntity, Long> {}
