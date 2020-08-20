package com.joe.beginzero.strings.countwords;

import java.lang.annotation.ElementType;

/**
 * 389. Find the Difference
 *
 * @author ckh
 * @create 2020/8/20 上午8:42
 */
public class FindDiffWords {

    public static char findTheDifference(String s, String t) {
        int[] letterCounts = new int[26];
        // count the s string letter number
        for (char c : s.toCharArray()) {
            letterCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letterCounts[c - 'a']--;
        }
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 'A';

    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));

    }
}
