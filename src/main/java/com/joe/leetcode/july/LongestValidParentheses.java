package com.joe.leetcode.july;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author Joe
 * @create 2020/7/4 16:10
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "(()(()((()()()(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

    /**
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        int length;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char parentheses = chars[i];
            if (parentheses == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    length = i - stack.peek();
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength;
    }
}
