package com.saludable.dieta.application.exception;

import java.util.Optional;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {
  DIET_MANDATORY_START_DATE(
      ErrorCodeConstants.DIET_MANDATORY_START_DATE, "Start date is mandatory"),
  DIET_END_DATE_BEFORE_START_DATE(
      ErrorCodeConstants.DIET_END_DATE_BEFORE_START_DATE, "End date must be after start date"),
  MEAL_MANDATORY_NAME(ErrorCodeConstants.MEAL_MANDATORY_NAME, "Meal name is mandatory"),
  MEAL_MANDATORY_MOMENT(ErrorCodeConstants.MEAL_MANDATORY_MOMENT, "Meal moment is mandatory"),
  MEAL_MANDATORY_DISH(ErrorCodeConstants.MEAL_MANDATORY_DISH, "Mean dish is mandatory"),
  DISH_MANDATORY_NAME(ErrorCodeConstants.DISH_MANDATORY_NAME, "Dish name is mandatory"),
  VALIDATION_DIET_IN_PROGRESS("VD-1", "New diet into period another diet");

  private final String code;
  private final String message;

  public static Optional<ErrorCode> getByCode(String code) {
    return Stream.of(ErrorCode.values())
        .filter(errorCode -> errorCode.getCode().equals(code))
        .findAny();
  }
}
