package com.pluralsight.models;
import java.util.ArrayList;

/**
 * Order will hold a customer's full order eg. sandwiches, drinks and chip.
 */

public class Order {
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

    // calculating total cost of all items
    public double getTotal() {
        double total = 0.0;

        for (int i = 0; i < items.size(); i++) {
            total = total + items.get(i).calculatePrice();
        }
        return total;
    }

    public String generateReceiptText() {
        String text = "";
        System.out.println("Deli Receipt");

        for (int i = 0; i < items.size(); i++) {
            MenuItem m = items.get(i);

            text += (i + 1) + ") " + m.getName() + " -$" + m.calculatePrice() + "\n";

            // if item is a sandwhich, add detail breakdown
            if (m instanceof Sandwich) {
                Sandwich s = (Sandwich) m;
                text += s.getDetailedDescription();
            }
            text += "\n";
        }
        text += "Total:$ " + getTotal() + "\n";
        text += "--------------------\n";

        return text;
    }
}
