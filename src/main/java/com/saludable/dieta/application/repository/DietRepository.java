package com.saludable.dieta.application.repository;

import com.saludable.dieta.application.domain.Diet;

public interface DietRepository {
  void save(Diet diet);
}
