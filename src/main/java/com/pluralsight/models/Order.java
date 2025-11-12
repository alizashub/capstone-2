package com.pluralsight.models;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private final ArrayList<Drink> drinks = new ArrayList<>();
    private final ArrayList<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip){
        chips.add(chip);
    }

    public  double getTotalOrderPrice(){
        double total = 0.0;
        for (Sandwich s : sandwiches)
            total = total + s.getPrice();
        for (Drink d : drinks)
            total = total + d.getPrice();
        for (Chips c : chips)
            total = total + c.getPrice();
        return total;
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
}
