package com.joe.beginzero.array.traversalarray;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * 628
 *
 * @author ckh
 * @create 2020/7/18 11:16
 */
public class MaximumProduct {

    /**
     * 12ms 70.04%
     * <p>
     * 时间复杂度：O(N logN)，其中 N 是数组的长度
     * 空间复杂度：O(logN)，为排序使用的空间
     */
    public static int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        if (nums.length <= 3) {
            for (int num : nums) {
                res *= num;
            }
            return res;
        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 线性扫描
     * <p>
     * 在上面的方法中, 我们实际上只要求出数组中最大的三个数以及最小的两个数，
     * 因此我们可以不用排序，用线性扫描直接得出这五个数。
     *
     * 这个最快... 1ms
     */
    public static int method2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }


    public static void main(String[] args) {
        int i = maximumProduct(new int[]{903, 606, 48, -474, 313, -672, 872, -833, 899, -629, 558, -368, 231, 621, 716, -41, -418, 204, -1, 883, 431, 810, 452, -801, 19, 978, 542, 930, 85, 544, -784, -346, 923, 224, -533, -473, 499, -439, -925, 171, -53, 247, 373, 898, 700, 406, -328, -468, 95, -110, -102, -719, -983, 776, 412, -317, 606, 33, -584, -261, 761, -351, -300, 825, 224, 382, -410, 335, 187, 880, -762, 503, 289, -690, 117, -742, 713, 280, -781, 447, 227, -579, -845, -526, -403, -714, -154, 960, -677, 805, 230, 591, 442, -458, -905, 832, -285, 511, 536, -86});
        System.out.println("i = " + i);

    }
}
