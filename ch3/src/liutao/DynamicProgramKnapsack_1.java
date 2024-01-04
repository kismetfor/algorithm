package liutao;

public class DynamicProgramKnapsack_1 {
    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(2, 20),
                new Item(5, 30),
                new Item(10, 50),
                new Item(5, 10),
        };

        int capacity = 16;
        int[][] dp = new int[items.length+1][capacity+1];

        for (int i = 1; i <= items.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < items[i-1].w) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i-1].w]+items[i-1].v);
                }
            }
        }
        System.out.println(dp[items.length][capacity]);
    }
}
