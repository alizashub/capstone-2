package com.pluralsight.models;
import java.util.ArrayList;

public class Sandwich extends MenuItem {
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;

    private final ArrayList<Topping> meats;
    private final ArrayList<Topping> cheeses;
    private final ArrayList<ToppingType> regularToppings;
    private final ArrayList<SauceType> sauces;

    public Sandwich(String name, BreadType bread,SandwichSize size,  boolean toasted){
        super(name, size.getBasePrice()); // base price comes from the size
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = toasted;
        this.size = size;
        this.bread = bread;
    }

    public void addMeat(ToppingType type) {
        if (type == null || !type.isMeat()) return;
    // check if this meat already exists - then increase qunaity
        for (Topping t : meats) {
            if (t.getType() == type) {
                t.increasingQuantityByOne(); // add extra portion
                return;
            }
        }
        meats.add(new Topping(type));
    }

    public void addCheese(ToppingType type) {
        if (type == null || !type.isCheese()) return;

        for (Topping t : cheeses) {
            if (t.getType() == type) {
                t.increasingQuantityByOne();
                return;
            }
        }
        cheeses.add(new Topping(type));
    }

    public void addRegularTopping(ToppingType type) {
        if (type == null || !type.isRegular()) return;
        if (!regularToppings.contains(type)) regularToppings.add(type);
    }

    public void addSauce(SauceType sauce) {
        if (sauce == null) return;
        if (!sauces.contains(sauce)) sauces.add(sauce);
    }

    public int getMeatCount(ToppingType type) {
        for (Topping t : meats) if (t.getType() == type) return t.getQuantity();
        return 0;
    }

    public void decreaseMeat(ToppingType type) {
        for (int i = 0; i < meats.size(); i++) {
            Topping t = meats.get(i);
            if (t.getType() == type) {
                t.decreasingQuantityByOne();
                if (t.getQuantity() <= 1 && t.getQuantity() == 0) {
                    meats.remove(i);
                }
                return;
            }
        }
    }

    public int getCheeseCount(ToppingType type) {
        for ( Topping t : cheeses) {
            if ( t.getType() == type) {
                return t.getQuantity();
            }
        }
        return 0;
    }

    @Override
    public double getPrice() {
        double total = size.getBasePrice();

        for (Topping t : meats) {
            int quantity = t.getQuantity();
            total = total + t.getType().getBasePrice(size);
            if (quantity > 1) total = total + (quantity - 1) * t.getType().getExtraPrice(size);
        }
        return Math.round(total * 100) / 100;
    }

    @Override
    public String getSummary() {
        return size + " " + bread.getDisplayName() + (toasted ? " (toasted)" : "");
    }
}
