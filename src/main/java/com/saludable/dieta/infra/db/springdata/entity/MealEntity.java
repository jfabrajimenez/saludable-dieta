package com.saludable.dieta.infra.db.springdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "meal")
public class MealEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String moment;

  @Column(name = "meal_order")
  private Integer order;

  @ManyToOne
  @JoinColumn(name = "id_diet", nullable = false)
  private DietEntity diet;

  @ManyToOne
  @JoinColumn(name = "id_dish", nullable = false)
  private DishEntity dish;
}
