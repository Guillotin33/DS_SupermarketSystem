/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ds_supermarketsystem;

import java.util.Scanner;

/**
 * Console-based user interface for testing the supermarket system.
 *
 * @author Cornelius Adenuga
 * @author Baran Albay
 * @author Bhoumik
 */
public class DS_SupermarketSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SupermarketSystem system = new SupermarketSystem();

        boolean running = true;

        while (running) {
            System.out.println("\n===== SUPERMARKET SYSTEM MENU =====");
            System.out.println("1. Add new product");
            System.out.println("2. Display all products");
            System.out.println("3. Delete a product");
            System.out.println("4. Add stock to product");
            System.out.println("5. Remove stock from product");
            System.out.println("6. Display product activities (sorted)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Entry Date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Initial Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    system.addProduct(new Product(id, name, date, qty));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    system.displayProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    system.deleteProduct(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    Product addP = system.findProduct(scanner.nextLine());
                    if (addP != null) {
                        System.out.print("Enter quantity to add: ");
                        int addQty = scanner.nextInt();
                        scanner.nextLine();

                        if (addP.addToStock(addQty)) {
                            System.out.println("Stock added.");
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Product ID: ");
                    Product remP = system.findProduct(scanner.nextLine());
                    if (remP != null) {
                        System.out.print("Enter quantity to remove: ");
                        int remQty = scanner.nextInt();
                        scanner.nextLine();

                        if (remP.removeFromStock(remQty)) {
                            System.out.println("Stock removed.");
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    Product actP = system.findProduct(scanner.nextLine());
                    if (actP != null) {
                        Activity[] acts = actP.getActivities();
                        sortActivitiesByQuantity(acts);

                        System.out.println("Last activities (sorted by quantity):");
                        for (Activity a : acts) {
                            System.out.println(a);
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // Sort activities by quantity using Bubble Sort
    public static void sortActivitiesByQuantity(Activity[] activities) {
        for (int i = 0; i < activities.length - 1; i++) {
            for (int j = 0; j < activities.length - i - 1; j++) {
                if (activities[j].getQuantity() > activities[j + 1].getQuantity()) {
                    Activity temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                }
            }
        }
    }
}
