package com.rain;

import java.util.ArrayList;
import java.util.List;

public class BruteForceKnapsack_2 {
    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 20));
        items.add(new Item(5, 30));
        items.add(new Item(10, 50));
        items.add(new Item(5, 10));
        items.add(new Item(5, 10));
        items.add(new Item(5, 10));
        items.add(new Item(5, 10));
        items.add(new Item(5, 10));

        int[] best_value = new int[2];
        //0用来存储最大价值, 1用来存储if调用次数 也就是子集数目, 可以说是时间复杂度
        int capacity = 17;
        List<Item> best_subset = new ArrayList<>();
        Subsets(items, best_subset, new ArrayList<>(), 0, 0, 0, capacity, best_value);

        PrintSubset(best_subset);
        System.out.println("物品数量"+items.size()+", 子集数目"+ best_value[1]);
    }

    public static void Subsets (List<Item> items, List<Item> best_subset, List<Item> current_subset,
                  int index, int total_weight, int total_value, int capacity, int[] best_value) {
        if(index == items.size()) {
            if(total_value>best_value[0] && total_weight<=capacity) {
                best_value[0] = total_value;
                best_subset.clear();
                best_subset.addAll(current_subset);
            }
            best_value[1]++;
            return;
        }
        //不选择
        Subsets(items, best_subset, current_subset, index+1, total_weight, total_value,
                capacity, best_value);

        //选择
        current_subset.add(items.get(index));
        Subsets(items, best_subset, current_subset, index+1, total_weight+items.get(index).w, total_value+items.get(index).v,
                capacity, best_value);
        current_subset.remove(current_subset.size()-1);
    }
    public static void PrintSubset(List<Item> subset) {
        int weight = 0;
        int value = 0;
        System.out.println("选择了: ");
        for (Item i : subset) {
            System.out.println("重量" + i.w+", "+"价值" + i.v);
            weight += i.w;
            value += i.v;
        }
        System.out.println("总重量"+weight+", "+"总价值"+value);
    }
}
