package com.joe.leetcode.july;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @author Joe
 * @create 2020/7/8 10:17
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"a", "a", ""};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 0ms
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 以第一个字符串为范本 对比后续元素
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // indexOf 返回值为匹配子串的第一个字母下标
            // 若不匹配 则从末尾处持续减少 res 长度 直至匹配或为空
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }

        return res;
    }
}
