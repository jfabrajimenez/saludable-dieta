package com.saludable.dieta.application.domain;

import com.saludable.dieta.application.exception.ErrorCodeConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Meal(
    @NotBlank(message = ErrorCodeConstants.MEAL_MANDATORY_NAME) String name,
    @NotBlank(message = ErrorCodeConstants.MEAL_MANDATORY_MOMENT) String moment,
    Integer order,
    @NotNull(message = ErrorCodeConstants.MEAL_MANDATORY_DISH) @Valid Dish dish) {}
