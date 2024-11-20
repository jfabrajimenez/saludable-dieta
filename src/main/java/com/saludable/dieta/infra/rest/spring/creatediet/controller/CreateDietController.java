package com.saludable.dieta.infra.rest.spring.creatediet.controller;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.application.usecase.CreateDietUseCase;
import com.saludable.dieta.infra.rest.spring.creatediet.mapper.CreateDietMapper;
import com.saludable.dieta.infra.rest.spring.creatediet.model.DietRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/diet")
public class CreateDietController {
  private final CreateDietUseCase createDietUseCase;
  private final CreateDietMapper createDietMapper;

  @PostMapping("/save")
  public void save(@RequestBody DietRequest dietRequest) {
    Diet diet = createDietMapper.toDomain(dietRequest);
    createDietUseCase.save(diet);
  }
}
