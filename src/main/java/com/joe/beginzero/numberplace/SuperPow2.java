package com.joe.beginzero.numberplace;

/**
 * @author ckh
 * @create 10/20/20 11:23 AM
 */
public class SuperPow2 {
    public int superPow(int a, int[] b) {

        int mod = 1337;

        // 求 1337 的 φ(n) = 1140
        int phi = phi(mod);
        /*
        本题 phi 为 1140
        a ^ 1140 ≡ 1 (mod 1337)
        而这里指数是 b 数组，那么我们只需要求 a ^ (b[n] % 1140) % 1337 即可

        因为 b 是数组，我们怎么对 b 进行处理？
        记住公式：(a * b) % k = (a % k) * (b % k)
        那么 40000 % 1337 = (4 * 10000) % 1337= (4 % 1337) * (10000 % 1337)
        由此我们可以对 b 数组进行拆分

        举个栗子在本题中f(n)表示数组[4,5,7,5,8]表示的值,即45758%1140,但是题目中没有说明这个数组的范围到底有多大,
        如果超出int范围值就会报错.所以我们用for循环来模拟常规的求余运算
        常规求余运算:
        被除数    4,除数1140,商0余4,
        被除数   45,除数1140,商0余45,
        被除数  457,除数1140,商0余457,
        被除数 4575,除数1140,商4余15,
        被除数  158,除数1140,商0余158.(高位的余数*10借给低位)
        */
        int exp = 0;
        for (int i = 0; i < b.length; i++) {
            exp = (exp * 10 + b[i]) % phi;
        }
        //注意对 a 取模
        return quickPow(a % mod, exp, mod);
    }

    private int quickPow(int x, int n, int mod) {
        if (n == 0) {
            return 1;
        }
        int res = quickPow(x, n / 2, mod);
        res *= res;
        res %= mod;
        if ((n & 1) != 0) {
            res *= x;
            res %= mod;
        }
        return res;
    }

    /**
     * 欧拉函数 求 φ(n)
     * 比 n 小的质数的个数
     */
    private int phi(int n) {
        /*
           φ(n) = n*(1-1/p1)*(1-1/p2)*(1-1/p3)*(1-1/p4)
           φ(12) = 4(2^2) * (1 - 1/2) * 3 * (1 - 1/3) = 12 * (1 / 2) * (2 / 3)
        */
        int res = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                /*
                    res = 12 * （1 - 1/2），但因为计算机会先计算 1/2，那么 1/2 就变成 0，导致结果错误
                    因此，我们需要转换成 乘法， res * (1 - 1/i) 通过先计算 1 - 1/i 可以转换为 (i - 1) / i
                    因此结果变为 res * (i - 1) / i

                    res = res * (i - 1) / i; 计算 φ(n)
                    while 循环除去因子，比如 此次因子是 2，那么计算完关于 2 的 φ 后，就应该将 2 除尽
                */
                res = res * (i - 1) / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        /*
            当 n 大于 1 ，那么必定剩下最后一个因子
            为什么这里会需要判断 n > 1
            比如 n = 12，
            i = 2 ，ans 一直 / 2，那么 n 就变成 3，
            i = 3 ，然后 i * i > n 即 9 > 3 ，因此退出循环 ， 3 还没有处理
        */
        if (n > 1) {
            res = res * (n - 1) / n;
        }
        return res;
    }
}
