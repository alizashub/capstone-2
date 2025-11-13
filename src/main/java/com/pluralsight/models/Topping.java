package com.pluralsight.models;

public class Topping {
    private final ToppingType type;
    private int quantity;

    public Topping(ToppingType type) {
        if ( type == null) throw new IllegalArgumentException("ToppingType cannot be null.");
        this.type = type;
        this.quantity = 1;
    }

    public ToppingType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increasingQuantityByOne(){
        //add a portion
        quantity++;
    }

    public void decreasingQuantityByOne(){
        // remove portion but not below 1
        if (quantity > 1 ) quantity--;
    }

    @Override
    public String toString(){
        return type.getDisplayName() + "x" + quantity;
    }
}
