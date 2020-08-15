package com.joe.beginzero.strings;

/**
 * 14. Longest Common Prefix
 *
 * @author ckh
 * @create 14/08/2020 10:12
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
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
