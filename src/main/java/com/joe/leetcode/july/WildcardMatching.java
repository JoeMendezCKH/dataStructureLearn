package com.joe.leetcode.july;

/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * <p>
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * <p>
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * <p>
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * <p>
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * @author Joe
 * @create 2020/7/7 14:20
 */
public class WildcardMatching {

    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*b";
        System.out.println(isMatch1(s, p));
    }


    /**
     * 1、状态定义：
     * dp[i][j] 表示 p 的前 i 个字符和 s 的前 j 个字符是否匹配。
     * <p>
     * 2、状态转移：
     * 如果 p[i - 1] == s[j - 1] 或 p[i - 1] == '?'，表示当前的字符串是匹配的，dp[i][j] 可以从 dp[i - 1][j - 1] 转移而来。
     * <p>
     * 如果 p[i - 1] == '*'，这个位置可以匹配 0 到 若干个字符。
     * 那么 dp[i][j] 可以从 dp[i - 1][j] 转移而来（表示当前星号没有匹配字符），
     * 也可以从 dp[i][j - 1] 转移而来（表示当前星号匹配了当前的位置的字符）。
     * 因为只要任意一种匹配即可，所以这里是逻辑或的关系。
     * <p>
     * 状态转移方程如下：
     * <p>
     * <p>
     * 3、初始条件
     * dp[0][0] = true 表示空串是匹配的。
     * 处理一下匹配串 p 以若干个星号开头的情况。
     *
     * @param s string
     * @param p pattern
     * @return matching string
     */
    public static boolean isMatch1(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }


}
