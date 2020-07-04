package com.joe.leetcode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/3 21:56
 */
public  class RemoveDuplicatesNumber {

    public static void main(String[] args) {
        int[] nums = {1, 1};
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {0, 1, 2, 2, 2, 3, 4, 6};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 自己写的, 比官方多写了一个 判断,
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                if (pre != i - 1) {
                    nums[pre + 1] = nums[i];
                }
                pre++;
            }
        }
        return pre + 1;
    }

    /**
     * 官方解法
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
