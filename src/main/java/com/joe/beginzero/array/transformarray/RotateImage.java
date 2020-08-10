package com.joe.beginzero.array.transformarray;

import java.util.Arrays;

/**
 * 48. Rotate Image
 *
 * @author ckh
 * @create 2020/8/10 9:38
 */
public class RotateImage {

    /**
     * 1. transpose matrix
     * 2. reverse each row
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

    }
}
