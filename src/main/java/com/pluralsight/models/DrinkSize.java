package com.pluralsight.models;

public enum DrinkSize {
    SMALL(2.00,"Small"),
    MEDIUM(2.50,"Medium"),
    LARGE(3.00,"Large");

    private final double price;
    private final String displayName;

    DrinkSize(double price, String displayName) {
        this.price = price;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return displayName;
    }
}
