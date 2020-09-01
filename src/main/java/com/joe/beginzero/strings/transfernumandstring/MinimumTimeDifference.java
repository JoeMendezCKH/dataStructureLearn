package com.joe.beginzero.strings.transfernumandstring;

import java.util.Arrays;
import java.util.List;

/**
 * 539. Minimum Time Difference
 *
 * @author ckh
 * @create 8/29/20 3:45 PM
 */
public class MinimumTimeDifference {

    /**
     * 作者：qian-li-10
     * 链接：https://leetcode-cn.com/problems/minimum-time-difference/solution/6-ms-by-qian-li-10/
     * 把时间先转化为分钟, 即数字数组，然后针对数字寻找最小的差值（先排序，然后计算相邻之差）
     */
    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int i = 0;
        for (String timePoint : timePoints) {
            int time = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3, 5));
            times[i] = time;
            i++;
        }
        Arrays.sort(times);
        int result = 1440 - times[times.length - 1] + times[0];
        for (int j = 1; j < times.length; j++) {
            if (times[j] - times[j - 1] < result) {
                result = times[j] - times[j - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");

        int minDifference = findMinDifference(timePoints);

        System.out.println("minDifference = " + minDifference);
    }
}
