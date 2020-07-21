package com.joe.beginzero.array.countnums;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @author ckh
 * @create 2020/7/21 9:38
 */
public class FindDisappearNum {

    /**
     * 就是第一种方法的优化
     * 3ms  100%
     * <p>
     * 但是空间复杂度为 O(n)
     */
    public static List<Integer> method3(int[] nums) {
        int n = nums.length;
        boolean[] map = new boolean[n + 1];
        for (int x : nums) {
            map[x] = true;
        }
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (!map[i]) {
                list.add(i);
            }
        }
        return list;
    }


    /**
     * 原地修改
     * 7 ms 72%
     * <p>
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-de-shu-zi-2/
     */
    public static List<Integer> method2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            /*
            因为 1 <= nums[i] <= nums.length
            所以将 nums[i] 的值, 作为 index , 将 nums[index] 的值变为负数
            这样正数的地方就是表示缺失的值, 由于偏移量, 适当的 +- 1 即可
             */
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] > 0) {
                nums[curr - 1] = -nums[curr - 1];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 24 ms 15 %
     * >_<!
     */
    public static List<Integer> method1(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = method2(new int[]{1, 3, 6, 4, 4, 6, 7});
        System.out.println(disappearedNumbers);
    }
}
