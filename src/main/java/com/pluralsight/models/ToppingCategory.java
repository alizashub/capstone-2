package com.pluralsight.models;

/**
 * Topping Category
 * Represents the group of a topping
 * Each ToppingType is assigned one ToppingCategory
 * Topping.java uses ToppingCategory through the ToppingType to correctly calculate the price
 */
public enum ToppingCategory {
    MEAT,
    CHEESE,
    REGULAR;
}
