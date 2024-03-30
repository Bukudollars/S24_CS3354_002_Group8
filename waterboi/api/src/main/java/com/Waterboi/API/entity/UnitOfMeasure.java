package com.Waterboi.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double literMultiple;
}
