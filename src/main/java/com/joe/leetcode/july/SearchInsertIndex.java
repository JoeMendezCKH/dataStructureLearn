package com.joe.leetcode.july;

/**
 * @author ckh
 * @create 2020/7/17 9:18
 */
public class SearchInsertIndex {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert1(nums, 7));

    }

    /**
     * 二分查找
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 暴力法
     * 虽然很简单了, 但是还可以优化一下, 用二分
     */
    public static int searchInsert1(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return 0;
    }
}
