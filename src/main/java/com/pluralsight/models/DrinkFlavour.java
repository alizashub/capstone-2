package com.pluralsight.models;

public enum DrinkFlavour {
    COLA("Coke"),
    FANTA("Fanta"),
    SPRITE("Sprite"),
    PEPSI("PEPSI");

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
