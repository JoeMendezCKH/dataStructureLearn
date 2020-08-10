package com.joe.beginzero.array.transformarray;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.applet.Main;

import java.util.Arrays;
import java.util.Stack;

/**
 * 73. Set Matrix Zeroes
 *
 * @author ckh
 * @create 2020/8/10 9:52
 */
public class SetMatrixZeroes {

    static int MODIFIED = -1000000;

    /**
     * there is a problem in the title of the question
     * value of MODIFIED is not clear
     */
    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    // set right zero
                    for (int k = 0; k < columns; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = MODIFIED;
                        }
                    }
                    // set bottom zero
                    for (int k = 0; k < rows; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = MODIFIED;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == MODIFIED) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void setZeroes2(int[][] matrix) {
        boolean isCol = false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < columns; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < columns; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int i = '0';
        System.out.println(i);
    }
}
