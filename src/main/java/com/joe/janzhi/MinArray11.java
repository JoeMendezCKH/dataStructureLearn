package com.joe.janzhi;

/**
 * Offer 11. 旋转数组的最小数字
 *
 * @author ckh
 * @create 9/21/20 7:48 PM
 */
public class MinArray11 {

    /**
     * O(n)
     * 简单遍历数组，没有二分高效
     */
    public int findMinMethod1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }


    public int findMinMethod2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            /* 先加一再除，mid更靠近右边的right */
            int mid = left + (right - left + 1) / 2;
            if (nums[left] < nums[mid]) {
                /* 向右移动左边界 */
                left = mid;
            } else if (nums[left] > nums[mid]) {
                /* 向左移动右边界 */
                right = mid - 1;
            }
        }
        /* 最大值向右移动一位就是最小值了（需要考虑最大值在最右边的情况，右移一位后对数组长度取余） */
        return nums[(right + 1) % nums.length];
    }


    /**
     * 输入的数组有重复值
     * 第一种遍历也能过， 但就是还是 O(n)
     * 使用二分查找为 O(log N)
     */
    public int findMinMethod3(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
