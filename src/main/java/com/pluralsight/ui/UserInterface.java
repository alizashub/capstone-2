package com.pluralsight.ui;
import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import java.util.Scanner;

/**
 * UserInterface
 * handles all console inputs/output
 * controls the flow of placing the order
 *
 */
public class UserInterface {
    private final Scanner myScanner;
    private Order currentOrder;

    public UserInterface() {
        this.myScanner = new Scanner(System.in);
    }
    // starts the main menu loop

    public void start() {
        boolean running = true;

        while (running) {
            int choice = showHomeScreen();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    System.out.println("Thank you for using Aliza's Deli App!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    // homescreen

    private int showHomeScreen() {
        System.out.println("""
                +++++++++++++++++++++++++++++
                Welcome to Aliza's Deli App!!
                +++++++++++++++++++++++++++++
                
                1) New Order
                0) Exit
                
                Enter Your Choice: """);
        return readInt();
    }

    // order flow
    private void startNewOrder() {
        currentOrder = new Order();
        boolean ordering = true;
        while (ordering) {
            int choice = showOrderScreen();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    addSide();
                    break;
                case 5:
                    checkout();
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order has been cancelled");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private int showOrderScreen() {
        System.out.println("""
                ++++++++++++ Order Menu ++++++++++++
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Add Sides
                5) Checkout
                0) Cancel Order
                Enter your choice: """);
        return readInt();
    }

    private void addSandwich() {
        System.out.println("\nLet's Build A Sandwich");

        SandwichSize size = chooseSandwichSize();
        BreadType breadType = chooseBreadType();
        boolean toasted = chooseToasted();

        Sandwich sandwich = new Sandwich("Custom Sandwich", breadType, size, toasted);

        chooseToppings(sandwich);
        chooseSauces(sandwich);

        currentOrder.addItem(sandwich);
        System.out.println("Sandwich has been added!");
    }

    private SandwichSize chooseSandwichSize() {
        System.out.println("\nChoose the size of your sandwich:");
        SandwichSize[] sizes = SandwichSize.values();

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ")" + sizes[i].toString() + "- $" + sizes[i].getBasePrice());
        }

        int choice = readIntInRange(1, sizes.length);
        return sizes[choice - 1];
    }

    private BreadType chooseBreadType() {
        System.out.println("Choose your bread type for the sandwich:");
        BreadType[] breads = BreadType.values();

        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ")" + breads[i].getDisplayName());
        }
        int choice = readIntInRange(1, breads.length);

        return breads[choice - 1];
    }

    private boolean chooseToasted() {
        System.out.println("""
                Would you like your bread toasted?
                1) Yes
                2) No
                
                Enter your choice : 
                """);
        int choice = readIntInRange(1, 2);
        return choice == 1;
    }

    private void chooseToppings(Sandwich sandwich) {
        System.out.println(" ++++++++++++ Toppings Avalible ++++++++++++");
        ToppingType[] tops = ToppingType.values();

        boolean adding = true;

        while (adding) {
            System.out.println("Choose a topping: ");
            for (int i = 0; i < tops.length; i++) {
                System.out.println((i + 1) + ")" + tops[i].getDisplayName());
            }
            System.out.println("0) Done");

            int choice = readIntInRange(0, tops.length);

            if (choice == 0) break;

            ToppingType selected = tops[choice - 1];

            boolean extra = false;

            // only meat & cheese has "extra" option
            if (selected.isMeat() || selected.isCheese()) {
                System.out.println("""
                        Would you like to get an extra portion?
                        1) Yes
                        2) No
                        """);
                extra = readIntInRange(1, 2) == 1;
            }
            sandwich.addTopping(new Topping(selected, extra));
            System.out.println(selected.getDisplayName() + " added.");
        }
    }

    private void chooseSauces(Sandwich sandwich) {
        System.out.println("Sauces");
        SauceType[] sauces = SauceType.values();

        boolean adding = true;
        while (adding) {
            System.out.println("Pick a sauces you would like to add.");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ")" + sauces[i].getDisplayName());
            }
            System.out.println("0) Done");
            int choice = readIntInRange(0, sauces.length);
            if (choice == 0) break;

            SauceType selected = sauces [choice - 1];
            sandwich.addSauce(selected);
            System.out.println(selected.getDisplayName() + " added.");

        }
    }

    //DRINKS

    private void addDrink(){
        System.out.println("\nAdd Drinks");

        DrinkSize size = chooseDrinkSize();
        DrinkFlavour flavour = chooseDrinkFlavour();

        currentOrder.addItem(new Drink("Drink",size,flavour));
        System.out.println("Drink Added!\n");
    }

    private DrinkSize chooseDrinkSize() {
        System.out.println("\nChoose Drink Size:");

        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i].getDisplayName() +
                    " - $" + sizes[i].getPrice());
        }
        int choice = readIntInRange(1, sizes.length);
        return sizes[choice - 1];
    }

    private DrinkFlavour chooseDrinkFlavour(){
        System.out.println("Choose Drink Flavour");

        DrinkFlavour[] flavors = DrinkFlavour.values();

        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplayName());
        }
        int choice = readIntInRange(1,flavors.length);
        return flavors[choice - 1];
    }

    private void addChips(){
        System.out.println("\nAdd Chips");
        ChipType[] chips = ChipType.values();

        for (int i = 0; i < chips.length; i++) {
            System.out.println((i + 1) + ") " + chips[i].getDisplayName());
        }

        int choice = readIntInRange(1, chips.length);

        currentOrder.addItem(new Chips("Chips", (chips [ choice - 1 ])));
        System.out.println("Chips added!\n");
    }

    private void addSide(){
        System.out.println("\nChoose Sides : ");
        SideType[] sides = SideType.values();

        for (int i = 0; i < sides.length; i++) {
            System.out.println((i + 1) + ") " + sides[i].getDisplayName());
        }

        int choice = readIntInRange(1, sides.length);
        currentOrder.addItem(new Side(sides[ choice - 1 ]));
        System.out.println("Side added!\n");
    }

    private void checkout(){
        System.out.println(" \n ++++++++ Checkout ++++++++ \n");

        String recieptText  = currentOrder.generateReceiptText();
        System.out.println(recieptText);

        ReceiptWriter.saveReceipt(recieptText);
        System.out.println("Receipt saved!\n");
    }


    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(myScanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice, please try again. ");
            }
        }
    }

    private int readIntInRange(int min, int max) {
        while (true) {
            int value = readInt();
            if (value >= min && value < +max) {
                return value;
            }
            System.out.print("Number must be between" + min + " and " + max + ": ");
        }
    }
}



