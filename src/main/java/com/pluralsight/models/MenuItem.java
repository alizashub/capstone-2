package com.pluralsight.models;

/**
 * Abstract parent class that holds sub classes like chip,drink and sandwich will inherit from this class.
 * Allows us to store all items in one ArrayList<MenuItem> inside order
 */
public abstract class MenuItem {
    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }
    // each subclass implements its own princing rules
    public abstract double calculatePrice();
    // getter
    public String getName() {
        return name;
    }
}
