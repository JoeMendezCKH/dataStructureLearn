package com.joe.beginzero.array.transformarray;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 *
 * @author ckh
 * @create 2020/8/10 9:15
 */
public class ReshapeMatrix {

    /**
     * my self solve , ^_^
     * 1 ms, 100%
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if (r * c > rows * columns) {
            return nums;
        }
        int[][] result = new int[r][c];

        int row = 0, column = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (column >= columns) {
                    row++;
                    column = 0;
                }
                result[i][j] = nums[row][column++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(matrixReshape(matrix, 2, 4)));

    }
}
