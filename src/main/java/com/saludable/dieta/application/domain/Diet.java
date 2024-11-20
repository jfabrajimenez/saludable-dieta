package com.saludable.dieta.application.domain;

import java.time.LocalDate;
import java.util.List;

public record Diet(LocalDate start, LocalDate end, List<Meal> meals) {}
