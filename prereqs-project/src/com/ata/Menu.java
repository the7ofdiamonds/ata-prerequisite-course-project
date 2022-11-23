package com.ata;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    private Shop shop = new Shop();
    private Cart cart = new Cart();
    private Products products = new Products();
    private MenuOption[] menuOptions = MenuOption.values();

    public Menu() {}

    public void executeMenu() {

        printMenu();

        while(scanner.hasNextInt()) {

            printMenu();

            int option = getNextIntFromUser();

            if (option == 0) {

                exit();
            }

            if (option == 1) {

                System.out.println();
                shop.printProducts(products.products);
            }

            if (option == 2) {

                System.out.println();
                cart.addItem(products.products);
            }

            if (option == 3) {

                System.out.println();
                System.out.println("Enter the item to search for:");

                String itemToFind = getNextStringLineFromUser();

                int id = shop.findProduct(itemToFind);

                if (id == -1) {

                    System.out.println();
                    System.out.println("That product was not found.");
                }

                if (id >= 0) {

                    System.out.println();
                    System.out.println(itemToFind + " was found and its product id is " + id);
                }

                System.out.println();
            }

            if (option == 4) {

                System.out.println();
                cart.showDetails();
            }

            if (option == 5) {

                System.out.println();
                cart.checkout();
            }

            if (option >= menuOptions.length) {

                System.out.println();
                System.out.println("Selection Not Found");
            }
        }
    }

    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {

        System.out.println("Hello. Please enter your name:");
        String customerName = scanner.nextLine();
        System.out.println("Welcome " + customerName + " to " + shop.getName());
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {

        scanner.close();
        System.out.println();
        System.out.println("Exiting now. Goodbye.");
        System.exit(0);
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
