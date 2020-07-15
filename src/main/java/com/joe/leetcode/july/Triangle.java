package com.joe.leetcode.july;

import java.util.*;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Joe
 * @create 2020/7/14 9:40
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(new ArrayList<>(Arrays.asList(-1)));
            add(new ArrayList<>(Arrays.asList(3, 2)));
            add(new ArrayList<>(Arrays.asList(1, -1, -3)));
//            add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        }};

        System.out.println(triangle);

        System.out.println(method1(triangle));


    }

    /**
     * dp
     * 思路详见
     * https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        // 比较最后一行的所有的和, 看那个最小
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }


    /**
     * 自己写出来的, 但是理解错题意了, 每次只能左右移动一步, 不能直接看最小值
     */
    public static int method1(List<List<Integer>> triangle) {
        int sum = 0;

        Iterator<List<Integer>> listIterator = triangle.iterator();
        List<Integer> next;
        while (listIterator.hasNext()) {
            next = listIterator.next();
            sum += next.stream().min(Integer::compareTo).get();
        }
        return sum;
    }
}
