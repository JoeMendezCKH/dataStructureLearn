package com.joe.beginzero.array.countnums;

import java.util.ArrayList;
import java.util.List;

/**
 * 442 数组中重复的数据
 *
 * @author ckh
 * @create 2020/7/21 10:15
 */
public class FindAllDuplicatesNum {

    /**
     * 6ms 94%
     */
    public static List<Integer> method2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = (nums[i] < 0) ? -nums[i] : nums[i];
            if (nums[curr - 1] > 0) {
                nums[curr - 1] *= -1;
            } else {
                list.add(curr);
            }
        }
        return list;
    }


    /**
     * 4 ms 100%
     * 但是 空间复杂度是 O(n)
     */
    public static List<Integer> method1(int[] nums) {
        int[] count = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            count[num - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = method2(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(list);
    }
}
