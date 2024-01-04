package com.cn;
public class GreedyKnapsack {

    static class Item {
        double weight;
        double value;

        public Item(double weight, double value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void knapsack(int n, double capacity, double[] values, double[] weights, double[] result) {
        for (int i = 0; i < n; i++) {
            result[i] = 0; // Initialize the result array
        }

        double remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            if (weights[i] > remainingCapacity) {
                break; // Stop if the item cannot fit completely
            }

            result[i] = 1; // Fully include the item
            remainingCapacity -= weights[i];
        }

        // If there is remaining capacity, include a fraction of the next item
        if (remainingCapacity > 0 && n > 0) {
            result[n - 1] = remainingCapacity / weights[n - 1];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        double capacity = 16;
        double[] values = {20, 30, 50, 10};
        double[] weights = {2, 5, 10, 5};
        double[] result = new double[n];

        knapsack(n, capacity, values, weights, result);

        // Output the result
        System.out.println("Item selection:");
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + ": " + result[i]);
        }
    }
}
