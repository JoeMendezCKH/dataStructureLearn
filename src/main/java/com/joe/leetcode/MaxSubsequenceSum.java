package com.joe.leetcode;

/**
 * 最大子列和问题
 *
 * @author Joe
 * @create 2020/6/29 9:23
 */
public class MaxSubsequenceSum {

    public static void main(String[] args) {

        int[] nums = {1, -2, 3};
        int l = 0;
        int r = nums.length - 1;

        int i = maxSubArrayDivideWithBorder(nums, l, r);
        System.out.println(i);
    }

    /**
     * 分治法
     *
     * @param nums  数组
     * @param left  数组最左边的索引
     * @param right 数组最右边的索引
     * @return 最大子列和
     */
    private static int maxSubArrayDivideWithBorder(int[] nums, int left, int right) {
        if (left == right) {
            // 只有一个元素，也就是递归的结束情况
            return nums[left];
        }

        // 计算中间值
        int center = (left + right) / 2;
        // 计算左侧子序列最大值
        int leftMax = maxSubArrayDivideWithBorder(nums, left, center);
        // 计算右侧子序列最大值
        int rightMax = maxSubArrayDivideWithBorder(nums, center + 1, right);

        // ========= 下面计算横跨两个子序列的最大值 ==========

        // 计算包含左侧子序列最后一个元素的子序列最大值
        // 初始化一个值
        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i = center; i >= left; i--) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
        }

        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightCrossMax = nums[center + 1];
        int rightCrossSum = 0;
        // 这里的思想就是 "增益" 的思想,
        for (int i = center + 1; i <= right; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
        }

        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;

        // 比较三者，返回最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    /**
     * O(n) 在线处理
     */
    public static int method4(int[] nums, int size) {
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < size; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * O(n)
     * 动态规划? Kadane 算法
     * 主要的思想是看 第 i 个数 是否对之前的和有增益
     */
    public static int method3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    /**
     * O(n^2) -> O(n*log n)
     */
    public static int method2(int[] nums, int size) {
        int sum, maxSum = 0;

        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = i; j < size; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    /**
     * 暴力版 O(n^3)
     *
     * @param nums 数组
     * @param size 数组长度
     * @return 最大子列和
     */
    public static int method1(int[] nums, int size) {
        int sum, maxSum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }


}
