package com.saludable.dieta.application.domain;

import com.saludable.dieta.application.exception.ErrorCodeConstants;
import jakarta.validation.constraints.NotBlank;

public record Dish(@NotBlank(message = ErrorCodeConstants.DISH_MANDATORY_NAME) String name) {}
