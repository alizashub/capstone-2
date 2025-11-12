package com.pluralsight.models;

public enum ChipType {
    LAYS,
    DORITOS,
    RUFFLES,
    TAKIS;

    @Override
    public String toString(){
        String s = name().toLowerCase();
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
}
