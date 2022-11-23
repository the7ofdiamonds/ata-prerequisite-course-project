package com.ata;

import java.util.ArrayList;

public class Products {

    public ArrayList<Product> products;

    public Products() {
        this.products = new ArrayList<>();
        Product product0 = new Product(0, "Crew Neck", 20.00d);
        Product product1 = new Product(1, "V-Neck", 20.00d);
        Product product2 = new Product(2, "Polo", 25.50d);
        Product product3 = new Product(3, "Boat Neck", 30.25d);
        Product product4 = new Product(4, "Tank Top", 15.75d);

        products.add(product0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }
}
