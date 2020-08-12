package com.joe.beginzero.array.prifixsumarray;

/**
 * @author ckh
 * @create 2020/8/12 9:23
 */
public class RangeSumQueryTest {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        RangeSumQuery2D query2D = new RangeSumQuery2D(matrix);

        int sumRegion = query2D.sumRegion(0, 0, 1, 1);

        System.out.println("sumRegion = " + sumRegion);
    }
}
