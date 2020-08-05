package com.joe.beginzero.array.specialtraverse;

/**
 * @author ckh
 * @create 2020/8/5 10:23
 */
public class SpiralMatrix2 {
    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     */
    public int[][] generateMatrix1(int n) {
        int[][] resultMatrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        // insert element
        int num = 1;
        int totalElementCounts = n * n;

        while (num <= totalElementCounts) {
            // left to right.
            for (int i = left; i <= right; i++) {
                resultMatrix[top][i] = num++;
            }
            top++;

            // top to bottom.
            for (int i = top; i <= bottom; i++) {
                resultMatrix[i][right] = num++;
            }
            right--;

            // right to left.
            for (int i = right; i >= left; i--) {
                resultMatrix[bottom][i] = num++;
            }
            bottom--;

            // bottom to top.
            for (int i = bottom; i >= top; i--) {
                resultMatrix[i][left] = num++;
            }
            left++;
        }
        return resultMatrix;
    }


}
