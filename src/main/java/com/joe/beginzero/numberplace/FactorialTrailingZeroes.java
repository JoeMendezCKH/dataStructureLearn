package com.joe.beginzero.numberplace;

/**
 * 172. Factorial Trailing Zeroes
 *
 * @author ckh
 * @create 10/9/20 5:05 PM
 */
public class FactorialTrailingZeroes {
    /**
     * 易得： 如果先算阶乘再计算0的个数，算阶乘时会溢出
     * 所以肯定不是先算阶乘
     * 易得，0的个数就是5的因子个数，因为每个5都可以和一个2相乘得到一个10, 也就多一个 0
     *
     * count = n/5 + n/25 + n/125 + ...
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(10));
//        System.out.println(Integer.toBinaryString(20));
//        System.out.println(Integer.toBinaryString(30));
        System.out.println(trailingZeroes(120));

    }
}
