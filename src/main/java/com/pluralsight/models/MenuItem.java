package com.pluralsight.models;

/**
 * Abstract parent class that holds sub classes like chip,drink and sandwich.
 */
public abstract class MenuItem {
    private final String name;
    private final double basePrice; // base price before extra costs like premium toppings


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

    // getters

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
    // methods the subclass will implement
    public abstract double getPrice();
    public abstract String getSummary();

    @Override
    public String toString(){
        // eg. 8" Wheat Sandwich ( Toasted) - $9.25
        return String.format("%s - $%.2f", getSummary(), getPrice());
    }
}
