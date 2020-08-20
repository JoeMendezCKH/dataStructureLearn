package com.joe.beginzero.strings.countwords;

/**
 * 383. Ransom Note
 * 不说人话，本来很简单的问题，讲一大堆没用的
 *
 * @author ckh
 * @create 2020/8/20 AM 9:06
 */
public class RansomNote {

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] letterCounts = new int[26];
        // count the s string letter number
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            letterCounts[c - 'a']--;
        }
        for (char c : ransomNote.toCharArray()) {
            if (letterCounts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean canConstruct2(String ransomNote, String magazine) {

        int[] letterCounts = new int[26];
        // count the s string letter number
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {

            if (--letterCounts[c - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        String s = "aa";
        String t = "aab";
        System.out.println(canConstruct1(s, t));

    }

}
