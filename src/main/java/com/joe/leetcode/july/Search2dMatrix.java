package com.joe.leetcode.july;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17 24],
 * [18, 21, 23, 26, 30],
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/2 9:49
 */
public class Search2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 20));
    }

    /**
     * 从 右上角出发
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0]) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
