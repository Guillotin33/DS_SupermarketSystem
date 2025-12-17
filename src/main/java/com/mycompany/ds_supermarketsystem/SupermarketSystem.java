/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_supermarketsystem;

import java.util.ArrayList;

/**
 * Manages all products in the system using ArrayList (Java Collections Framework).
 *
 * @author Cornelius Adenuga
 * @author Baran Albay
 * @author Bhoumik
 */
public class SupermarketSystem {

    private final ArrayList<Product> products;

    public SupermarketSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public Product findProduct(String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(String productId) {
        Product p = findProduct(productId);
        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }
}

