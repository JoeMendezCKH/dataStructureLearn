package com.joe.beginzero.strings;


import java.util.regex.Pattern;

/**
 * 520. Detect Capital
 *
 * @author ckh
 * @create 2020/8/13 10:21
 */
public class DetectCapital {
    static final int LOW_A = 97;
    static final int LOW_Z = 122;
    static final int BIG_Z = 90;
    static final int BIG_A = 65;

    public static boolean detectCapitalUse1(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        // if the first letter is low,
        if (chars[0] >= LOW_A && chars[0] <= LOW_Z) {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] >= BIG_A && chars[i] <= BIG_Z) {
                    return false;
                }
            }
        } else if (chars[0] >= BIG_A && chars[0] <= BIG_Z) {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] >= LOW_A && chars[i] <= LOW_Z) {
                    count++;
                }
            }
        }
        return count == 0 || count == chars.length - 1;
    }


    /**
     * not support
     */
    public static boolean detectCapitalUse2(String word) {
        String patten = "^[A-Z]+$|^[a-z]+$|^[A-Z][a-z]+$";
        return Pattern.matches(patten, word);


    }

    public static void main(String[] args) {
        // a:97  A: 65
        System.out.println(detectCapitalUse2("CKKHH"));
    }
}
