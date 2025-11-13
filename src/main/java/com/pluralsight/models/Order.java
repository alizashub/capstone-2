package com.pluralsight.models;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Sandwich> sandwiches;
    private final ArrayList<Drink> drinks;
    private final ArrayList<Chips> chips;
    private double totalPrice;

    public Order() {
        this.totalPrice = 0.0;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
        totalPrice = totalPrice + sandwich.getPrice();
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        totalPrice = totalPrice + drink.getPrice();
    }

    public void addChips(Chips chip){
        chips.add(chip);
        totalPrice = totalPrice+chip.getPrice();
    }

    public  double getTotalOrderPrice(){
        return totalPrice;
    }

    public boolean isEmpty(){
        return sandwiches.isEmpty()&& drinks.isEmpty()&&chips.isEmpty();
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    public String getSummary(){
        StringBuilder sb = new StringBuilder("Order Summary");

        if (sandwiches.isEmpty()&& drinks.isEmpty()&&chips.isEmpty()) {
            sb.append("No items are currently in your oder.");
        }
        for (Sandwich s : sandwiches) sb.append(s.getSummary()).append("\n");
        for (Drink d : drinks) sb.append(d.getSummary()).append("\n");
        for (Chips c : chips) sb.append(c.getSummary()).append("\n");

        sb.append("\n");
        sb.append(String.format("Total: $%.2f\n",getTotalOrderPrice()));

        return sb.toString();
    }
    public void clearorder(){
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        totalPrice = 0.0;
    }
}
