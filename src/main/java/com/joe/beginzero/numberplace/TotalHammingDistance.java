package com.joe.beginzero.numberplace;

/**
 * 477. Total Hamming Distance
 *
 * @author ckh
 * @create 10/8/20 8:58 PM
 */
public class TotalHammingDistance {

    public int totalHammingDistance1(int[] nums) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;

            // 获取每个数字的第 i 位，
            for (int n : nums) {
                n >>= i;
                if ((n & 1) == 1) {
                    one++;
                }
            }
            // 数组中的所有数的 第 i 位的汉明距离为 (0的个数 × 1的个数)
            ans += one * (nums.length - one);

        }
        return ans;

    }


    public int totalHammingDistance2(int[] nums) {
        int ham = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 这里用 >> 也可以，因为只扫描32位
                count += (num >>> i) & 1;
            }
            ham += count * (nums.length - count);
        }
        return ham;
    }


    public static void main(String[] args) {

        TotalHammingDistance distance = new TotalHammingDistance();
        // 1176
        System.out.println(distance.totalHammingDistance1(new int[]{346450570, 966562973, 457581303, 222998192, 364627507, 169160189, 954431542, 221061882, 240341464, 2245441, 231904888, 735611889, 365662644}));

    }
}
