package com.pluralsight.models;
/**
 * DrinkFlavour
 * shows the flavours available for drinks
 */
public enum DrinkFlavour {
    COLA("Coke"),
    FANTA("Fanta"),
    SPRITE("Sprite"),
    PEPSI("PEPSI");

    // label for printing
    private final String displayName;

    DrinkFlavour(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
