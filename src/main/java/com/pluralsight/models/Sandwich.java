package com.pluralsight.models;
/**
 * Sandwich
 * represents a fully custom sandwich build by user
 *
 */

import java.util.ArrayList;

public class Sandwich extends MenuItem {
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;
    // one list to sort all toppings
    private final ArrayList<Topping> toppings;
    private final ArrayList<SauceType> sauces;


    public Sandwich(String name, BreadType bread, SandwichSize size, boolean toasted) {
        super("Custom Sandwich"); // base price comes from the size
        this.toasted = toasted;
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<Topping>();
        this.sauces = new ArrayList<SauceType>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSauce(SauceType sauce) {
        sauces.add(sauce);
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

    public ArrayList<SauceType> getSauces() {
        return sauces;
    }

    @Override
    public double calculatePrice() {
        double total = 0.0;

        // add base price based on the size of the sandwhich
        total = total + size.getBasePrice();

        // adding topping prices
        for (int i = 0; i < toppings.size(); i++) {
            Topping t = toppings.get(i);
            total = total + t.getPriceForSize(size);
        }
        return total;
    }

    public String getDetailedDescription() {
        StringBuilder text = new StringBuilder();

        // adds sandwich size by adding the number, adding quotation marks and then going to next line
        text.append("   Size: ").append(size.getInches()).append("\"").append("\n");
        text.append(" Sandwich Base Price: ").append(String.format("%.2f",size.getBasePrice())).append("\n");
        // adds bread name using the displayName label and then going to nextline
        text.append("   Bread: ").append(bread.getDisplayName()).append("\n");
        //add the toasted status and then adds two new lines
        text.append("   Toasted: ").append(toasted ? "Yes" : "No").append("\n\n");

        text.append("   Toppings:\n");

        if (toppings.isEmpty()) {
            text.append("      None\n\n");
        } else {

            // PASS 1 — Print REGULAR toppings FIRST
            for (Topping t : toppings) {
                ToppingType type = t.getType();
                if (type.getCategory() == ToppingCategory.REGULAR) {
                    text.append("      - (Veg) ").append(type.getDisplayName()).append(" -------------- $0.00\n");
                }
            }

            // PASS 2 — Print MEAT + CHEESE second
            for (Topping t : toppings) {
                ToppingType type = t.getType();

                if (type.getCategory() == ToppingCategory.MEAT || type.getCategory() == ToppingCategory.CHEESE) {

                    if (type.getCategory() == ToppingCategory.MEAT) {
                        text.append("      - (Meat) ");
                    } else {
                        text.append("      - (Cheese) ");
                    }

                    text.append(type.getDisplayName());

                    if (t.isExtra()) {
                        text.append(" (extra)");
                    }

                    double cost = t.getPriceForSize(size);
                    if (cost > 0) {
                        text.append(" -------------- $").append(cost);
                    }

                    text.append("\n");
                }
            }

            text.append("\n");
        }

        if (sauces.isEmpty()) {
            text.append("   Sauces: None\n\n");
        } else {
            text.append("   Sauces:\n");
            for (SauceType s : sauces) {
                text.append("      - ").append(s.getDisplayName()).append("\n");
            }
            text.append("\n");
        }

        // Subtotal
        text.append("   Subtotal: $").append(calculatePrice()).append("\n");

        return text.toString();
    }


    @Override
    public String getName() {
        return size.getInches() + "\" Sandwich (" + bread.getDisplayName() + ")";
    }
}
