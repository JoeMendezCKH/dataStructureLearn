package com.joe.beginzero.numberplace;

/**
 * 342. Power of Four
 *
 * @author ckh
 * @create 10/7/20 10:18 AM
 */
public class PowerFour {

    public static boolean isPowerOfFour1(int num) {
        boolean isPowerOfTwo = num > 0 && (num & (num - 1)) == 0;
        int length = Integer.toBinaryString(num).length();
        return isPowerOfTwo && length % 2 != 0;

    }

    public static boolean isPowerOfFour2(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour2(8));

    }
}
