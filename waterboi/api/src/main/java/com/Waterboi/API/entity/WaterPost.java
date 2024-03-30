package com.Waterboi.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class WaterPost {

    @Id
    @GeneratedValue
    private Long id;
    private Long appuserID;
    private double quantity;
    private int unitOfMeasure;
    private LocalDateTime postTime;

}
