package com.joe.beginzero.strings.highprecisioncalculation;

import java.util.Arrays;

/**
 * 66. plus one
 *
 * @author ckh
 * @create 9/8/20 8:18 AM
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > 9) {
                digits[i] = 0;
                if (i != 0) {
                    digits[i - 1]++;
                }
            }
        }
        if (digits[0] == 0) {
            int[] plus = new int[digits.length + 1];
            plus[0] = 1;
            return plus;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne one = new PlusOne();
        int[] ints = one.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(ints));
    }

}
