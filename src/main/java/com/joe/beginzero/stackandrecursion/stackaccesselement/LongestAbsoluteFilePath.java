package com.joe.beginzero.stackandrecursion.stackaccesselement;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 388. Longest Absolute File Path
 *
 * @author ckh
 * @create 10/21/20 4:13 PM
 */
public class LongestAbsoluteFilePath {

    public int lengthLongestPath2(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 栈深度就是文件路径深度 level
        stack.push(0);
        int ans = 0;

        String[] str = input.split("\n");

        for (String s : str) {

            int level = s.lastIndexOf('\t') + 1;
            // 判断当前 level 是下一级目录
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            // 之前入栈的字符串 + 当前遍历到的字符串的长度  这里的 +1 是当前路径后拼接上 / 的长度, 在计算结果时会减掉最后一个 /
            int len = stack.peek() + (s.length() - level + 1);
            stack.push(len);
            if (s.contains(".")) {
                ans = Math.max(ans, len - 1);
            }
        }
        return ans;
    }

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int max = 0;
        String[] st = input.split("\n");
        // +2 是防止
        int[] path = new int[st.length + 2];
        for (String s : st) {
            // level 从1 开始计数
            int level = s.lastIndexOf('\t') + 2;

            // 当前总长度为 上一级长度 + 当前s的长度 - '\t' 个数
            int len = path[level - 1] + s.length() - (level - 1);

            if (s.contains(".")) {
                max = Math.max(max, len);
            } else {
                // 尾部拼接一个 \
                path[level] = len + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        LongestAbsoluteFilePath filePath = new LongestAbsoluteFilePath();
//        int i = filePath.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        int i = filePath.lengthLongestPath2("d");

        System.out.println(i);

    }
}
