package com.joe.beginzero.array.prifixsumarray;

/**
 * 304. Range Sum Query 2D - Immutable
 *
 * @author ckh
 * @create 2020/8/12 9:04
 */
@SuppressWarnings("all")
public class RangeSumQuery2D {

    // 暴力法
//    private int[][] data;
//
//    public NumMatrix(int[][] matrix) {
//        data = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int r = row1; r <= row2; r++) {
//            for (int c = col1; c <= col2; c++) {
//                sum += data[r][c];
//            }
//        }
//        return sum;
//    }

    /**
     * dp[i][j] 表示 从(0,0) 到 (i-1,j-1) 的矩形面积
     * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/er-wei-qu-yu-he-jian-suo-ju-zhen-bu-ke-bian-by-lee/
     */
    private int[][] dp;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // dp 比 matrix 大, 第一行和第一列全为 0
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
