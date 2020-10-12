package com.joe.beginzero.numberplace;

/**
 * 458. Poor Pigs
 *
 * @author ckh
 * @create 10/12/20 9:55 AM
 */
public class PoorPigs {
    /**
     * https://www.zhihu.com/question/60227816/answer/1274071217
     * 信息论， 我人傻了
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int state = minutesToTest / minutesToDie + 1;

        double v = Math.log10(buckets) / Math.log10((state));
        int ceil = (int) Math.ceil(v);

        System.out.println(v);
        System.out.println("ceil = " + ceil);

        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(3000, 15, 60));

        // 3125
        System.out.println(Math.pow(5, 5));
    }
}
