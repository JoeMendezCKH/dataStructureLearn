package com.joe.usealgorithm.dynamic;

import java.util.Arrays;

/**
 * 动态规划, 填表法
 * @author Joe
 * @create 2020/4/20 14:19
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包容量
        int m = 4;
        // 物品个数
        int n = val.length;

        // v[i][j] 在前 i 个物品中,容量为 j 的背包中装入最大价值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];


        for (int[] ints : v) {
            ints[0] = 0;
        }
        Arrays.fill(v[0], 0);

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }


        show(v);

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                // 减去 第 i 个商品的重量
                j -= w[i - 1];
            }
            i--;
        }
        show(path);

    }

    private static void show(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t   ");
            }
            System.out.println();
        }
    }
}
