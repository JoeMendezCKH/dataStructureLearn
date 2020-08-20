package com.joe.beginzero.strings.countwords;

import java.util.HashMap;

/**
 * 387. First Unique Character in a String
 *
 * @author ckh
 * @create 2020/8/19 14:24
 */
public class FirstUniqueCharacter {

    /**
     * 暴力办法, 通过额外的hash表,存储字符的个数
     * 33 ms
     */
    public static int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 优化上面的hash表, 用数组代替
     */
    public static int firstUniqChar12(String s) {
        if (null == s || s.length() <= 0) {
            return -1;
        }

        int[] lettersCount = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            lettersCount[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (lettersCount[array[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String words = "loveleetcode";
        System.out.println(firstUniqChar1(words));

    }
}
