package com.saludable.dieta.application.repository;

import com.saludable.dieta.application.domain.Diet;
import java.util.Optional;

public interface DietRepository {
  void save(Diet diet);

  Optional<Diet> findMoreActualDiet();
}
