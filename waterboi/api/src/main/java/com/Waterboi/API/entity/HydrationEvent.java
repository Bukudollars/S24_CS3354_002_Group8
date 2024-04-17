package com.Waterboi.API.entity;


public class HydrationEvent {
    private String drinkType;
    private int amount;

    //Constructor
    public HydrationEvent(String drinkType, int amount) {
        this.drinkType = drinkType;
        this.amount = amount;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
