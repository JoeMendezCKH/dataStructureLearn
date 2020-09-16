package com.joe.janzhi;

/**
 * Offer 03. 数组中重复的数字
 *
 * @author ckh
 * @create 9/15/20 9:30 PM
 */
public class FindDoubleNum03 {

    public static int findRepeatNumber(int[] nums) {
        int[] result = new int[nums.length];
        int t = 0;
        for (int num : nums) {
            if (num == 0) {
                t++;
            } else {
                if (result[num] != 0) {
                    return num;
                }
                result[num]++;
            }
        }
        if (t > 1) {
            return 0;
        }
        return -1;
    }


    public static int findRepeatNumber2(int[] nums) {
        int[] result = new int[nums.length];
        for (int num : nums) {
            result[num]++;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
