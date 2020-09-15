package com.joe.beginzero.strings.stringtransformation;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 *
 * @author ckh
 * @create 9/13/20 8:39 PM
 */
public class ZigZagConversion {

    /**
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("leetcode", 3));
    }
}
