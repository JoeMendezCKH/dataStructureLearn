package com.joe.beginzero.strings.subsequence;

/**
 * 521. Longest Uncommon Subsequence I
 *
 * 这就是阅读理解，离谱。。。
 *
 * @author ckh
 * @create 9/3/20 9:46 AM
 */
public class LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return Math.max(a.length(),b.length());
    }

    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("aaa", "aa"));
    }

}
