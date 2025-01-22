package com.saludable.dieta.application.domain;

import com.saludable.dieta.application.exception.ErrorCodeConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record Diet(
    @NotNull(message = ErrorCodeConstants.DIET_MANDATORY_START_DATE) LocalDate start,
    LocalDate end,
    @Valid List<Meal> meals) {

  @AssertTrue(message = ErrorCodeConstants.DIET_END_DATE_BEFORE_START_DATE)
  public boolean isEndDateAfterStartDate() {
    if (Objects.nonNull(start) && Objects.nonNull(end)) {
      return end.isAfter(start);
    }
    return true;
  }
}
