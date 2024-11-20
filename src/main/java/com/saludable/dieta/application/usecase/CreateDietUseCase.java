package com.saludable.dieta.application.usecase;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.application.repository.DietRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateDietUseCase {
  private final DietRepository dietRepository;

  public void save(Diet diet) {
    dietRepository.save(diet);
  }
}
