package liutao;

public class DynamicProgramKnapsack {
    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        int capacity = 16;
        Item[] items = new Item[] {
           new Item(2, 20),
           new Item(5, 30),
           new Item(10, 50),
           new Item(5, 10),
        } ;

        int[][] dp = new int[items.length+1][capacity+1];

        for (int i = 1; i <= items.length; i++) {
            //从一开始是因为第一行全是0
            for (int j = 0; j <= capacity; j++) {
                if(items[i-1].w > j) {
                    //重量不允许
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i-1].w]+items[i-1].v);
                }
            }
        }
        System.out.println("最大价值: " + dp[items.length][capacity]);
    }
}
