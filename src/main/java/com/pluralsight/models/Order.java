package com.pluralsight.models;
import java.util.ArrayList;

/**
 * Order will hold a customer's full order eg. sandwiches, drinks and chip, sides
 * It will calculate the total price
 * It will create a reciept text for savin and display
 */

public class Order {
    // this list will store sandwich,drink,chips,sides
    // all items are extended from menuitem so they sit into one arraylist
    // userinterface collects the userchoice and create the actual object
    private ArrayList<MenuItem> items;

    public Order() {
        this.items = new ArrayList<MenuItem>();
    }

    // add any menu item to the array
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    // calculating total cost of all items in the order
    public double getTotal() {
        double total = 0.0;

        // java automatically takes the calculatePrice method for all the items
        // eg. Sandwich.calculatePrice, Drink.calcualtePrice
        for (MenuItem m : items) {
            total = total + m.calculatePrice();
        }
        return total;

    }

    public String generateReceiptText() {
        StringBuilder text = new StringBuilder();

        // header
        text.append("========== Aliza's DELI RECEIPT ==========\n\n");

        // Loop through every item in the order
        for (int i = 0; i < items.size(); i++) {

            MenuItem m = items.get(i);
            double price = m.calculatePrice();

            // Item header line
            text.append((i + 1))
                    .append(") ")
                    .append(m.getName())
                    .append(" - $")
                    .append(price)
                    .append("\n");

            // If item is a sandwich, include itemized topping breakdown
            if (m instanceof Sandwich) {
                Sandwich s = (Sandwich) m;
                text.append(s.getDetailedDescription());
            }

            text.append("\n"); // spacing between items
        }

        // Final total
        text.append("Total: $").append(getTotal()).append("\n");
        text.append("----------------------------------\n");

        return text.toString();
    }
}
