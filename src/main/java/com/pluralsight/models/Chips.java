package com.pluralsight.models;

public class Chips extends MenuItem {
    private final ChipType type;
    private static final double CHIP_PRICE = 1.50;

    public Chips(String name, double basePrice, ChipType type) {
        super(name, basePrice);

        if (type == null) {
            throw new IllegalArgumentException("Chip type cannot be null.");
        }
        this.type = type;
    }

    public ChipType getType() {
        return type;
    }

    @Override
    public double getPrice(){
        return CHIP_PRICE;
    }

    @Override
    public String getSummary(){
        return type.toString() + " chips";
    }
}
