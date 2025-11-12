package com.pluralsight.models;

public class Topping {
    private final ToppingType type;
    private final SandwichSize size;
    private final boolean isExtra;
    private final double price;

    public Topping(ToppingType type, SandwichSize size, boolean isExtra, double price) {
        this.type = type;
        this.size = size;
        this.isExtra = isExtra;
        this.price = price;
    }

    private double calculatePrice() {
        double basePrice = type.getBasePrice(size);

        if (isExtra) {
            if (type.getCategory().equals("MEAT")) {
                double extraCharge = 0.0;
                if (size == SandwichSize.FOUR) {
                    extraCharge = 0.50;
                } else if (size == SandwichSize.EIGHT) {
                    extraCharge = 1.00;
                } else if (size == SandwichSize.TWELVE) {
                    extraCharge = 1.50;
                }
                basePrice = basePrice + extraCharge;
            } else if (type.getCategory().equals("CHEESE")) {
                double extraCharge = 0.0;
                if (size == SandwichSize.FOUR) {
                    extraCharge = 0.30;
                } else if (size == SandwichSize.EIGHT) {
                    extraCharge = 0.60;
                } else if (size == SandwichSize.TWELVE) {
                    extraCharge = 0.90;
                }
                basePrice = basePrice + extraCharge;

            } else if (type.getCategory().equals("REGULAR")) {
                System.out.println(type.getDisplayName() + "is a regular topping, extra has no additional charge.");
            }
        }
        return basePrice;
    }

    public ToppingType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public String getSummary(){
        String isExtraTest = isExtra ? " (extra) " : "";
        // to make sure there is no zeros when adding regular topping
        String priceNonZeroTest = price > 0 ? String.format(" - $%.2f", price) : "";
        return type.getDisplayName() + isExtraTest + priceNonZeroTest;

    }
}
