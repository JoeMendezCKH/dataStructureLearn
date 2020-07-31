package com.joe.beginzero.array.twodimensionalarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author ckh
 * @create 2020/7/31 15:13
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> tempSub = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 第一个位置和最后一个位置的元素为1
                if (j == 0 || j == i) {
                    tempSub.add(1);
                } else {
                    // 上一行的元素进行相加
                    tempSub.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(tempSub);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);

        System.out.println(generate);
    }
}
