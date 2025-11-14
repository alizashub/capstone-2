package com.pluralsight.models;
/**
 * SauceType
 * shows different sauces a customer can add to a sandwich
 * sauces are free, a customer can add multiple sauces
 */
public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLAND("Thousand Island"),
    VINAIGRETTE("Vinaigrette");

    private final String displayName;

    SauceType(String displayName) {
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
