package com.saludable.dieta.infra.db.springdata.repository;

import com.saludable.dieta.infra.db.springdata.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataDishRepository extends JpaRepository<DishEntity, Long> {
  Optional<DishEntity> findByName(String name);
}
