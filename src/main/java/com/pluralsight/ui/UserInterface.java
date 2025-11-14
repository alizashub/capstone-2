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
                 _______  ___      ___   _______  _______  __   _______    ______   _______  ___      ___ \s
                |   _   ||   |    |   | |       ||   _   ||  | |       |  |      | |       ||   |    |   |\s
                |  |_|  ||   |    |   | |____   ||  |_|  ||__| |  _____|  |  _    ||    ___||   |    |   |\s
                |       ||   |    |   |  ____|  ||       |     | |_____   | | |   ||   |___ |   |    |   |\s
                |       ||   |___ |   | | ______||       |     |_____  |  | |_|   ||    ___||   |___ |   |\s
                |   _   ||       ||   | | |_____ |   _   |      _____| |  |       ||   |___ |       ||   |\s
                |__| |__||_______||___| |_______||__| |__|     |_______|  |______| |_______||_______||___|\s
                
                1) New Order
                0) Exit""");
        System.out.print("Enter Your Choice:");
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
                0) Cancel Order""");
        System.out.print("Enter Your Choice:");
        return readInt();
    }
    private void addSandwich() {
        System.out.print("\n++++++++++++ Let's Build A Sandwich ++++++++++++");

        SandwichSize size = chooseSandwichSize();
        BreadType breadType = chooseBreadType();
        boolean toasted = chooseToasted();

        // creating the sandwich object
        Sandwich sandwich = new Sandwich("Custom Sandwich", breadType, size, toasted);

        chooseToppings(sandwich);
        chooseSauces(sandwich);

        // after sauces, topping etc the sandwhich object is add to the items array
        //public void addItem(MenuItem item) {items.add(item);
        //sandwhich becomes part of the current order
        // after adding all the items, they all end up on one arraylist
        currentOrder.addItem(sandwich);
        System.out.println("\nSandwich has been added!");
    }

    private SandwichSize chooseSandwichSize() {
        System.out.println("\nChoose the size of your sandwich");
        SandwichSize[] sizes = SandwichSize.values();

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ")" + sizes[i].toString() + "- $" + sizes[i].getBasePrice());
        }
        System.out.print("Enter your choice : ");
        int choice = readIntInRange(1, sizes.length);
        return sizes[choice - 1];
    }

    private BreadType chooseBreadType() {
        System.out.println("\nChoose your bread type for the sandwich:");
        // returns all the enum constants as an array so we can loop over it
        BreadType[] breads = BreadType.values();

        for (int i = 0; i < breads.length; i++) {
            System.out.println((i + 1) + ")" + breads[i].getDisplayName());
        }
        System.out.print("Enter your choice : ");
        int choice = readIntInRange(1, breads.length);
        // returns the chosen enum value choice -1 because user : 1 we convert that to the index which is 0
        return breads[choice - 1];
    }

    private boolean chooseToasted() {
        System.out.println("""
                
                Would you like your bread toasted?
                1) Yes
                2) No""");
                System.out.print("Enter Your Choice:");
        int choice = readIntInRange(1, 2);
        return choice == 1;
    }

    private void chooseToppings(Sandwich sandwich) {
        // keeps looping until user chooses done
        boolean adding = true;

        while (adding) {

            System.out.println("\n********* Toppings Available *********");

            int number = 1; // numbering for the user

            // printing all regular toppings
            System.out.println("\n--- Regular Toppings ---");
            //looping through the enum
            for (ToppingType t : ToppingType.values()) {
                //only prints topping where category is REGULAR
                if (t.isRegular()) {

                    System.out.println(number + ") " + t.getDisplayName());
                    // increase number so the next toppin has a new number
                    number++;
                }
            }

            System.out.println("\n--- Meats ---");
            for (ToppingType t : ToppingType.values()) {
                if (t.isMeat()) {
                    System.out.println(number + ") " + t.getDisplayName());
                    number++;
                }
            }

            System.out.println("\n--- Cheeses ---");
            for (ToppingType t : ToppingType.values()) {
                if (t.isCheese()) {
                    System.out.println(number + ") " + t.getDisplayName());
                    number++;
                }
            }

            System.out.println("0) Done");
            System.out.print("\nChoose a topping:");

            int choice = readIntInRange(0, number - 1);
            if (choice == 0) break;

            // Convert user choice into correct ToppingType
            ToppingType selected = getToppingByNumber(choice);

            boolean extra = false;

            if (selected.isMeat() || selected.isCheese()) {
                System.out.println("Extra Portion?\n1) Yes\n2) No");
                extra = readIntInRange(1, 2) == 1;
            }

            // this adds a topping object in the arraylist
            sandwich.addTopping(new Topping(selected, extra));
            System.out.println(selected.getDisplayName() + " added!");
        }
    }

    private ToppingType getToppingByNumber(int number) {
    // convers the user display number back to the correct ToppingType enum
        int index = 1;

        // REGULAR
        for (ToppingType t : ToppingType.values()) {
            if (t.isRegular()) {
                if (index == number) return t;
                index++;
            }
        }

        // MEAT
        for (ToppingType t : ToppingType.values()) {
            if (t.isMeat()) {
                if (index == number) return t;
                index++;
            }
        }

        // CHEESE
        for (ToppingType t : ToppingType.values()) {
            if (t.isCheese()) {
                if (index == number) return t;
                index++;
            }
        }

        return null; // should never happen if input is validated
    }


    private void chooseSauces(Sandwich sandwich) {
        System.out.println("********* Sauces *********");
        SauceType[] sauces = SauceType.values();

        boolean adding = true;
        while (adding) {
            System.out.println("Pick a sauces you would like to add :");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ")" + sauces[i].getDisplayName());
            }
            System.out.println("0)  Done");
            System.out.print("Enter your choice : ");
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
        System.out.println("Enter your choice : ");
        int choice = readIntInRange(1, sizes.length);
        return sizes[choice - 1];
    }

    private DrinkFlavour chooseDrinkFlavour(){
        System.out.println("Choose Drink Flavour");

        DrinkFlavour[] flavors = DrinkFlavour.values();

        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i].getDisplayName());
        }
        System.out.println("Enter your choice : ");
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
        //to prevent user from entering an invalid number ( smallest number allowed, largest allowed number )
        while (true) {
            int value = readInt();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.print("Number must be between " + min + " and " + max + ": ");
        }
    }
}



