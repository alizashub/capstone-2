package com.pluralsight.models;

public class Drink extends MenuItem {
    private final DrinkSize size;
    private final DrinkFlavour flavor;

    public Drink(String name, double basePrice, DrinkSize size, DrinkFlavour flavor) {
        super(name, basePrice);

        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkFlavour getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice(){
        return size.getPrice();
    }
    @Override
    public String getSummary() {
        return size + " " + flavor + " drink($" + getPrice() + ")";
    }

}
