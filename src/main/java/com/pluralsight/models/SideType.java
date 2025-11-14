package com.pluralsight.models;

/**
 * SideType
 * shows available side options that the deli has with their foods
 */
public enum SideType {
    AU_JUS("Au Jus"),
    SAUCE("Sauce");

    private final String displayName;

    SideType(String displayName) {
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
