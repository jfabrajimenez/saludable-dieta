package com.saludable.dieta.application.exception;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorCodeConstants {
  public static final String DIET_MANDATORY_START_DATE = "VD-001";
  public static final String DIET_END_DATE_BEFORE_START_DATE = "VD-002";

  public static final String MEAL_MANDATORY_NAME = "VM-001";
  public static final String MEAL_MANDATORY_MOMENT = "VM-002";
  public static final String MEAL_MANDATORY_DISH = "VM-003";

  public static final String DISH_MANDATORY_NAME = "VDI-001";
}
