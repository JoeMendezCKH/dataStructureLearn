package com.joe.beginzero.array.specialtraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 498. Diagonal Traverse
 *
 * @author ckh
 * @create 2020/8/5 10:28
 */
public class DiagonalTraverse {

    public static int[] findDiagonalOrder1(int[][] matrix) {
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;

        // store the result
        int[] result = new int[rows * columns];
        int k = 0;
        // store each diagonal array
        ArrayList<Integer> intermediate = new ArrayList<>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < rows + columns - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // ========== this is the key ===========
            // the starting of the diagonals must be the first row and last column
            int row = d < columns ? 0 : d - columns + 1;
            int column = d < columns ? d : columns - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (row < rows && column > -1) {
                intermediate.add(matrix[row][column]);
                ++row;
                --column;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (Integer integer : intermediate) {
                result[k++] = integer;
            }
        }
        return result;

    }

    /**
     * not know
     */
    public static int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int size = rows * columns;
        int[] res = new int[size];

        boolean flag = true;
        int x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            res[i] = matrix[x][y];
            if (flag) {
                x--;
                y++;
                if (y > columns - 1) {
                    y = columns - 1;
                    x += 2;
                    flag = false;
                }
                if (x < 0) {
                    x = 0;
                    flag = false;
                }
            } else {
                y--;
                x++;
                if (x > rows - 1) {
                    x = rows - 1;
                    y += 2;
                    flag = true;
                }
                if (y < 0) {
                    y = 0;
                    flag = true;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] diagonalOrder2 = findDiagonalOrder1(matrix);

        System.out.println(Arrays.toString(diagonalOrder2));

    }
}
