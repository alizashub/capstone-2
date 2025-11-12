package com.pluralsight.models;

public enum DrinkSize {
    SMALL(2.00),
    MEDIUM(2.50),
    LARGE(3.00),
    ;

    private final double price;

    DrinkSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        // the name method gives you the exact constant name in all uppercase
        // the lowercase turns it all to lowercase
        String s = name().toLowerCase();
        //substring method allows to slice the string into 2 parts
        // turns the char at the 0 index to upper and keeps the rest starting from index 1 to lowercase
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
}
