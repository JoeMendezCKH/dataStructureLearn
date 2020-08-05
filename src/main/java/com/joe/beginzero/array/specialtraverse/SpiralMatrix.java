package com.joe.beginzero.array.specialtraverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * @author ckh
 * @create 2020/8/5 9:48
 */
public class SpiralMatrix {

    /**
     * simulate spiral
     * start from matrix[0][0], and  right -> down -> left -> up cycle
     */
    public static List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        List<Integer> order = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        // Total number of elements
        int total = rows * columns;

        int row = 0, column = 0;

        // right -> down -> left -> up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            // add the visited element, and mark the visited array
            order.add(matrix[row][column]);
            visited[row][column] = true;

            // imitate the spiral , change the direction
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            // point the next position
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /**
     * Simulation method, set boundary
     * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        // init the edge
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        // Total number of elements
        int numEle = matrix.length * matrix[0].length;

        while (numEle >= 1) {
            // top left -> top right
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;

            // right top -> right bottom
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;

            // bottom right -> bottom left
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;

            // left bottom -> left top
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list = spiralOrder2(matrix);

        System.out.println(list);

        System.out.println(spiralOrder1(matrix));
    }
}
