package com.joe.beginzero.array.movearray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author ckh
 * @create 2020/7/30 10:36
 */
public class MoveZero {

    /**
     * 空间局部优化
     * 1. 将所有 0 移动到数组末尾。
     * 2. 所有非零元素必须保持其原始顺序
     */
    public static void moveZeroes01(int[] nums) {
        int len = nums.length;

        // Count the zeroes
        int numZeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                numZeroes++;
            }
        }

        // Make all the non-zero elements retain their original order.
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                list.add(num);
            }
        }

        while (numZeroes-- != 0) {
            list.add(0);
        }

        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
    }

    /**
     * 空间最优，操作局部优化（双指针）
     * 将上面的进行优化
     */
    public static void moveZeroes02(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void method3(int[] nums) {
        // 定义慢指针的初始值
        int start = -1;
        // 找到第一个值为0的索引
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                start = i;
                break;
            }
        }

        if (start != -1) {
            // 从第一个值为0的索引处开始遍历，接着就是典型的双指针
            for (int end = start; end < nums.length; ++end) {
                if (nums[end] != 0) {
                    nums[start] = nums[end];
                    nums[end] = 0;
                    ++start;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        method3(nums);
        System.out.println(Arrays.toString(nums));

    }
}
