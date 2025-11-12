package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItem{
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;
    private final ArrayList<MeatType> meats;
    private final ArrayList<CheeseType> cheeses;
    private final ArrayList<RegularTopping> regularToppings;
    private final ArrayList<SauceType> sauces;

    public Sandwich(String name, double basePrice, BreadType bread, SandwichSize size, boolean toasted) {
        super(name, basePrice);
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    public BreadType getBread() {
        return bread;
    }

    public SandwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void addSauces( SauceType sauce) {
        sauces.add(sauce);
    }

    @Override
    public  double getPrice(){
        return getBasePrice();
    }

    @Override
    public String getSummary() {
        return size.toString()+ " " + bread.toString() + (toasted ? "(toasted)" : " ");
    }

}
