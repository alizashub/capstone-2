package com.pluralsight.models;
/**
 * ChipType
 * shows all chip types available in the deli
 */
public enum ChipType {
    LAYS("Lays"),
    DORITOS("Doritos"),
    RUFFLES("Ruffles"),
    TAKIS("Takis");

    private final String displayName;

    ChipType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    // when printed shows the displayName rather than ALL CAPS
    @Override
    public String toString(){
        return displayName;
    }
}
