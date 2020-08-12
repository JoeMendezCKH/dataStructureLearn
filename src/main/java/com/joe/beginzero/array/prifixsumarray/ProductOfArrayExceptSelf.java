package com.joe.beginzero.array.prifixsumarray;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 *
 * @author ckh
 * @create 2020/8/12 9:32
 */
public class ProductOfArrayExceptSelf {

    @Deprecated
    public static int[] wrongMethod(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int temp = 1;
        /*
        这样只是一般情况, 没有考虑到 0 的存在, 而且题目要求不能用除法, 该法错误
         */
        for (int num : nums) {
            temp *= num;
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = temp / nums[i];
        }

        return result;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int length = nums.length;

        // left 和 right 分别表示左右两侧的乘积列表
        int[] left = new int[length];
        int[] right = new int[length];

        int[] answer = new int[length];

        // left[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 left[0] = 1
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // right[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 right[length-1] = 1
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // result[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 result[0] = 1
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        // rightProduct 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 rightProduct = 1
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 result[i]，右边的乘积为 rightProduct
            result[i] = result[i] * rightProduct;
            // rightProduct 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 rightProduct 上
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] ints = wrongMethod(array);
        System.out.println(Arrays.toString(ints));
    }
}
