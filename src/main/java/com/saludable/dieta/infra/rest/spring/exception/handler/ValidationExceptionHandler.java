package com.saludable.dieta.infra.rest.spring.exception.handler;

import com.saludable.dieta.application.exception.ErrorCode;
import com.saludable.dieta.application.exception.ValidationException;
import com.saludable.dieta.infra.rest.spring.creatediet.controller.CreateDietController;
import com.saludable.dieta.infra.rest.spring.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {CreateDietController.class})
public class ValidationExceptionHandler {
  @ExceptionHandler({ValidationException.class})
  public ResponseEntity<ErrorMessage> validationError(ValidationException ex) {
    ErrorCode errorCode = ex.getErrorCode();
    return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
        .body(new ErrorMessage(errorCode.getCode(), errorCode.getMessage()));
  }
}
