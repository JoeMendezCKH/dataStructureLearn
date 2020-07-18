package com.joe.beginzero.array.traversalarray;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 414
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 * 示例 2:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * <p>
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 *
 * @author ckh
 * @create 2020/7/18 10:41
 */
public class ThirdMaxNum {

    /**
     * 2ms 65.59%
     * -_-!
     *
     * @param nums 数组
     * @return 数组中第三大的数字, 不能重复
     */
    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] != nums[i]) {
                if (--count == 0) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];

    }

    /**
     * 暴力逻辑. 感觉好笨...
     * Integer.MIN_VALUE 不行, 因为有 [1,2,-2147483648]
     */
    public static int method3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int one = nums[0];
        long two = Long.MIN_VALUE, three = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) {
                continue;
            }
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }
        if (three == Long.MIN_VALUE) {
            return one;
        }
        return (int) three;
    }

    /**
     * 维护一个定长为 3 的集合
     * 好理解, 但是用了 TreeSet 慢
     * 5ms
     */
    public static int method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("error");
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }

        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        System.out.println(method2(new int[]{1, 2, 2, 2, 3, 4, 5, 7, 5, 4, 4, 5, 5}));
    }
}
