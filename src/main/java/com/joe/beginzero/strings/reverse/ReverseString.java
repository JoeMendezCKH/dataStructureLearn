package com.joe.beginzero.strings.reverse;

/**
 * 344. Reverse String
 *
 * @author ckh
 * @create 8/17/20 9:01 AM
 */
public class ReverseString {
    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);

    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
