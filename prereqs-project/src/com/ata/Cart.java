package com.ata;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private Shop shop = new Shop();
    private ArrayList<Product> items = new ArrayList<>();
    private double taxRate;
    private double total;
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private NumberFormat nf = NumberFormat.getPercentInstance();
    private Scanner scanner = new Scanner(System.in);

    public Cart() {
        this.taxRate = .1d;
        nf.setMinimumFractionDigits(2);
    }

    public void addItem(ArrayList<Product> products) {

        System.out.println("Please enter the ID of the product you would like to purchase:");

        int id = scanner.nextInt();

        if (id >= products.size()) {

            System.out.println("That item ID is invalid and could not be added to the cart.");
        } else {

            items.add(products.get(id));
            System.out.println(products.get(id).getName() + " has been added to your cart.");
        }

        System.out.println();
    }

    public void showDetails() {

        if (items.size() == 0) {

            System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
        }

        if (items.size() > 0) {

            System.out.println("--Cart--");
            System.out.println("Item Count: " + items.size());
            System.out.println("Items:");

            double subtotal = 0d;

            for(Product item : items) {

                System.out.println(item.getName() + ": $" + df.format(item.getPrice()));

                subtotal += item.getPrice();
            }

            double tax = subtotal * taxRate;
            total = subtotal + tax;

            System.out.println();
            System.out.println("Pre-Tax Total: $" + df.format(subtotal));
            System.out.println("Post-Tax Total ("+nf.format(taxRate)+" Tax): $" + df.format(total));
        }

        System.out.println();
    }

    public void checkout() {

        if (items.size() == 0) {

            System.out.println("Your cart is currently empty. Please add at least one product to check out.");
        } else {

            System.out.println("Your total is $" + df.format(total));
            System.out.println("Thank you for shopping at " + shop.getName() + ".");
        }

        System.out.println();
    }
}
