package com.pluralsight.models;

public class Drink extends MenuItem {
    private final DrinkSize size;
    private final String flavor;

    public Drink(String name, double basePrice, DrinkSize size, String flavor) {
        super(name, basePrice);

        this.size = size;
        this.flavor = flavor.trim();
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice(){
        return size.getPrice();
    }
    @Override
    public String getSummary() {
        return size.toString() + " " + flavor + " drink";
    }

}
