package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItem{
    private BreadType bread;
    private SandwichSize size;
    private boolean toasted;

    private final ArrayList<Topping> toppings;
    private final ArrayList<SauceType> sauces;

    public Sandwich(String name, double basePrice, BreadType bread, SandwichSize size, boolean toasted) {
        super(name, basePrice);
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;

        this.toppings = new ArrayList<>();
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

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

   public ArrayList<Topping> getToppings(){
        return toppings;
   }

   public void addTopping(Topping topping){
        if(topping != null) {
            toppings.add(topping);
        }
   }

   public ArrayList<SauceType>getSauces(){
        return sauces;
   }

   public void addSauce(SauceType sauce) {
        if(sauce != null) {
            sauces.add(sauce);
        }
   }

    @Override
    public  double getPrice(){
        double total = getBasePrice();

        for (Topping t : toppings) {
            total = total + t.getPrice();
        }
        return total;
    }

    @Override
    public String getSummary() {
        return size.toString()+ " " + bread.toString() + (toasted ? "(toasted)" : " ");
    }

}
