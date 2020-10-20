package com.joe.leetcode.otc;

/**
 * 844. Backspace String Compare
 *
 * @author ckh
 * @create 10/19/20 9:15 PM
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        int left = S.length() - 1;
        int right = T.length() - 1;
        int backspaceNumS = 0, backspaceNumT = 0;

        while (true) {
            // 处理退格
            if (left >= 0 && S.charAt(left) == '#') {
                backspaceNumS++;
                left--;
                continue;
            }
            if (right >= 0 && T.charAt(right) == '#') {
                backspaceNumT++;
                right--;
                continue;
            }
            if (backspaceNumS > 0) {
                left--;
                backspaceNumS--;
                continue;
            }
            if (backspaceNumT > 0) {
                right--;
                backspaceNumT--;
                continue;
            }

            if (left < 0 && right < 0) {
                break;
            }
            if (right < 0 || left < 0) {
                return false;
            }
            if (S.charAt(left) != T.charAt(right)) {
                return false;
            }
            // if (S.charAt(i) == T.charAt(j)) {
            left--;
            right--;
            // }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ab##", T = "c#d#";
        System.out.println(backspaceCompare(S, T));

    }
}
