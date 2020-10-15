package com.joe.leetcode.otc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. Find Common Characters
 *
 * @author ckh
 * @create 10/14/20 8:13 PM
 */
public class FindCommonCharacters {

    public static List<String> commonChars(String[] A) {
        int[] lettersBefore = new int[26];
        int[] lettersAfter = new int[26];
        List<String> ans = new ArrayList<>();

        for (char c : A[0].toCharArray()) {
            lettersBefore[c - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {

//            Arrays.fill(lettersAfter, 0);
            lettersAfter = new int[26];
            for (char c : A[i].toCharArray()) {
                lettersAfter[c - 'a']++;
            }

            // 更新 lettersBefore，保证 lettersBefore 里统计26个字符在所有字符串里出现的最小次数
            for (int k = 0; k < 26; k++) {
                lettersBefore[k] = Math.min(lettersBefore[k], lettersAfter[k]);
            }
        }

        for (int i = 0; i < lettersBefore.length; i++) {
            while (lettersBefore[i] != 0) {
                ans.add((char) ('a' + i) + "");
                lettersBefore[i]--;
            }
        }

//        System.out.println(ans);
        return ans;


    }

    public static void main(String[] args) {

        System.out.println(commonChars(new String[]{"cool", "lcok", "cook"}));
    }

}
