package liutao;

import java.util.Arrays;

public class DynamicProgrammingKnapsack_1 {

    static class Item {
        public int weight;
        public int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int capacity = 16;
        Item[] items = {
                new Item(2, 20),
                new Item(5, 30),
                new Item(10, 50),
                new Item(5, 10)
        };

        int[][] dpTable = new int[items.length + 1][capacity + 1];

        for (int i = items.length - 1; i >= 0; i--) {
            //每一行
            for (int j = 0; j <= capacity; j++) {
                //每一列
                if (j < items[i].weight) {
                    //容量不允许 不装 就是等于上一列(这里是下一列 因为是从4--0遍历的
                    dpTable[i][j] = dpTable[i + 1][j];
                } else {
                    //装或不装的最大值
                    dpTable[i][j] = Math.max(dpTable[i + 1][j], dpTable[i + 1][j - items[i].weight]
                            + items[i].value);
                }
            }
        }

        // Constructing the solution
        int currentCapacity = capacity;
        for (int i = 0; i < items.length; i++) {
            if (currentCapacity < items[i].weight) {
                // Item i is not included in the optimal solution
                System.out.println("Item " + (i + 1) + " is not selected.");
            } else if (dpTable[i][currentCapacity] == dpTable[i + 1][currentCapacity]) {
                // Item i is not included in the optimal solution
                System.out.println("Item " + (i + 1) + " is not selected.");
            } else {
                // Item i is included in the optimal solution
                System.out.println("Item " + (i + 1) + " is selected.");
                currentCapacity -= items[i].weight;
            }
        }

        // Print the total value of the optimal solution
        System.out.println("Total value of the optimal solution: " + dpTable[0][capacity]);
    }
}
