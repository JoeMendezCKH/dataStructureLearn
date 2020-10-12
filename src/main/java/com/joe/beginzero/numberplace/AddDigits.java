package com.joe.beginzero.numberplace;

/**
 * 258. Add Digits
 * <p>
 * 这个概念在数学上叫 树根， 取值范围 [1-9]
 *
 * @author ckh
 * @create 10/12/20 10:26 AM
 */
public class AddDigits {
    public static int addDigitsMethod1(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        if (count > 9) {
            return addDigitsMethod1(count);
        }
        return count;
    }

    /**
     * 数学推导
     * 一个数 x 的数根为 mod(x-1, 9) + 1
     */
    public static int addDigitsMethod2(int num) {
        return ((num - 1) % 9) + 1;
    }

    public static void main(String[] args) {
        System.out.println(addDigitsMethod1(28));
    }
}
