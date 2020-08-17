package com.joe.beginzero.strings.reverse;

/**
 * 541. Reverse String 2
 *
 * @author ckh
 * @create 8/17/20 9:12 AM
 */
public class ReverseString2 {
    /**
     *  If there are less than k characters left, reverse all of them.
     *  If there are less than 2k but greater than or equal to k characters,
     *  then reverse the first k characters and left the other as original.
     *
     *  In the all, reverse the first k characters.
     *
     */
    public static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
