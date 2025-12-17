/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_supermarketsystem;

/**
 * Represents a product in the supermarket system.
 * Stores product details, stock quantity, and the last four activities.
 *
 * @author Cornelius Adenuga
 * @author Baran Albay
 * @author Bhoumik
 */
public class Product {

    private final String productId;
    private final String productName;
    private final String entryDate;
    private int quantity;

    private final ActivityQueue activities;

    public Product(String productId, String productName, String entryDate, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.entryDate = entryDate;
        this.quantity = quantity;
        this.activities = new ActivityQueue();
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Activity[] getActivities() {
        return activities.getActivities();
    }

    private void addActivity(Activity activity) {
        // Record activity (only last 4 are kept by ActivityQueue)
        activities.enqueue(activity);
    }

    public boolean addToStock(int qty) {
        // Prevent invalid quantities
        if (qty <= 0) {
            System.out.println("Invalid quantity. Must be greater than 0.");
            return false;
        }

        quantity += qty;

        addActivity(new Activity(
                "A" + System.currentTimeMillis(),
                "AddToStock",
                qty,
                java.time.LocalDate.now().toString()
        ));
        return true;
    }

    public boolean removeFromStock(int qty) {
        // Prevent invalid quantities and negative stock
        if (qty <= 0) {
            System.out.println("Invalid quantity. Must be greater than 0.");
            return false;
        }
        if (qty > quantity) {
            System.out.println("Not enough stock. Current quantity: " + quantity);
            return false;
        }

        quantity -= qty;

        addActivity(new Activity(
                "A" + System.currentTimeMillis(),
                "RemoveFromStock",
                qty,
                java.time.LocalDate.now().toString()
        ));
        return true;
    }

    @Override
    public String toString() {
        return productId + " - " + productName +
               " | Quantity: " + quantity +
               " | Entry Date: " + entryDate;
    }
}

