package com.joe.janzhi;

/**
 * Offer 10- I. 斐波那契数列
 *
 * @author ckh
 * @create 9/17/20 2:42 PM
 */
public class FibonacciBuild10 {

    /**
     * dp
     * dp[n+1] = dp[n] + dp[n-1]
     */
    public int fibMethod1(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    /**
     * optimization dp
     * do not need extra array
     */
    public int finMethod2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
