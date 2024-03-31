package com.Waterboi.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class WaterPost {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long appuserId;
    @Column(nullable = false)
    private double quantity;
    @Column(nullable = false)
    private Long unitOfMeasureId;
    @Column(nullable = false)
    private LocalDateTime postTime;

    private WaterPost() {}
    public WaterPost(Long appuserID, double quantity, Long unitOfMeasureId, LocalDateTime postTime) {
        this.appuserId = appuserID;
        this.quantity = quantity;
        this.unitOfMeasureId = unitOfMeasureId;
        this.postTime = postTime;
    }

    public Long getId() {
        return id;
    }

    public Long getAppuserId() {
        return appuserId;
    }

    public double getQuantity() {
        return quantity;
    }

    public Long getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }
}
