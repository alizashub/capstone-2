package com.pluralsight.models;
/**
 * BreadType
 * Possible bread types for a sandwich.
 * Using an enum to prevent possible typos.
 */
public enum BreadType {
    // the constant with display labels eg. BreadType.WHITE
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");
    // you can not instantiate enums manually java create them automatically eg. BreadType bread = BreadType.WHITE
    // display name shown to users
    private final String displayName;

    BreadType(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
}
