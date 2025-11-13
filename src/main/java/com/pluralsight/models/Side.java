package com.pluralsight.models;

public class Side extends MenuItem{

    private final SideType type;

    private static final double PRICE = 0.0;

    public Side(SideType type) {
        super("Side");
        this.type = type;
    }

    @Override
    public double calculatePrice(){
        return PRICE;
    }

    @Override
    public String getName(){
        return "Side (" + type.getDisplayName() + ")";
    }
}
