package com.saludable.dieta.application.usecase.creatediet.exception;

import com.saludable.dieta.application.exception.ErrorCode;
import com.saludable.dieta.application.exception.ValidationException;

public class BadStartDateException extends ValidationException {
  public BadStartDateException() {
    super(ErrorCode.VALIDATION_DIET_IN_PROGRESS);
  }
}
