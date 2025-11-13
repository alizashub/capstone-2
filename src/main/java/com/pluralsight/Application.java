package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;

public class Application {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        System.out.println("Welcome to the Deli");

        while (true) {
            int homeChoice = ui.showHomeScreen();

            if (homeChoice == 0) {
                System.out.println("Goobye");
                break;
            }

            Order order = new Order();
            boolean ordering = true;
            while (ordering) {
                int choice = ui.showOrderMenu();
                switch (choice) {
                    case 1 -> {
                        Sandwich sandwich = buildSandwich(ui);
                        order.addSandwich(sandwich);
                        System.out.println("Sandwich Added");
                    }

                    case 2 -> {
                        Drink drink = buildDrink(ui);
                        order.addDrink(drink);
                        System.out.println("Drink added");
                    }

                    case 3 -> {
                        Chips chips = buildChips(ui);
                        order.addChips(chips);
                        System.out.println("Chips Added");
                    }

                    case 4 -> {
                        if (order.isEmpty()) {
                            System.out.println("Your Order is empty.");
                            break;
                        }
                        System.out.println(order.getSummary());

                        boolean confirm = ui.confirmOrder();
                        if (confirm) {
                            System.out.println("Order completed.");
                            ordering = false;
                        }
                    }

                    case 0 -> {
                        System.out.println("Order Cancelled.");
                        ordering = false;
                    }

                }
            }
        }

        private static Sandwich buildSandwich(UserInterface ui) {
            BreadType breadType = ui.askingUserForBreadType();
            SandwichSize sandwichSize = ui.promptingUserForSandwhichSize();
            boolean toasted = ui.readYesNo("Do you want it toasted?");

            Sandwich sandwich = new Sandwich("User Sandwich", breadType,sandwichSize, toasted);

            if ( ui.readYesNo("Add Chicken?")
                sandwich.addMeat(ToppingType.CHICKEN);
        }
    }
}