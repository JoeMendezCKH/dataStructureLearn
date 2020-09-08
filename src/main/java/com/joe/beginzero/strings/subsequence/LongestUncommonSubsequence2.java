package com.joe.beginzero.strings.subsequence;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 522. Longest Uncommon Subsequence II
 * <p>
 * 这就是阅读理解，离谱。。。
 *
 * @author ckh
 * @create 9/3/20 9:46 AM
 */
@SuppressWarnings("unused")
public class LongestUncommonSubsequence2 {

    /**
     * x is subsequence of y
     */
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        return j == x.length();
    }

    public int findLusLength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] strs = {"aba", "dc", "cdc", "eae"};
        LongestUncommonSubsequence2 subsequence2 = new LongestUncommonSubsequence2();
        System.out.println(subsequence2.findLusLength(strs));

//        System.out.println(subsequence2.isSubsequence("a", "ab"));


    }

}
