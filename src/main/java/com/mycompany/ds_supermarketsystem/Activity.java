/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_supermarketsystem;

/**
 * Represents a stock activity (AddToStock or RemoveFromStock) for a product.
 *
 * @author Cornelius Adenuga
 * @author Baran Albay
 * @author Bhoumik
 */
public class Activity {

    private final String activityId;
    private final String activityName;
    private final int quantity;
    private final String date;

    public Activity(String activityId, String activityName, int quantity, String date) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.quantity = quantity;
        this.date = date;
    }

    public String getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return activityName + " | Qty: " + quantity + " | Date: " + date;
    }
}
