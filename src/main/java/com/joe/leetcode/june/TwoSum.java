package com.joe.leetcode.june;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/6/28 15:07
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);

        System.out.println("ints = " + Arrays.toString(ints));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                results[0] = hash.get(nums[i]);
                results[1] = i;
                return results;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return results;
    }
}
