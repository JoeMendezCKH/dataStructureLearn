package com.joe.beginzero.array.countnums;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 274. H 指数
 *
 * @author ckh
 * @create 2020/7/30 9:19
 */
public class HighIndex {


    /**
     * 排序
     * 将数组按引用次数降序排序
     * 在排完序的数组 citations 中, 如果 citations[i] > i，那么说明第 0 到 i 篇论文都有至少 i+1 次引用
     * 因此我们只要找到最大的 ii 满足 citations[i] > i，那么 h 指数即为 i+1
     */
    public static int hIndex1(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 线性扫描找出最大的 i
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    /**
     * 计数
     * 将 citations[i] > citations.length 的值置为 citations.length
     */
    public static int hIndex2(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c : citations) {
            papers[Math.min(n, c)]++;
        }
        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            k--;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        int i = hIndex1(nums);
        System.out.println("i = " + i);

    }
}
