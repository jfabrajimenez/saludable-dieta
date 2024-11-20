package com.saludable.dieta.infra.rest.spring.creatediet.mapper;

import com.saludable.dieta.application.domain.Diet;
import com.saludable.dieta.infra.rest.spring.creatediet.model.DietRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateDietMapper {
  Diet toDomain(DietRequest dietRequest);
}
