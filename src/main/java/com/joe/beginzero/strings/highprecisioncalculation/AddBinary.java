package com.joe.beginzero.strings.highprecisioncalculation;

/**
 * 67. Add binary
 *
 * @author ckh
 * @create 9/8/20 8:31 AM
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();


    }

    public static void main(String[] args) {

    }
}
