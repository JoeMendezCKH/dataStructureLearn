package com.joe.beginzero.array.movearray;

/**
 * 665. 非递减数列
 *
 * @author ckh
 * @create 2020/7/30 10:05
 */
public class NonDecreaseArray {
    public static boolean checkPossibility(int[] nums) {

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            // 这句代码不要放在条件判断的内部，一定要确保只要不满足非递减就必须执行这句代码
            count++;

            if (count > 1) {
                return false;
            }

            // num[i] < num[i-1] && num[i] < num[i-2]
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                // 增大 nums[i]
                nums[i] = nums[i - 1];
            } else {
                // num[i] < num[i-1] && num[i] > num[i-2] 或者只是 num[i] < num[i-1]
                // 减小 nums[i-1]
                nums[i - 1] = nums[i];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,2,3,4};
        System.out.println(checkPossibility(nums));
    }
}
