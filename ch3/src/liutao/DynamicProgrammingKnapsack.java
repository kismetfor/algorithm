package liutao;

import java.util.Arrays;

public class DynamicProgrammingKnapsack {

    public static void main(String[] args) {
        int[] weights = {2, 5, 10, 5};
        int[] values = {20, 30, 50, 10};
        int W = 16;

        int n = weights.length;

        int[][] m = new int[n + 1][W + 1];

        for (int j = 0; j <= W; j++) {
            m[n][j] = (j < weights[n - 1]) ? 0 : values[n - 1];
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= W; j++) {
                m[i][j] = (j < weights[i - 1]) ? m[i + 1][j] : Math.max(m[i + 1][j], m[i + 1][j - weights[i - 1]] + values[i - 1]);
            }
        }

        System.out.println("Optimal solution value: " + m[1][W]);

        // Constructing the optimal solution
        int remainingWeight = W;
        for (int i = 1; i <= n - 1; i++) {
            if (m[i][remainingWeight] != m[i + 1][remainingWeight]) {
                System.out.println("Item " + i + " is selected.");
                remainingWeight -= weights[i - 1];
            } else {
                System.out.println("Item " + i + " is not selected.");
            }
        }
    }
}


