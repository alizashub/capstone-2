package com.pluralsight.models;
/**
 * Sizes for sandwiches. Each enum value stores :
 * inches(4,8,12) & base price for that size
 */
public enum SandwichSize {
    // each constant is separated with commas and the last constant ends with a terminator ;
    // adding field for inches so that the data can be used for cal, the enum name is for readability
    FOUR(4,5.50),
    EIGHT(8,7.00),
    TWELVE(12,8.50);

    // fields are declared after the constants in an enum

    private final int inches;
    private final double basePrice;

    // enum constructors are private by default thus no access modifier for enum
    SandwichSize(int inches, double basePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
    }

    public int getInches() {
        return inches;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString(){
        return inches + "\"";
    }
}
