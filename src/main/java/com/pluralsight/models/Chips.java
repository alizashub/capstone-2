package com.pluralsight.models;

public class Chips extends MenuItem {
    private final ChipType type;
    private static final double CHIP_PRICE = 1.50;

    public Chips(String name, ChipType type) {
        super("Chips");
        this.type = type;
    }
    @Override
    public double calculatePrice(){
        return CHIP_PRICE;
    }

    @Override
    public String getName(){
        return "Chips (" + type.getDisplayName()+ ")";
    }
}
