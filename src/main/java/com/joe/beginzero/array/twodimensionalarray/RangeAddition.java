package com.joe.beginzero.array.twodimensionalarray;

/**
 * 598 Range Addition
 *
 * @author ckh
 * @create 2020/8/3 9:28
 */
public class RangeAddition {

    public static int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
