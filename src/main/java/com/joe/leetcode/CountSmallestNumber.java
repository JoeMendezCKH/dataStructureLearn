package com.joe.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author Joe
 * @create 2020/7/11 16:10
 */
public class CountSmallestNumber {

    /**
     * 暴力法
     * 超时了
     */
    public static List<Integer> countSmaller1(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        if (nums.length == 1) {
            list.add(0);
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }

    /**
     * 优化暴力法
     * 树状数组, 前缀法, 超纲了 .... 难顶
     */


    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller1(nums));
    }
}
