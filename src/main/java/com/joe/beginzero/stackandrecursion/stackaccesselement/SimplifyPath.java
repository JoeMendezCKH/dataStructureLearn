package com.joe.beginzero.stackandrecursion.stackaccesselement;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 71. Simplify Path
 *
 * @author ckh
 * @create 10/20/20 9:46 PM
 */
public class SimplifyPath {

    /**
     * 菜鸡做法, 还错了, 没通过 "/..."
     */
    public String simplifyPathError(String path) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] pathChars = path.toCharArray();

        for (char pathChar : pathChars) {
            switch (pathChar) {
                case '/':
                    if (stack.isEmpty()) {
                        stack.push(pathChar);
                        continue;
                    } else if (stack.peek() == '/') {
                        continue;
                    } else if (stack.peek() == '.') {
                        stack.pop();
                    } else {
                        stack.push(pathChar);
                    }
                    break;
                case '.':
                    if (!stack.isEmpty() && stack.peek() == '.') {
                        stack.pop(); // .
                        if (!stack.isEmpty() && stack.peek() == '/') {
                            stack.pop();
                        }
                        while (!stack.isEmpty() && stack.peek() != '/') {
                            stack.pop();
                        }
                        if (stack.isEmpty()) {
                            stack.push('/');
                        }
                        continue;
                    }
                    stack.push(pathChar);
                    break;
                default:
                    if (!stack.isEmpty() && stack.peek() == '.') {
                        stack.pop();
                    }
                    stack.push(pathChar);
                    break;
            }
        }
        StringBuilder ans = new StringBuilder();

        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() == '.') {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pollLast());
        }
        return ans.toString();


    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");

        for (String s : str) {
            // 如果访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if ("..".equals(s)) {
                // 还需判断栈是否为空,否则会报错
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!"".equals(s) && !".".equals(s)) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (String s : stack) {
            // 这里从栈底开始拿元素
            ans.append("/").append(s);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/..."));
    }
}
