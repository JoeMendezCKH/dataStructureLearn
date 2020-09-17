package com.joe.janzhi;

/**
 * Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * 最后一步可以走 1 步， 还有 f(n-1); 最后一步走 2 步，还有f(n-2)
 * <p>
 * f(n) = f(n-1) + f(n-2)
 *
 * @author ckh
 * @create 9/17/20 2:48 PM
 */
public class NumWays10 {

    /**
     * same of Offer 10- I , just different init num
     */
    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
