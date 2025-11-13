package com.pluralsight.models;

public class Topping {
    private final ToppingType type;
    // only true for premium opts like meat & cheese
    private final boolean extra;

    public Topping(ToppingType type, boolean extra) {
        this.type = type;
        this.extra = extra;
    }

    public ToppingType getType() {
        return type;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPriceForSize(SandwichSize size){
        // if regular topping, no price
        if (!type.isPremium()){
            return 0.0;
        }
        double price = 0.0;
        switch (size) {
            case FOUR:
                price = type.getPrice4;
                if(extra) price =+ type.getExtra4;
                break;
            case EIGHT:
                price = type.getPrice8;
                if(extra) price =+ type.getExtra8;
                break;
            case TWELVE:
                price = type.getPrice12;
                if(extra) price =+ type.getExtra12;
                break;
        }
        return price;
    }
}


