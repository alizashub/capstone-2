package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItem {
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;
    // one list to sort all toppings
    private final ArrayList<Topping> toppings;


    public Sandwich(String name, BreadType bread, SandwichSize size, boolean toasted) {
        super("Custom Sandwich"); // base price comes from the size
        this.toasted = toasted;
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<Topping>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
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

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double calculatePrice() {
        double total = 0.0;

        // add base price based on the size of the sandwhich
        total += size.getBasePrice();
        for (int i = 0; i < toppings.size(); i++) {
            Topping t = toppings.get(i);
            total += t.getPriceForSize(size);
        }
        return total;
    }

    public String getDetailedDescription() {
        String text = "";
        text += " Size: " + size.getInches() + "\n";
        text += " Bread: " + bread.name() + "\n";
        text += " Toasted: " + (toasted ? "Yes" : "No") + "\n";

        if (toppings.size() == 0) {
            text += "Toppings: None\n";
        } else {
            text += " Toppings:\n";
            for (int i = 0; i < toppings.size(); i++) {
                Topping t = toppings.get(i);
                text += "     -" + t.getType().name();
                if (t.isExtra()) {
                    text += "(extra)";
                }
                double cost = t.getPriceForSize(size);
                if (cost > 0.0) {
                    text += " : $ " + cost;
                }
                text += "\n";
            }
        }
        text += " Subtotal: $" + calculatePrice() + "\n";
        return text;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    @Override
    public String getName(){
        return size.getInches() + "Sandwich (" + bread.name() + ")";
    }
}
