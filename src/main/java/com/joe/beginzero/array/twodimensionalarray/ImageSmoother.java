package com.joe.beginzero.array.twodimensionalarray;

import java.util.Arrays;

/**
 * 661 image smoother
 *
 * @author ckh
 * @create 2020/8/3 9:02
 */
public class ImageSmoother {
    /**
     *
     */
    public static int[][] imageSmoother(int[][] M) {
        int row = M.length, column = M[0].length;
        int[][] ans = new int[row][column];

        // traverse the array
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < column; ++c) {

                // calculation the average value
                int count = 0;
                for (int neighbor = r - 1; neighbor <= r + 1; ++neighbor) {
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= neighbor && neighbor < row && 0 <= nc && nc < column) {
                            // ans[r][c] is the sum of the neighbor
                            ans[r][c] += M[neighbor][nc];
                            count++;
                        }
                    }
                }
                ans[r][c] /= count;
            }
        }
        return ans;

    }

    /**
     * optimization over method
     * use 'if' instead of 'for'
     */
    public static int[][] method2(int[][] M) {

        int row = M.length;
        int col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0, sum = 0;
                // if has up neighbor
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += M[i - 1][j - 1];
                        count++;
                    }
                    if (j + 1 < col) {
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                }
                // if has bottom neighbor
                if (i + 1 < row) {
                    sum += M[i + 1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += M[i + 1][j - 1];
                        count++;
                    }
                    if (j + 1 < col) {
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }
                // right neighbor
                if (j + 1 < col) {
                    sum += M[i][j + 1];
                    count++;
                }
                // left neighbor
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                sum += M[i][j];
                count++;
                res[i][j] = sum / count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = method2(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });

        System.out.println(Arrays.deepToString(res));
    }
}
