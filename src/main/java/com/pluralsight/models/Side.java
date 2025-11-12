package com.pluralsight.models;

public enum Side {
    AU_JUS("Au Jus"),
    Sauce("Sauce");

    private final String displayName;

    Side(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString(){
        return displayName;
    }
}

