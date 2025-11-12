package com.pluralsight.models;

public abstract class MenuItem {
    private final String name;
    private final double basePrice;

    public MenuItem(String name, double basePrice) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Menu Item name cannot be blank.");
        }
        if (basePrice < 0.0 ) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double getPrice();
    public abstract String getSummary();

    @Override
    public String toString(){
        return String.format("%s - $%.2f", getSummary(), getPrice());
    }
}
