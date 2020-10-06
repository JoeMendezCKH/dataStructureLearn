package com.joe.beginzero.numberplace;

/**
 * 479. Largest Palindrome Product
 *
 * @author ckh
 * @create 10/5/20 3:39 PM
 */
public class LargestPalindromeProduct {

    /**
     * https://leetcode-cn.com/problems/largest-palindrome-product/solution/9-line-in-java-by-wdw87/
     */
    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        // 计算给定位数的最大值
        long max = (long) Math.pow(10, n) - 1;

        //从 max - 1 开始循环, 减少一次循环，因为 max * max 得到的数一定不是回文数
        for (long i = max - 1; i > max / 10; i--) {

            // 1. 构造回文数
            long tmp = i;
            long rev = i;
            while (tmp > 0) {
                rev = rev * 10 + tmp % 10;
                tmp /= 10;
            }

            // 2. 检验该回文数能否由给定的数相乘得到
            for (long x = max; x * x >= rev; x--) {
                if (rev % x == 0) {
                    return (int) (rev % 1337);
                }
                if (x % 10 == 9) {
                    x -= 2;
                } else if (x % 10 == 7) {
                    x -= 4;
                } else if (x % 10 == 3) {
                    x -= 4;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(largestPalindrome(2));

    }
}
