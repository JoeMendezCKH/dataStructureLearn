package com.joe.beginzero.array.prifixsumarray;

/**
 * 303. Range Sum Query - Immutable
 *
 * @author ckh
 * @create 2020/8/12 8:34
 */
@SuppressWarnings("all")
public class RangeSumQuery {


//     暴力法

//    private int[] data;
//
//    public NumArray(int[] nums) {
//        data = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        if (i >= 0 && j < data.length) {
//            for (int k = i; k <= j; k++) {
//                sum += data[k];
//            }
//        }
//        return sum;
//    }


    /**
     * 将 sum[k] 定义为 nums[0⋯k−1] 的累积和
     * <p>
     * 前缀和
     */
    private int[] sum;

    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


}
