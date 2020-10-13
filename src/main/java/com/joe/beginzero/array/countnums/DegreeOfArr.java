package com.joe.beginzero.array.countnums;

import java.util.Collections;
import java.util.HashMap;

/**
 * 697. Degree of an Array
 *
 * @author ckh
 * @create 2020/7/20 10:25
 */
public class DegreeOfArr {

    /**
     * 用 3 个集合存储,  left[i]  表示 i 元素第一次出现的位置,
     * right[i] 表示 i 最后一次出现
     * <p>
     * right[i] - left[i] + 1 就是最短子列的长度
     * 用 hash 有点慢, 换成数组应该会快
     */
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>(16);
        HashMap<Integer, Integer> right = new HashMap<>(16);
        HashMap<Integer, Integer> count = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int res = nums.length;
        int degree = Collections.max(count.values());
        for (Integer c : count.keySet()) {
            if (count.get(c) == degree) {
                res = Math.min(res, right.get(c) - left.get(c) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 3, 4, 2, 3}));
    }
}
