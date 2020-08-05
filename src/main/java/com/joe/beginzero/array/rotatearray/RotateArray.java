package com.joe.beginzero.array.rotatearray;

import java.util.Arrays;

/**
 * 189 Rotate Array
 *
 * @author ckh
 * @create 2020/8/4 14:40
 */
public class RotateArray {
    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, len);
    }


    /**
     * len = 7, k = 3;
     *
     * primary array                : 1 2 3 4 5 6 7
     * reverse all element          : 7 6 5 4 3 2 1
     * reverse [0,k] element        : 5 6 7 4 3 2 1
     * reverse [k+1, len] element   : 5 6 7 1 2 3 4 --> 结果
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate3(int[] nums, int k){
        int temp, previous;
        // each time rotate 1 position
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotate1(nums, 3);
//        rotate2(nums,3);
        rotate3(nums,3);

        System.out.println(Arrays.toString(nums));
    }
}
