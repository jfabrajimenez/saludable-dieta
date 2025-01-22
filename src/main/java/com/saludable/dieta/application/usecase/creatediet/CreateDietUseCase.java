package com.saludable.dieta.application.usecase.creatediet;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.application.repository.DietRepository;
import com.saludable.dieta.application.usecase.creatediet.exception.BadStartDateException;
import jakarta.validation.Valid;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateDietUseCase {
  private final DietRepository dietRepository;

  public void save(Diet diet) {
    validate(diet);
    dietRepository.save(diet);
  }

  private void validate(Diet diet){
    validateDatesInterval(diet);
  }

  private void validateDatesInterval(@Valid Diet diet){
    Optional<Diet>possibleMoreActualDiet=dietRepository.findMoreActualDiet();

    if(possibleMoreActualDiet.isPresent()){
      Diet moreActualDiet=possibleMoreActualDiet.get();

      if(Objects.nonNull(moreActualDiet.end()) && moreActualDiet.end().isAfter(diet.start())){
        throw new BadStartDateException();
      }

      if(moreActualDiet.start().isAfter(diet.start())){
        throw new BadStartDateException();
      }
    }
  }
}
