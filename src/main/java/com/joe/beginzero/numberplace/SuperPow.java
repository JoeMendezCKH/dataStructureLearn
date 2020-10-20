package com.joe.beginzero.numberplace;

/**
 * 372. Super Pow
 * 根据欧拉-费马降幂，a^b % c == a^ (b % phi(c) ) % c（c是素数） phi(c)是欧拉函数，表示小于c的和c互质的数的个数
 * <p>
 * (a * b) % p = (a % p * b % p) % p
 * (a^b)%c = ((a%c)^ b)%c
 *
 * @author ckh
 * @create 10/20/20 8:51 AM
 */
public class SuperPow {

    public int superPow(int a, int[] b) {
        double ans = 0;
        int mod = 1337;
        long num = 0, p = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            num += b[i] * p;
            p *= 10;
        }

        ans = fastPow(a, num, mod);
        return (int) (ans % mod);

    }


    /**
     * (a * b) % p = (a % p * b % p) % p
     * (a^b)%c = ((a%c)^ b)%c
     */
    double fastPow(double x, long n, int mod) {
        double ans = 1.0;
        double base = x;
        while (n > 0) {
            // 注意这里不能写为别的格式, % 运算的规则所决定
            if ((n & 1) == 1) {
                ans = ans % mod * base % mod;
            }
            base = base % mod * base % mod;
            n >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(new SuperPow().superPow(2147483647, new int[]{2, 0, 0}));

    }
}
