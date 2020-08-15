package com.joe.beginzero.strings;

/**
 * 125. Valid Palindrome
 *
 * @author ckh
 * @create 14/08/2020 09:36
 */
public class ValidPalindrome {

    /**
     * select and then judge
     */
    public static boolean isPalindrome1(String s) {
        StringBuilder strings = new StringBuilder();
        int length = s.length();
        // remove the sign, only maintain letter or digit
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                strings.append(Character.toLowerCase(ch));
            }
        }

        // reverse the string and judge the state
        StringBuilder stringsReverse = new StringBuilder(strings).reverse();
        return strings.toString().equals(stringsReverse.toString());
    }

    /**
     * two pointer
     */
    public static boolean isPalindrome2(String s) {
        StringBuilder strings = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                strings.append(Character.toLowerCase(ch));
            }
        }

        // double pointer
        int newLength = strings.length();
        int left = 0, right = newLength - 1;

        while (left < right) {
            if (Character.toLowerCase(strings.charAt(left)) != Character.toLowerCase(strings.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;

    }

    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome1("A man, a plan, a canal: Panama"));
    }
}
