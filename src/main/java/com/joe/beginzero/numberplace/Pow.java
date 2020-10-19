package com.joe.beginzero.numberplace;

/**
 * 50. Pow(x, n)
 * <p>
 * 快速幂 算法
 * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 *
 * @author ckh
 * @create 10/19/20 9:14 AM
 */
public class Pow {

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }


    /**
     * n = 2^i0 + 2^i1 + ... + 2^ik
     *
     * x^n = x^(2^i0 + 2^i1 + ... + 2^ik)
     *     = x^(2^i0) * x^(2^i1) * ... * x^(2^ik)
     *
     * 只要n的二进制位为1, 则一定有 x^(2^i) 相乘
     * 详细分析见 https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     */
    static double quickMul2(double x, long N) {
        double ans = 1.0;
        // 基值为 x
        double base = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if ((N & 1) == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= base;
            }
            // 将贡献不断地平方, base 的 2, 4, 8, 16
            base *= base;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(myPow(4, 4));

    }
}
