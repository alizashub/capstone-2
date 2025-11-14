package com.pluralsight.models;

/**
 * Topping
 * shows 1 topping added to a sandwich
 * pricing rules :
 * regular topping = always free eg. sauces, sides, lettuce
 * premium toppings = additional price based on size, possibility for extra portion eg. for meat and cheese only
 */
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
    // calculates the price for the topping for a specific sandwich size

    public double getPriceForSize(SandwichSize size) {

        // if regular topping, no price
        if (type.isRegular()) {
            return 0.0;
        }
        // base price for meat or cheese , not regular topping
        double price = type.getBasePrice(size);
        // add extra portion cost if selected
        if (extra) {
            price = price + type.getExtraPrice(size);
        }
        return price;
    }
}


