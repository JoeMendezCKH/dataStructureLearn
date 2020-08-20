package com.joe.beginzero.strings.countwords;

/**
 * 242. Valid Anagram
 *
 * @author ckh
 * @create 8/20/20 3:13 PM
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }
        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
