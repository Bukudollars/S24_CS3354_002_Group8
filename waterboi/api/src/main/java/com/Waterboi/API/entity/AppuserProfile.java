package com.Waterboi.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AppuserProfile {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false, updatable = false)
    private Long appuserId;
    private double dailyGoal;

    public AppuserProfile() {};
    public AppuserProfile(Long appuserId) {
        this.appuserId = appuserId;
        dailyGoal = 3;
    }
    public long getId() {
        return id;
    }
    public long appuserId() {
        return appuserId;
    }
    public double getDailyGoal() {
        return dailyGoal;
    }
    public void setDailyGoal(double dailyGoal) {
        this.dailyGoal = dailyGoal;
    }
}
