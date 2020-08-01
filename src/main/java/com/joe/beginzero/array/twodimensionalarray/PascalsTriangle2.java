package com.joe.beginzero.array.twodimensionalarray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 119 杨辉三角 2
 * <p>
 * 返回指定的第 k 行 杨辉三角的内容
 *
 * @author ckh
 * @create 2020/7/31 15:23
 */
public class PascalsTriangle2 {

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            // 通过倒着计算 j 位置的 值, 如果是正序的话, 会影响到后面的计算
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow2(5));

    }

    /**
     * 动态规划
     * 和第一种相同, 用 integer[] 数组替换了 arraylist
     */
    public static List<Integer> getRow3(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }


    /**
     * 数学公式
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }


}
