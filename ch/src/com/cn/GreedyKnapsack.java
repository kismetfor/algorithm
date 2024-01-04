package com.cn;
import java.util.Arrays;

public class GreedyKnapsack {

        // 定义排序函数，按照价值密度（价值除以重量）降序排列
        private static void sort(float[] v, float[] w) {
            int n = v.length;
            float[] density = new float[n];
            for (int i = 0; i < n; i++) {
                density[i] = v[i] / w[i];
            }

            // 使用Java内置的排序函数Arrays.sort()，传入Comparator.reverseOrder()以实现降序排序
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            Arrays.sort(indices, (a, b) -> Float.compare(density[b], density[a]));

            // 根据排序结果重新排列v和w数组
            float[] sortedV = new float[n];
            float[] sortedW = new float[n];
            for (int i = 0; i < n; i++) {
                sortedV[i] = v[indices[i]];
                sortedW[i] = w[indices[i]];
            }

            // 将排序后的结果复制回原数组
            System.arraycopy(sortedV, 0, v, 0, n);
            System.arraycopy(sortedW, 0, w, 0, n);
        }

        public static void knapsack(int n, float M, float[] v, float[] w, float[] x) {
            // 对物品按照价值密度降序排序
            sort(v, w);

            int i;
            // 初始化解数组
            for (i = 0; i < n; i++) {
                x[i] = 0;
            }

            float c = M;
            // 尝试将物品装入背包
            for (i = 0; i < n; i++) {
                if (w[i] > c) {
                    break;
                }
                x[i] = 1;
                c -= w[i];
            }

            // 若背包未装满，则装入部分物品
            if (i < n) {
                x[i] = c / w[i];
            }
        }

        public static void main(String[] args) {
            // 示例用法
            int n = 4; // 物品数量
            float M = 5; // 背包容量

            float[] v = {3, 5, 2, 8}; // 物品价值数组
            float[] w = {2, 4, 1, 3}; // 物品重量数组

            float[] x = new float[n]; // 解数组

            // 解决背包问题
            knapsack(n, M, v, w, x);

            // 打印结果
            System.out.println("背包装入情况：");
            for (int i = 0; i < n; i++) {
                System.out.println("物品" + (i + 1) + ": " + x[i]);
            }
        }
    }
