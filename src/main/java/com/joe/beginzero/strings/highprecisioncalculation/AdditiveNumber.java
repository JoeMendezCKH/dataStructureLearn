package com.joe.beginzero.strings.highprecisioncalculation;

/**
 * 306. Additive Number
 * 回溯，同类可看 842
 *
 * @author ckh
 * @create 9/10/20 8:24 AM
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * @param num               原始字符串
     * @param len               原始字符串长度
     * @param index             当前处理下标
     * @param sum               前面的两个数字之和
     * @param pre               前一个数字
     * @param currentSolveIndex 当前是处理的第几个数字
     */
    private boolean dfs(String num, int len, int index, long sum, long pre, int currentSolveIndex) {
        if (index == len) {
            return currentSolveIndex > 2;
        }
        for (int i = index; i < len; i++) {
            long cur = fetchCurValue(num, index, i);
            System.out.println("cur = " + cur);
            // 剪枝：无效数字
            if (cur < 0) {
                continue;
            }
            // 剪枝：当前数字不等于前面两数之和
            if (currentSolveIndex >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, i + 1, pre + cur, cur, currentSolveIndex + 1)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 获取 l ~ r 组成的有效数字
     */
    private long fetchCurValue(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }


    public static void main(String[] args) {

        String s = "199100199";
        System.out.println(new AdditiveNumber().isAdditiveNumber(s));

    }
}
