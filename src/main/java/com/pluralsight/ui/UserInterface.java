package com.pluralsight.ui;

import com.pluralsight.models.*;

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
        int choice = readUserIntInput(1);
        return switch (choice) {
            case 1 -> BreadType.WHITE;
            case 2 -> BreadType.WHEAT;
            case 3 -> BreadType.RYE;
            case 4 -> BreadType.WRAP;
            default -> BreadType.WHITE;
        };
    }

    public SandwichSize promptingUserForSandwhichSize() {
        System.out.println("""
                Choose Sandwich Size; 
                1) 4"
                2) 8"
                3) 12"
                Enter choice (1-3): """);

        int choice = readUserIntInput(1);
        return switch (choice) {
            case 1 -> SandwichSize.FOUR;
            case 2 -> SandwichSize.EIGHT;
            case 3 -> SandwichSize.TWELVE;
            default -> SandwichSize.FOUR;
        };

    }

//    public boolean promptForToasted() {}
//
//    public Toppings promptingUserForToppings();


    public DrinkSize promptingForDrinkSize() {
        System.out.println("""
                Choose Drink Size:
                1) Small($2.00)
                2)Medium($2.50)
                3)Large($3.00)
                Enter your choice (1-3): """);

        int choice = readUserIntInput(1);

        return switch (choice) {
            case 1 -> DrinkSize.SMALL;
            case 2 -> DrinkSize.MEDIUM;
            case 3 -> DrinkSize.LARGE;
            default -> DrinkSize.SMALL;
        };
    }

    public DrinkFlavour promptingForDrinkFlavour(){
        System.out.println("""
                Choose drink flavour; 
                1)Cola
                2)Fanta
                3)Sprite
                4)Pepsi
                Enter choice (1-4)
                """);
        int choice = readUserIntInput(1);
        return switch (choice) {
            case 1 -> DrinkFlavour.COLA;
            case 2 -> DrinkFlavour.FANTA;
            case 3 -> DrinkFlavour.SPRITE;
            case 4 -> DrinkFlavour.PEPSI;
            default -> DrinkFlavour.COLA;


        };
    }
//
//    public ChipType promptingForChipType();
//
//    public boolean confirmOrder();

    private int readUserIntInput(int defaultValue){
        try {
            return Integer.parseInt(myScanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Iinvalid Input. Defaulting to" + defaultValue + "choice .");
            return defaultValue;
        }
    }

}
