package com.ata;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Shop {
    private String name;
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private Products products = new Products();


    public Shop() { this.name = "T-Shirt Mart"; }

    public String getName() {

        return this.name;
    }

    public void printProducts(ArrayList<Product> products) {

        System.out.println("--Products--");

        for (Product product: products) {

            System.out.println("ID " + product.getID() + ": " + product.getName() + " - $" + df.format(product.getPrice()));
        }

        System.out.println();
    }

    public int findProduct(String searchText) {

        for(Product product : products.products) {

            if(searchText.equals(product.getName())) {

                return product.getID();
            }
        }
        return -1;
    }
}
