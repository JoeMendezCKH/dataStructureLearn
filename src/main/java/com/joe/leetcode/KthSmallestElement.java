package com.joe.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 * 示例：
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Joe
 * @create 2020/7/2 8:58
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(kthSmallest(matrix, 1));
    }


    /**
     * 二分法
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (check(matrix, mid, k, n)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * @param matrix 二维数组
     * @param mid    比较的基准值
     * @param k      指定的个数  kth
     * @param n      matrix.length
     * @return
     */
    public static boolean check(int[][] matrix, int mid, int k, int n) {
        // row
        int i = n - 1;
        // column
        int j = 0;
        // 数字的排名
        int num = 0;
        // 确保不会索引越界
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }


    /**
     * 归并排序
     */
    public int method3(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    /**
     * 暴力法, 将二维数组展为 一维数组, 然后排序返回
     */
    public int method1(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }


    /**
     * 理解错误, 是行, 列 有大小, 不是所有有序
     */
    public static int method0(int[][] matrix, int k) {

        int n = matrix.length;

        // 如果是全部有序的话, 直接就是这个公式
        int i = k / n;
        int j = k % n - 1;

        return matrix[i][j];

    }
}
