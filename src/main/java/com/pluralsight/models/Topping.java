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

    public double getPriceForSize(SandwichSize size) {
        // if regular topping, no price
        if (!type.isRegular()) {
            return 0.0;
        }
        double price = type.getExtraPrice(size);
        if (extra) {
            price = price + type.getExtraPrice(size);
        }
        return price;
    }

}


