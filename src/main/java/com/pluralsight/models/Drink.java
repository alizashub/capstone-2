package com.pluralsight.models;

/**
 * Drink has 3 sizes eg. small, medium, large
 */
public class Drink extends MenuItem {
    private final DrinkSize size;
    private final DrinkFlavour flavor;

    public Drink(String name, DrinkSize size, DrinkFlavour flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice(){
        return size.getPrice();
    }

    @Override
    public String getName(){
        return size.getDisplayName() + "Drink (" + flavor.name()+ ")";
    }

}
