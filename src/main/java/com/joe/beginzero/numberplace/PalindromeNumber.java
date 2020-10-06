package com.joe.beginzero.numberplace;

/**
 * 9. Palindrome Number
 *
 * @author ckh
 * @create 10/5/20 3:27 PM
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;

    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(12321321));

    }
}
