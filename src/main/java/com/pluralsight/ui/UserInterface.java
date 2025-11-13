package com.pluralsight.ui;

import com.pluralsight.models.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class UserInterface {
    private final Scanner myScanner;

    public UserInterface() {
        this.myScanner = new Scanner(System.in);
    }

    public int showHomeScreen() {
        while (true) {
            System.out.println("""
                    Welcome!
                    1)New Order
                    0)Exit
                    Enter Your Choice:
                    """);
            int choice = readUserIntInput();

            if (choice == 1 || choice == 0) {
                return choice;
            }
            System.out.println("Invalid choice. Please enter 1 or 0. ");
        }
    }

    public int showOrderMenu() {
        while (true) {
            System.out.println("""
                    Order Menu:
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    Enter your choice:
                    """);
            int choice = readUserIntInput();

            if (choice >= 0 && choice <= 4) {
                return choice;
            }
            System.out.println("Invalid choice.Please enter a number between 0-4.");
        }
    }

    public BreadType askingUserForBreadType() {
        while (true) {
            System.out.println("""
                    Choose Your Bread Type :
                    1) White
                    2) Wheat
                    3) Rye
                    4) Wrap
                    Enter choice (1-4)""");

            int choice = readUserIntInput();

            switch (choice) {
                case 1 -> {
                    return BreadType.WHITE;
                }
                case 2 -> {
                    return BreadType.WHEAT;
                }
                case 3 -> {
                    return BreadType.RYE;
                }
                case 4 -> {
                    return BreadType.WRAP;
                }
            }
            System.out.println("Please choose a number between 1-4.");
        }
    }

    public SandwichSize promptingUserForSandwhichSize() {
        while (true) {
            System.out.println("""
                    Choose Sandwich Size;
                    1) 4"
                    2) 8"
                    3) 12"
                    Enter choice (1-3): """);

            int choice = readUserIntInput();

            switch (choice) {
                case 1 -> {
                    return SandwichSize.FOUR;
                }
                case 2 -> {
                    return SandwichSize.EIGHT;
                }
                case 3 -> {
                    return SandwichSize.TWELVE;
                }
            }
            System.out.println("Please choose a number between 1-3.");

        }
    }

    public DrinkSize askDrinkSize() {
        while (true) {
            System.out.println("""
                     Choose Drink Size:
                    1) Small ($2.00)
                    2) Medium ($2.50)
                    3) Large ($3.00)
                    Enter choice (1–3): """);
            int choice = readUserIntInput();
            switch (choice) {
                case 1 -> {
                    return DrinkSize.SMALL;
                }
                case 2 -> {
                    return DrinkSize.MEDIUM;
                }
                case 3 -> {
                    return DrinkSize.LARGE;
                }
            }
            System.out.println("Please enter a number between 1-3.");
        }
    }

    public DrinkFlavour askDrinkFlavour() {
        while (true) {
            System.out.println("""
                    Choose drink flavour; 
                    1)Cola
                    2)Fanta
                    3)Sprite
                    4)Pepsi
                    Enter choice (1-4);""");

            int choice = readUserIntInput();

            switch (choice) {
                case 1 -> {
                    return DrinkFlavour.COLA;
                }
                case 2 -> {
                    return DrinkFlavour.FANTA;
                }
                case 3 -> {
                    return DrinkFlavour.SPRITE;
                }
                case 4 -> {
                    return DrinkFlavour.PEPSI;
                }
            }
            System.out.println("Please enter 1-4");
        }
    }

    public ChipType promptingForChipType() {
        while (true) {
            System.out.println("""
                    Choose Chip type:
                    1)Lays,
                    2)Doritos,
                    3)Ruffles,
                    4)Takis
                    """);

            int choice = readUserIntInput();
            switch (choice) {
                case 1 -> {
                    return ChipType.LAYS;
                }
                case 2 -> {
                    return ChipType.DORITOS;
                }
                case 3 -> {
                    return ChipType.RUFFLES;
                }
                case 4 -> {
                    return ChipType.TAKIS;
                }
            }
            System.out.println("Please enter a number between 1-4.");
        }
    }

    public ToppingType askPremiumMeat() {
        while (true) {
            System.out.println("""
                    Choose a Meat you would like to add : 
                    1) Chicken
                    2) Bacon
                    3) Steak
                    4) Ham
                    5) Salami
                    6) Roast Beef
                    0) Do not want to add meats 
                    Enter choice: """);

            int choice = readUserIntInput();
                switch (choice) {
                    case 1 -> { return ToppingType.CHICKEN; }
                    case 2 -> { return ToppingType.BACON; }
                    case 3 -> { return ToppingType.STEAK; }
                    case 4 -> { return ToppingType.HAM; }
                    case 5 -> { return ToppingType.SALAMI; }
                    case 6 -> { return ToppingType.ROAST_BEEF; }
                    case 0 ->
                }
            }
        }
    }


    public boolean confirmOrder() {
        while (true) {
            System.out.println("""
                    Comfirm Order?
                    1)Yes
                    0) No
                    """);
            int value = readUserIntInput();

            if (value == 1) return true;
            if (value == 0) return false;
            System.out.println("Enter 1 for Yes or 0 for No.");
        }
    }

    private int readUserIntInput() {
        while (true) {
            String input = myScanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number : ");
            }
        }
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.println(prompt + " (1 = Yes, 0 = No):");
            int value = readUserIntInput();

            if (value == 1) return true;
            if (value == 0) return false;

            System.out.println("Invalid input. Please enter 1 or 0.");
        }
    }

}
