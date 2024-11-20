package com.saludable.dieta.infra.rest.spring.creatediet.model;


import java.time.LocalDate;
import java.util.List;

public record DietRequest(LocalDate start, LocalDate end, List<MealRequest> meals) {}
