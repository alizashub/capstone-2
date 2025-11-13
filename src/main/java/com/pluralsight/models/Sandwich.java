package com.pluralsight.models;

import java.util.ArrayList;
import java.util.HashMap;

    public class Sandwich extends MenuItem {
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;

    // free toppings
    private final ArrayList<ToppingType> regularToppings = new ArrayList<>();
    private final ArrayList<SauceType> sauces = new ArrayList<>();

    // premium options count
    private final HashMap<ToppingType, Integer> meats = new HashMap<>();
    private final HashMap<ToppingType, Integer> cheese = new HashMap<>();


}
