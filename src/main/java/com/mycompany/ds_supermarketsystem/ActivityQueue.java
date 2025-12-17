/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_supermarketsystem;

/**
 * Custom queue that stores ONLY the last four activities.
 * If a 5th activity is added, the oldest one is removed.
 *
 * @author Cornelius Adenuga
 * @author Baran Albay
 * @author Bhoumik
 */
public class ActivityQueue {

    private final Activity[] activities;
    private int size;
    private static final int MAX = 4;

    public ActivityQueue() {
        activities = new Activity[MAX];
        size = 0;
    }

    public void enqueue(Activity activity) {
        if (size < MAX) {
            activities[size] = activity;
            size++;
        } else {
            // Queue full: remove oldest by shifting left, then add newest at the end
            for (int i = 1; i < MAX; i++) {
                activities[i - 1] = activities[i];
            }
            activities[MAX - 1] = activity;
        }
    }

    public Activity[] getActivities() {
        Activity[] result = new Activity[size];
        for (int i = 0; i < size; i++) {
            result[i] = activities[i];
        }
        return result;
    }

    public int getSize() {
        return size;
    }
}


