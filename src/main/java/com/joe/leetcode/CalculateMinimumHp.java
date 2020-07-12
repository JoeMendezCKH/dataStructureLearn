package com.joe.leetcode;

import java.util.Arrays;

/**
 * 走迷宫类, 每次消耗血量, 求最小的初始值
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * @author Joe
 * @create 2020/7/12 10:54
 */
public class CalculateMinimumHp {

    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(calculate01(dungeon));
    }

    /**
     * 反向 DP
     * dp[i][j] 表示从坐标 (i,j) 到终点 需要的 最小初始值
     *
     * @param dungeon 地下城坐标
     */
    public static int calculate01(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        // 将dp数组每一项初始化为 Integer.Max
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 因为 dp[i][j] 表示的是(i,j)到终点需要的的最小初始值, 所以终点上方和左方的初始值为 1 即可
        dp[n][m - 1] = dp[n - 1][m] = 1;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                // 比较下方 和 右方 哪个需要的值小
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                // 需要的值 - 当前坐标消耗的值, 如果为负, 则增加需要的值, 如果为正, 则不需要额外增加, 为1即可
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
