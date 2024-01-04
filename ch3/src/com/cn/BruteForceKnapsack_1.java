package com.cn;

import java.util.ArrayList;
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
    public static void Subsets(List<Item> items, List<Item> subset, List<Item> best_subset, int index, int total_weight, int total_value, int capacity,  int[] best_value) {
        //items物品的列表
        //subset 当前的组合
        //best_subset最好的组合
        //index当前递归的物品的索引
        //total_weight当前总重量
        //total_value当前总价值
        //capacity背包总容量
        //best_value最大价值
        if (index == items.size()) {
            //到达最后一个人=物品 检查当前组合是否是最优解
            if (total_value > best_value[0] && total_weight < capacity) {
                best_value[0] = total_value;
                best_subset.clear();
                best_subset.addAll(subset);
            }
            return;
        }


        //不选择当前物品
        Subsets(items, subset, best_subset, index+1, total_weight, total_value, capacity, best_value);
        System.out.println("不选择执行的: "+"下标: "+index);

        //选择当前物品
        subset.add(items.get(index));
        Subsets(items, subset, best_subset, index+1, total_weight+items.get(index).weight, total_value+items.get(index).value, capacity, best_value);
        subset.remove(subset.size()-1);
        System.out.println("选择执行: " + "下标: "+ index);
    }

    //打印结果
    private static void printSet(List<Item> best_subset) {
        int total_weight = 0;
        int total_value = 0;
        System.out.println("选择的物品有: ");
        for (Item item : best_subset) {
            System.out.println("重量: "+ item.weight + ", 价值 "+ item.value);
            total_value += item.value;
            total_weight += item.weight;
        }
        System.out.println("总重量: " +total_weight);
        System.out.println("总价值: " +total_value);
    }
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 20));
        items.add(new Item(5, 30));
        items.add(new Item(10, 50));
        items.add(new Item(5, 10));

        int capacity = 16;

        List<Item> best_subset = new ArrayList<>();
        int[] best_value = {0};

        Subsets(items, new ArrayList<>(), best_subset, 0, 0, 0, capacity, best_value);

        printSet(best_subset);

        System.out.println(items.size());
    }
}
