package com.joe.beginzero.numberplace;

/**
 * 263. Ugly Number
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 *
 * @author ckh
 * @create 10/8/20 4:00 PM
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(14));
    }
}
