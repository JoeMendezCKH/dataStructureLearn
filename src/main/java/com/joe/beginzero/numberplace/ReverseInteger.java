package com.joe.beginzero.numberplace;

/**
 * 7. Reverse Integer
 * <p>
 * 范围为 [−2^31,  2^31 − 1]
 * 如果反转后整数溢出那么就返回 0
 *
 * @author ckh
 * @create 10/5/20 3:18 PM
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));

    }
}
