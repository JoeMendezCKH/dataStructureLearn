package com.joe.beginzero.numberplace;

/**
 * 326. Power of Three
 *
 * @author ckh
 * @create 10/7/20 10:35 AM
 */
public class PowerThree {

    public static boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    static double EPS = 1e-10;

    /**
     * 双精度取整时要对精度做处理
     */
    public static boolean isPowerThree2(int n) {
        return (Math.log(n) / Math.log(3) + EPS) % 1 <= 2 * EPS;
    }

    /**
     * 转换为基准为 3 的string，然后是否为  1 000000 这种形式
     */
    public static boolean isPowerThree3(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public static void main(String[] args) {
        int pow = (int) Math.pow(3, 5);
        System.out.println(pow);
        System.out.println(Integer.toBinaryString(pow));

        System.out.println(isPowerThree2(243));
    }
}
