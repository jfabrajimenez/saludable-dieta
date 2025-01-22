package com.saludable.dieta.infra.rest.spring.exception.handler;

import com.saludable.dieta.application.exception.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              Optional<ErrorCode> possibleErrorCode = ErrorCode.getByCode(error.getDefaultMessage());
              String fieldName = ((FieldError) error).getField();
              errors.put(
                  fieldName,
                  possibleErrorCode.map(ErrorCode::getMessage).orElseThrow(IllegalArgumentException::new));
            });

    return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);
  }
}
