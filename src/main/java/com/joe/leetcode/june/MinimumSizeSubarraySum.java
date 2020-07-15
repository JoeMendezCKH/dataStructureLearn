package com.joe.leetcode.june;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/6/28 15:19
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen2(7, nums));
    }

    /**
     * 双指针
     * 滑动窗口的思想,
     * 先向队列中添加数字, 移动 right, 窗口不断变宽
     * 当 窗口中所有的数字和 sum >= s 时, 记录窗口当前的值, 将窗口变窄, 移动 left
     * 最后返回 min 值, 就是连续的最小队列
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * O(n^2)
     */
    public static int minSubArrayLen1(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s) {
                // 如果某个值比 s 大, 那么该子列就是满足条件的最最小连续个数
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
