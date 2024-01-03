import java.util.ArrayList;
import java.util.List;

public class BruteForceKnapsack {

    // 物品类
    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // 递归穷举所有可能的物品组合
    private static void generateSubsets(List<Item> items, int index, List<Item> currentSubset, int currentWeight,
                                        int currentTotalValue, int capacity, List<Item> bestSubset, int[] bestTotal) {
        if (index == items.size()) {
            // 到达最后一个物品，检查当前组合是否是最优解
            if (currentTotalValue > bestTotal[0] && currentWeight <= capacity) {
                bestTotal[0] = currentTotalValue;
                bestSubset.clear();
                bestSubset.addAll(currentSubset);
            }
            return;
        }

        // 不选择当前物品
        generateSubsets(items, index + 1, currentSubset, currentWeight, currentTotalValue, capacity, bestSubset, bestTotal);

        // 选择当前物品
        currentSubset.add(items.get(index));
        generateSubsets(items, index + 1, currentSubset, currentWeight + items.get(index).weight,
                currentTotalValue + items.get(index).value, capacity, bestSubset, bestTotal);
        currentSubset.remove(currentSubset.size() - 1);
    }

    // 打印结果
    private static void printResult(List<Item> bestSubset) {
        int totalWeight = 0;
        int totalValue = 0;

        System.out.println("Selected items:");
        for (Item item : bestSubset) {
            System.out.println("Weight: " + item.weight + ", Value: $" + item.value);
            totalWeight += item.weight;
            totalValue += item.value;
        }

        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total Value: $" + totalValue);
    }

    public static void main(String[] args) {
        // 示例数据
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 20));
        items.add(new Item(5, 30));
        items.add(new Item(10, 50));
        items.add(new Item(5, 10));

        int capacity = 16;

        // 用于存储最优解
        List<Item> bestSubset = new ArrayList<>();
        int[] bestTotal = {0}; // 使用数组以在递归中修改值

        // 使用蛮力法求解
        generateSubsets(items, 0, new ArrayList<>(), 0, 0, capacity, bestSubset, bestTotal);

        // 打印结果
        printResult(bestSubset);
    }
}
