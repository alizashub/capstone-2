package com.pluralsight.models;

/**
 * MenuItem ( Abstract parent class )
 * This is the "Parent Class" for all the food items in the deli system
 * - Sandwich
 * - Drinks
 * - Chips
 * - Sides
 * Allows us to store all items in one ArrayList<MenuItem> inside order.
 */
public abstract class MenuItem {
    // item name used for printing in the receipt
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
