package com.joe.beginzero.array.countnums;

import sun.security.util.ArrayUtil;


/**
 * 41. 缺失的第一个正数
 *
 * @author ckh
 * @create 2020/7/28 10:32
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * 哈希表
     *
     * N 为数组长度
     * 1. 将数组中所有小于等于 0 的数修改为 N+1
     * 2. 遍历数组, 将每个数对应的位置的数字标记为 负
     * 3. 如果全是 负数, 则 返回 N + 1, 否则返回第一个整数的 位置+1
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
