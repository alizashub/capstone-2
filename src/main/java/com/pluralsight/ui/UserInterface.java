package com.pluralsight.ui;
import com.pluralsight.models.BreadType;
import com.pluralsight.models.DrinkSize;
import com.pluralsight.models.SandwichSize;

import java.util.Scanner;

    public class UserInterface {
    private final Scanner myScanner;

    public UserInterface() {
        this.myScanner = new Scanner(System.in);
    }

    public int showHomeScreen() {
        System.out.println("""
                Welcome!
                1)New Order
                0)Exit
                Enter Your Choice:
                """);

        int choice = 0;
        try {
            choice = Integer.parseInt(myScanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
        return choice;
    }

    public int showOrderMenu() {
    System.out.println("""
            Order Menu:
            1) Add Sandwich
            2) Add Drink
            3) Add Chips
            4) Checkout
            0) Cancel Order
            Enter your choice:
            """);
    int choice = 0;
    try {
        choice = Integer.parseInt(myScanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid Input");
    }
    return choice;
}

    public BreadType askingUserForBreadType() {
    System.out.println("""
            Choose Your Bread Type :
            1) White
            2) Wheat
            3) Rye
            4) Wrap
            Enter choice (1-4)""");
    int choice = 1;
    try {
        choice = Integer.parseInt(myScanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid Input");
    }
    return switch (choice) {
        case 1 -> BreadType.WHITE;
        case 2 -> BreadType.WHEAT;
        case 3 -> BreadType.RYE;
        case 4 -> BreadType.WRAP;
        default -> BreadType.WHITE;
    };
}

    public SandwichSize promptingUserForSandwhichSize();

    public boolean promptForToasted();

    public DrinkSize promptingForDrinkSize();

    public

}
