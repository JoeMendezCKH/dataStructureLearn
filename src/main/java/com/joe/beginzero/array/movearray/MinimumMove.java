package com.joe.beginzero.array.movearray;

import java.util.Arrays;

/**
 * 453. 最小移动次数使数组元素相等
 *
 * @author ckh
 * @create 2020/7/30 9:50
 */
public class MinimumMove {
    public static int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            moves += num - min;
        }
        return moves;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(minMoves(nums));
    }
}
