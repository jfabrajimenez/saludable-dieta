package com.saludable.dieta.infra.rest.spring.creatediet.model;

public record MealRequest(String name, String moment, Integer order, DishRequest dish) {}
