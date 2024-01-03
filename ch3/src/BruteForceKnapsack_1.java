import java.util.List;

public class BruteForceKnapsack_1 {
    static class Item {
        public int weight;
        public int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void Subsets(List<Item> items, List<Item> subsets, List<Item> best_subset, int index, int total_weight, int total_value, int capacity,  int[] best_value) {
        //items物品的列表
        //subsets 当前的组合
        //best_subset最好的组合
        //index当前递归的物品的索引
        //total_weight当前总重量
        //total_value当前总价值
        //capacity背包总容量
        //best_value最大价值
        if (index == items.size()) {
            //到达最后一个人=物品 检查当前组合是否是最优解
            if (total_value > best_value[0] && total_weight < )
        }


        //不选择当前物品
    }

    public static void main(String[] args) {

    }
}
