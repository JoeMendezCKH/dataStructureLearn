package com.joe.beginzero.array.traversalarray;


/**
 * 485
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * <p>
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * <p>
 * 强行联系了一波双指针, 实现滑动窗口
 *
 * @author ckh
 * @create 2020/7/18 10:02
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(method2(nums));

    }

    /**
     * 2 ms;  94.36%
     * 自己想到的一次遍历法 和题解相同...
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0, temp = 0;
        for (int num : nums) {
            if (num > 0) {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        return Math.max(result, temp);
    }


    /**
     * 自己写的双指针, 还是 2ms
     * 看了别人的双指针, 感觉自己写的就不是双指针...
     * 根本就没用到. 失败
     */
    public static int method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                right++;
            } else {
                count = Math.max(count, (right - left));
                left = right;
            }
        }
        return Math.max(count, (right - left));
    }

    /**
     * 滑动窗口思路：
     * 当输出或比较的结果在原数据结构中是连续排列的时候，可以使用滑动窗口算法求解。
     * 将两个指针比作一个窗口，通过移动指针的位置改变窗口的大小，观察窗口中的元素是否符合题意。
     * <p>
     * 初始窗口中只有数组开头一个元素。
     * 当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
     * 当窗口中存在 0 时，计算连续序列长度，左指针指向右指针
     * <p>
     * 作者：lxiaocode
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones/solution/java-485-zui-da-lian-xu-1de-ge-shu-hua-dong-chuang/
     * <p>
     * 1 ms
     */
    public static int method3(int[] nums) {
        int length = nums.length;
        int left = 0, right = 0;
        int maxSize = 0;

        while (right < length) {
            //当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
            if (nums[right++] == 0) {
                //当窗口中存在 0 时，计算连续序列长度，左指针指向右指针。
                maxSize = Math.max(maxSize, right - left - 1);
                left = right;
            }
        }
        // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
        return Math.max(maxSize, right - left);
    }
}
