package com.joe.beginzero.numberplace;

/**
 * 231. Power of Two
 *
 * @author ckh
 * @create 10/7/20 10:06 AM
 */
public class PowerTwo {

    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        String s = Integer.toBinaryString(n);

        System.out.println(s);
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    /**
     * perfect
     */
    public static boolean isPowerOfTwo2(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo1(-2147483648));
    }
}
