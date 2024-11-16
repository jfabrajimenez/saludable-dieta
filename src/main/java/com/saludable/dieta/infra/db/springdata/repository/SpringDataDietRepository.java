package com.saludable.dieta.infra.db.springdata.repository;

import com.saludable.dieta.infra.db.springdata.entity.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDietRepository extends JpaRepository<DietEntity, Long> {}
