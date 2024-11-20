package com.saludable.dieta.infra.config.spring;

import com.saludable.dieta.application.repository.DietRepository;
import com.saludable.dieta.application.usecase.CreateDietUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApplicationBeanConfig {

  @Bean
  public CreateDietUseCase createDietUseCase(DietRepository repository) {
    return new CreateDietUseCase(repository);
  }
}
