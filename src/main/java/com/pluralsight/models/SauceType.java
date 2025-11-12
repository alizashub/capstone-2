package com.pluralsight.models;

public enum SauceType {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLAND,
    VINAIGRETTE;

    @Override
    public String toString(){
        String s = name().toLowerCase().replace("_"," ");
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
}
